package com.tmtc.controller;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.po.*;
import com.tmtc.service.*;
import com.tmtc.utils.BaiduPush.PushUtil;
import com.tmtc.utils.IdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015-11-05 15:50
 */
@Controller
@RequestMapping("/push")
public class UserPushController {
	
    @Autowired
    MessageService messageService;
    
    @Autowired
    MessageRecordService messageRecordService;
    
    @Autowired
    DriverService driverService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserPushService userPushService;

    /**
     * 用户推送
     * @param request
     * @param response
     * @param user_ids
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping("/user")
    public JsonResult user(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam String user_ids, @RequestParam String content) {
        Admins admins = (Admins) request.getSession().getAttribute("admins");
        if (admins == null) {
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        if (StringUtils.isEmpty(content)) {
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        String[] userIds = user_ids.split(",");
        userPushService.insertUserPush(admins.getId(), userIds, content);
        return new JsonResult();
    }

    @ResponseBody
    @RequestMapping("/driver")
    public JsonResult driver(HttpServletRequest request, HttpServletResponse response, @RequestParam String message_id) {

        return new JsonResult();
    }

    /**
     * 发送消息
     *
     * @param user_type 发送类型 1401 集团用户, 1402 学生用户, 1403 普通用户,1404 家长用户 1405 司机用户
     * @return
     */
    @ResponseBody
    @RequestMapping("/send")
    public JsonResult send(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam Integer user_type, @RequestParam String message_id) {
        if (user_type == null) {
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        Admins admins = (Admins) request.getSession().getAttribute("admins");
        if (admins == null) {
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        if (StringUtils.isEmpty(message_id)) {
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        Message message = messageService.selectByPrimaryKey(message_id);
        String admin_id = admins.getId();
        MessageRecord messageRecord;
//        List<MessageRecord> listRecord = new ArrayList<>();
        switch (user_type) {
            case ParameterConstant.USER_TYPE_COMPANY: // todo  企业
                UserRepository userRepository = new UserRepository();
                userRepository.or().andUser_typeEqualTo(ParameterConstant.USER_TYPE_COMPANY);
                List<User> userList = userService.select(userRepository);
                List<String> user_ids = new ArrayList<String>();
                for (User user : userList) {
                    String id = user.getId();
                    user_ids.add(id);
                    messageRecord = new MessageRecord(IdWorker.nextId(), message_id, admin_id, id, new Date(), ParameterConstant.IS_CHECK);
                    //  插入消息记录
                    messageRecordService.insert(messageRecord);
                }
                //  根据司机id查询到对应的百度推送通道id
                List<UserPush> list = userPushService.select(user_ids);
                //  根据通道id 推送
                if(list.size() == 0){
                    return new JsonResult(2, JsonResult.FAIL, null);
                }
                PushUtil.pushHandle(list, message);
                break;
            case ParameterConstant.USER_TYPE_DRIVER:// todo 司机
                PushUtil.pushHandle(message);
                messageRecord = new MessageRecord(IdWorker.nextId(), message_id, admin_id, "0", new Date(), ParameterConstant.IS_CHECK);
                //  插入消息记录
                messageRecordService.insert(messageRecord);
                break;
            case ParameterConstant.USER_TYPE_NORMAL:// todo 普通用户
                break;
            case ParameterConstant.USER_TYPE_STUDENT:// todo 学生用户
                break;
            default:
                return new JsonResult(2, JsonResult.FAIL, null);
        }
        return new JsonResult();
    }
}
