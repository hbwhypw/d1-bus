package com.tmtc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.PageResult;
import com.tmtc.po.MessageRecordRepository;
import com.tmtc.service.MessageRecordService;

@Controller
@RequestMapping("/messageRecord")
public class MessageRecordController extends BaseController{

    @Autowired
    MessageRecordService messageRecordService;

    /**
     * 根据ID消息记录
     * @param request
     * @param response
     * @param page
     * @param rows
     * @param id
     * @return
     */
    @RequestMapping("/selectById")
    @ResponseBody
    public PageResult selectById(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(required = true) Integer page,
                                 @RequestParam(required = true) Integer rows,
                                 @RequestParam String id) {
        MessageRecordRepository messageRecordRepository = new MessageRecordRepository();
        MessageRecordRepository.Criteria criteria = messageRecordRepository.createCriteria();
        criteria.andMessage_idEqualTo(id);
        messageRecordRepository.setOrderByClause("send_time desc");
        setPageParams(messageRecordRepository, page,rows);
        criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        PageResult pageResult = messageRecordService.selectByPage(messageRecordRepository);
        return pageResult;
    }
}
