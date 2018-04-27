package com.tmtc.dao;

import com.tmtc.po.MessageRecord;
import com.tmtc.po.MessageRecordRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageRecordDao {
    int countByExample(MessageRecordRepository example);

    int deleteByExample(MessageRecordRepository example);

    int deleteByPrimaryKey(String id);

    int insert(MessageRecord record);

    int insertSelective(MessageRecord record);

    List<MessageRecord> selectByExample(MessageRecordRepository example);

    MessageRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MessageRecord record, @Param("example") MessageRecordRepository example);

    int updateByExample(@Param("record") MessageRecord record, @Param("example") MessageRecordRepository example);

    int updateByPrimaryKeySelective(MessageRecord record);

    int updateByPrimaryKey(MessageRecord record);
}