package com.tmtc.annotation;

import com.google.gson.Gson;
import com.tmtc.po.Admins;
import com.tmtc.po.Log;
import com.tmtc.service.LogService;
import com.tmtc.utils.DateUtil;
import com.tmtc.utils.IP;
import com.tmtc.utils.IdWorker;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Function: 日志切面
 * @author hbwhypw
 * Date: 2015/10/22 10:43
 */
@Component
@Aspect
public class SystemLogAspect {
    //注入Service用于把日志保存数据库
    @Resource
    private LogService logService;
    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    //Service层切点
    @Pointcut("@annotation(com.tmtc.annotation.SystemServiceLog)")
    public void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.tmtc.annotation.SystemControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Admins admins = (Admins) session.getAttribute("admins");
        if (admins == null) {
            admins = new Admins();
            admins.setUsername("未登录用户");
        }
        //请求的IP
        String ip = IP.getIP(request);
        try {
            //*========数据库日志=========*//
            Log log = new Log();
            log.setId(IdWorker.nextId());
            log.setDescription(getControllerMethodDescription(joinPoint));
            log.setMethod((joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setType(0);
            log.setIp(ip);
            log.setExceptionCode(null);
            log.setExceptionDetail(null);
            log.setParams(null);
            log.setName(admins.getUsername());
            log.setCreateDate(DateUtil.getCurrentDate());
            //保存数据库
            logService.insert(log);
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("**** controller 前置通知异常 ****");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    @Before("serviceAspect()")
    public void doServiceBefore(JoinPoint joinPoint) {
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Admins admins = (Admins) session.getAttribute("admins");
        if (admins == null) {
            admins = new Admins();
            admins.setUsername("未登录用户");
        }
        //获取请求ip
        String ip = IP.getIP(request);
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        Gson gson = new Gson();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                params += gson.toJson(joinPoint.getArgs()[i]) + ";";
            }
        }
        try {
               /*==========数据库日志=========*/
            Log log = new Log();
            log.setId(IdWorker.nextId());
            log.setDescription(getServiceMthodDescription(joinPoint));
            log.setExceptionCode(e.getClass().getName());
            log.setType(1);
            log.setExceptionDetail(e.getMessage());
            log.setMethod((joinPoint.getTarget().getClass().getSimpleName() + "." + joinPoint.getSignature().getName() + "()"));
            log.setParams(params);
            log.setName(admins.getUsername());
            log.setCreateDate(DateUtil.getCurrentDate());
            log.setIp(ip);
            //保存数据库
            logService.insert(log);
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }
         /*==========记录本地异常日志==========*/
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);

    }


    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public static String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).value();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).value();
                    break;
                }
            }
        }
        return description;
    }
}
