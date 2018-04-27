package com.tmtc.dao;

import com.tmtc.po.LineTime;
import com.tmtc.po.LineTimeRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineTimeDao {
    int countByExample(LineTimeRepository example);

    int deleteByExample(LineTimeRepository example);

    int deleteByPrimaryKey(String id);

    int insert(LineTime record);

    int insertSelective(LineTime record);

    List<LineTime> selectByExample(LineTimeRepository example);

    LineTime selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LineTime record, @Param("example") LineTimeRepository example);

    int updateByExample(@Param("record") LineTime record, @Param("example") LineTimeRepository example);

    int updateByPrimaryKeySelective(LineTime record);

    int updateByPrimaryKey(LineTime record);
}