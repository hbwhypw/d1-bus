package com.tmtc.utils.BaiduPush;

import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.constant.PushEnum;
import com.tmtc.po.Message;
import com.tmtc.po.UserPush;

import java.util.List;

/**
 * Function:
 *
 * @auther: hbwhypw
 * Date: 2015-11-05 14:36
 */
public class PushHandle {

    public void push(List<UserPush> list, Message message) {
        String title = message.getTitle();
        String content = message.getContent();
        try {
            for (UserPush userPush : list) {
                if (userPush.getPushable() == 0) {
                    String channel_id = userPush.getChannel_id();
                    if (PushEnum.DeviceType.Android.equals(userPush.getDevice_type())) {
                        PushUtil.AndroidPushMsgToSingleDevice(channel_id, title, content);
                    } else if (PushEnum.DeviceType.IOS.equals(userPush.getDevice_type())) {
                        PushUtil.IOSPushNotificationToSingleDevice(channel_id, title, content);
                    }
                }
            }
        } catch (PushClientException | PushServerException e) {
            e.printStackTrace();
        }
    }
}
