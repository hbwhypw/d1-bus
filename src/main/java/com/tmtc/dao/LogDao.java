package com.tmtc.dao;

import com.tmtc.po.Log;
import com.tmtc.po.LogRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogDao {
    int countByExample(LogRepository example);

    int deleteByExample(LogRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogRepository example);

    Log selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogRepository example);

    int updateByExample(@Param("record") Log record, @Param("example") LogRepository example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}