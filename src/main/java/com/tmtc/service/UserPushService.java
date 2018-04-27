package com.tmtc.service;

import com.tmtc.po.UserPush;
import com.tmtc.po.UserPushRepository;

import java.util.List;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/26 14:36
 */
public interface UserPushService extends IService<UserPush, UserPushRepository> {
    int insertOrUpdate(UserPush record);
    String[] selectChannelId(List<String> ids);
    List<UserPush> select(List<String> ids);
    void insertUserPush(String admin_id, String[] userIds, String content);
}
