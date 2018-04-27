package com.tmtc.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 全局异常处理
 * Created by ypw on 2015/6/28.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public JsonResult ServiceExceptionHandler(Exception ex) {
        JsonResult result = new JsonResult();
        if (ex instanceof ServiceException) {
            result.setCode(((ServiceException) ex).getExceptionEnum().getCode());
            result.setMsg(((ServiceException) ex).getExceptionEnum().getMessage());
            logger.error("##服务层异常，异常说明{}##", ex.getMessage() + ":" + ((ServiceException) ex).getExceptionEnum().getCode());
            logger.error("##服务层异常，异常说明{}##", ex.getStackTrace());
        } else if (ex instanceof SQLException || ex instanceof DataAccessException) {
            result.setCode(100002);
            result.setMsg(String.format("数据库层异常 %s", ex.getCause().getMessage()));
            logger.error("##SQL异常，异常说明: \n类名：{};\n方法名：{}; \n详情：{}##",
            		ex.getStackTrace()[0].getClassName(), 
            		ex.getStackTrace()[0].getMethodName(), 
            		ex.getMessage());
            ex.printStackTrace();
        } else if (ex instanceof IOException) {
            result.setCode(100003);
            result.setMsg("系统输入输出异常");
            result.setMsg(String.format("系统输入输出异常 %s", ex.getCause().getMessage()));
            logger.error("##IO异常，异常说明: \n类名：{};\n方法名：{}; \n详情：{}##",
            		ex.getStackTrace()[0].getClassName(), 
            		ex.getStackTrace()[0].getMethodName(), 
            		ex.getMessage());
            ex.printStackTrace();
        } else if (ex instanceof RuntimeException) {
            result.setCode(100004);
            result.setMsg("RuntimeException异常");
            logger.error("##运行时异常，异常说明: \n类名：{};\n方法名：{}; \n详情：{}##",
            		ex.getStackTrace()[0].getClassName(), 
            		ex.getStackTrace()[0].getMethodName(), 
            		ex.getMessage());
            ex.printStackTrace();
        } else {
            result.setCode(100001);
            result.setMsg(ex.getMessage());
            logger.error("##异常说明{}##", ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }
}
