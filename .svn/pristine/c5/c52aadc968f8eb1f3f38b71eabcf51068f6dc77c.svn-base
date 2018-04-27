package com.tmtc.dao;

import com.tmtc.po.Message;
import com.tmtc.po.MessageRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageDao {
    int countByExample(MessageRepository example);

    int deleteByExample(MessageRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageRepository example);

    Message selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageRepository example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageRepository example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}