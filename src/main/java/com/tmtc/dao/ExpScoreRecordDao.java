package com.tmtc.dao;

import com.tmtc.po.ExpScoreRecord;
import com.tmtc.po.ExpScoreRecordRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpScoreRecordDao {
    int countByExample(ExpScoreRecordRepository example);

    int deleteByExample(ExpScoreRecordRepository example);

    int deleteByPrimaryKey(String id);

    int insert(ExpScoreRecord record);

    int insertSelective(ExpScoreRecord record);

    List<ExpScoreRecord> selectByExample(ExpScoreRecordRepository example);

    ExpScoreRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExpScoreRecord record, @Param("example") ExpScoreRecordRepository example);

    int updateByExample(@Param("record") ExpScoreRecord record, @Param("example") ExpScoreRecordRepository example);

    int updateByPrimaryKeySelective(ExpScoreRecord record);

    int updateByPrimaryKey(ExpScoreRecord record);
}