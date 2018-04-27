package com.tmtc.dao;

import com.tmtc.po.AppLog;
import com.tmtc.po.AppLogRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppLogDao {
    int countByExample(AppLogRepository example);

    int deleteByExample(AppLogRepository example);

    int deleteByPrimaryKey(String id);

    int insert(AppLog record);

    int insertSelective(AppLog record);

    List<AppLog> selectByExample(AppLogRepository example);

    AppLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppLog record, @Param("example") AppLogRepository example);

    int updateByExample(@Param("record") AppLog record, @Param("example") AppLogRepository example);

    int updateByPrimaryKeySelective(AppLog record);

    int updateByPrimaryKey(AppLog record);
}