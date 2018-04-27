package com.tmtc.controller;

import com.tmtc.frame.BasePage;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.LogRepository;
import com.tmtc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created:  hbwhypw
 * Date: 2015/10/20 17:13
 * Function:
 */
@Controller
@RequestMapping("/log")
public class LogController extends BasePage {
    @Autowired
    LogService logService;

    /**
     * 日志查询
     * @param request
     * @param response
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public PageResult query(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer rows) {
        LogRepository logRepository = new LogRepository();
        logRepository.setOrderByClause("createDate desc");
        setPageParams(logRepository,page,rows);
        return logService.selectByPage(logRepository);
    }

    /**
     * 日志删除
     * @param request
     * @param response
     * @param page
     * @param rows
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer rows,
                            @RequestParam(required = false) String ids) {
        String[] idArr = ids.split(",");
        try {
            logService.delete(idArr);
            return new JsonResult();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new JsonResult();
    }
}
