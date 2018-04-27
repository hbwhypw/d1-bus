package com.tmtc.dao;

import com.tmtc.po.CardRecord;
import com.tmtc.po.CardRecordRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardRecordDao {
    int countByExample(CardRecordRepository example);

    int deleteByExample(CardRecordRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(CardRecord record);

    int insertSelective(CardRecord record);

    List<CardRecord> selectByExample(CardRecordRepository example);

    CardRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CardRecord record, @Param("example") CardRecordRepository example);

    int updateByExample(@Param("record") CardRecord record, @Param("example") CardRecordRepository example);

    int updateByPrimaryKeySelective(CardRecord record);

    int updateByPrimaryKey(CardRecord record);
}