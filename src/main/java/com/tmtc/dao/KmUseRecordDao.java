package com.tmtc.dao;

import com.tmtc.po.KmUseRecord;
import com.tmtc.po.KmUseRecordRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KmUseRecordDao {
    int countByExample(KmUseRecordRepository example);

    int deleteByExample(KmUseRecordRepository example);

    int deleteByPrimaryKey(String id);

    int insert(KmUseRecord record);

    int insertSelective(KmUseRecord record);

    List<KmUseRecord> selectByExample(KmUseRecordRepository example);

    KmUseRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") KmUseRecord record, @Param("example") KmUseRecordRepository example);

    int updateByExample(@Param("record") KmUseRecord record, @Param("example") KmUseRecordRepository example);

    int updateByPrimaryKeySelective(KmUseRecord record);

    int updateByPrimaryKey(KmUseRecord record);
}