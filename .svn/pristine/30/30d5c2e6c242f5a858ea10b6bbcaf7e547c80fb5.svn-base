package com.tmtc.serviceImpl;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.dao.MessageDao;
import com.tmtc.dao.MessageRecordDao;
import com.tmtc.dao.UserPushDao;
import com.tmtc.po.Message;
import com.tmtc.po.MessageRecord;
import com.tmtc.po.UserPush;
import com.tmtc.po.UserPushRepository;
import com.tmtc.service.UserPushService;
import com.tmtc.utils.BaiduPush.PushUtil;
import com.tmtc.utils.IdWorker;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Function:
 * @auther: hbwhypw
 * Date: 2015/10/26 14:37
 */
@Service
public class UserPushServiceImpl implements UserPushService {
    @Autowired
    MessageDao messageDao;
    @Autowired
    MessageRecordDao messageRecordDao;
    @Autowired
    UserPushDao userPushDao;
    @Override
    public int count(UserPushRepository example) {
        return userPushDao.countByExample(example);
    }

    @Override
    public int delete(String id) {
        return userPushDao.deleteByPrimaryKey(id);
    }

    @Override
    public int delete(UserPushRepository example) {
        return userPushDao.deleteByExample(example);
    }

    @Override
    public int insert(UserPush record) {
        return userPushDao.insert(record);
    }

    @Override
    public List<UserPush> select(UserPushRepository example) {
        return userPushDao.selectByExample(example);
    }

    @Override
    public UserPush selectByPrimaryKey(String id) {
        return userPushDao.selectByPrimaryKey(id);
    }

    @Override
    public int update(UserPush record) {
        return userPushDao.updateByPrimaryKey(record);
    }

    @Override
    public int update(UserPush record, UserPushRepository example) {
        return userPushDao.updateByExampleSelective(record, example);
    }

    @Override
    public int insertOrUpdate(UserPush record) {
        UserPushRepository userPushRepository = new UserPushRepository();
        userPushRepository.or().andUser_idEqualTo(record.getUser_id());
        // 判断是否已添加，未添加的添加，已添加的修改
        if (userPushDao.countByExample(userPushRepository) == 0) {
            return userPushDao.insertSelective(record);
        } else {
            return userPushDao.updateByExampleSelective(record, userPushRepository);
        }
    }

    /**
     * 根据用户id获取通道id
     * @param  ids 用户id List<String>
     * @return channel_ids 通道id String[]
     */
    public String[] selectChannelId(List<String> ids) {
        String[] channel_ids = new String[ids.size()];
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.get(i);
            UserPushRepository userPushRepository = new UserPushRepository();
            userPushRepository.or().andUser_idEqualTo(id);
            List<UserPush> userPushList = userPushDao.selectByExample(userPushRepository);
            String channel_id = userPushList.get(0).getChannel_id();
            channel_ids[i] = channel_id;
        }
        return channel_ids;
    }

    public List<UserPush> select(List<String> ids){
        List<UserPush> list = new ArrayList<>();
        for (String id : ids) {
            UserPushRepository userPushRepository = new UserPushRepository();
            userPushRepository.or().andUser_idEqualTo(id);
            List<UserPush> userPushList = userPushDao.selectByExample(userPushRepository);
            if (userPushList.size() != 0) {
                list.add(userPushList.get(0));
            }
        }
        return list;
    }


    public void insertUserPush(String admin_id, String[] userIds, String content){
        String message_id = IdWorker.nextId();
        Message message = new Message(message_id, "系统消息", content, 1, new Date());
        messageDao.insert(message);
        List<String> userIdList = new ArrayList<String>();
        for (String s : userIds) {
            userIdList.add(s);
            MessageRecord messageRecord = new MessageRecord(IdWorker.nextId(), message_id, admin_id, s, new Date(), ParameterConstant.IS_CHECK);
            //  插入消息记录
            messageRecordDao.insert(messageRecord);
        }
        List<UserPush> list = select(userIdList);
        //  根据通道id 推送
        PushUtil.pushHandle(list, message);
    }
}
