package com.tmtc.controller;

import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.Message;
import com.tmtc.po.MessageRepository;
import com.tmtc.service.MessageService;
import com.tmtc.utils.IdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015/10/27 15:52
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {
    @Autowired
    MessageService messageService;

    /**
     * 消息编辑
     * @param request
     * @param response
     * @param edit
     * @param message
     * @return
     * @throws ServiceException
     */
    @ResponseBody
    @RequestMapping("/{edit}")
    public JsonResult edit(HttpServletRequest request, HttpServletResponse response,
                           @PathVariable String edit,
                           @Valid @ModelAttribute Message message) throws ServiceException {
        if (edit.equals("add")) {
            message.setId(IdWorker.nextId());
            message.setCreate_time(new Date());
            messageService.insert(message);
        } else if (edit.equals("update")) {
            String id = message.getId();
            if (StringUtils.isNotEmpty(id)) {
                messageService.update(message);
            } else {
                return new JsonResult(2, JsonResult.FAIL, null);
            }
        }
        return new JsonResult();
    }

    /**
     * 消息删除
     * @param request
     * @param response
     * @param id
     * @return
     * @throws ServiceException
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(required = true) String id) throws ServiceException {
        messageService.delete(id);
        return new JsonResult();
    }

    /**
     * 消息查询
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public PageResult query(HttpServletRequest request, HttpServletResponse response) {
        MessageRepository messageRepository = new MessageRepository();
        PageResult pageResult = messageService.selectByPage(messageRepository);
        return pageResult;
    }

}
