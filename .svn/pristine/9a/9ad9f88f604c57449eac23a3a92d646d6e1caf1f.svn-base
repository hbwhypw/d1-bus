package com.tmtc.dao;

import com.tmtc.po.UserPush;
import com.tmtc.po.UserPushRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPushDao {
    int countByExample(UserPushRepository example);

    int deleteByExample(UserPushRepository example);

    int deleteByPrimaryKey(String id);

    int insert(UserPush record);

    int insertSelective(UserPush record);

    List<UserPush> selectByExample(UserPushRepository example);

    UserPush selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserPush record, @Param("example") UserPushRepository example);

    int updateByExample(@Param("record") UserPush record, @Param("example") UserPushRepository example);

    int updateByPrimaryKeySelective(UserPush record);

    int updateByPrimaryKey(UserPush record);
}