package com.tmtc.controller.appAPI;

import com.tmtc.po.UserPush;
import com.tmtc.po.UserPushRepository;
import com.tmtc.service.UserPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Function: 百度推送与用户绑定
 * @auther: hbwhypw
 * Date: 2015/10/26 13:48
 */
@Controller
@RequestMapping("/App/push")
public class UserPushAppController extends BaseController {
    @Autowired
    UserPushService userPushService;

    /**
     * 切换是否可推送 "/App/push/switch"
     * @param channelId 通道id
     * @param pushable 是否可推送 0 可推送 1 不可推送
     * @return
     */
    @RequestMapping("/switch")
    @ResponseBody
    public Map<String, Object> switchPushAble(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam String channelId, @RequestParam Integer pushable) {
        UserPushRepository userPushRepository = new UserPushRepository();
        userPushRepository.or().andChannel_idEqualTo(channelId);
        UserPush userPush = new UserPush();
        userPush.setPushable(pushable);
        userPushService.update(userPush, userPushRepository);
        return getMap(request, "成功");
    }
}
