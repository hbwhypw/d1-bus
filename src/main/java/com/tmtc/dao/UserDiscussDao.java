package com.tmtc.dao;

import com.tmtc.po.UserDiscuss;
import com.tmtc.po.UserDiscussRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDiscussDao {
    int countByExample(UserDiscussRepository example);

    int deleteByExample(UserDiscussRepository example);

    int deleteByPrimaryKey(String id);

    int insert(UserDiscuss record);

    int insertSelective(UserDiscuss record);

    List<UserDiscuss> selectByExample(UserDiscussRepository example);

    UserDiscuss selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserDiscuss record, @Param("example") UserDiscussRepository example);

    int updateByExample(@Param("record") UserDiscuss record, @Param("example") UserDiscussRepository example);

    int updateByPrimaryKeySelective(UserDiscuss record);

    int updateByPrimaryKey(UserDiscuss record);
}