package com.tmtc.dao;

import com.tmtc.po.ArrivalTime;
import com.tmtc.po.ArrivalTimeRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrivalTimeDao {
    int countByExample(ArrivalTimeRepository example);

    int deleteByExample(ArrivalTimeRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(ArrivalTime record);

    int insertSelective(ArrivalTime record);

    List<ArrivalTime> selectByExample(ArrivalTimeRepository example);

    ArrivalTime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArrivalTime record, @Param("example") ArrivalTimeRepository example);

    int updateByExample(@Param("record") ArrivalTime record, @Param("example") ArrivalTimeRepository example);

    int updateByPrimaryKeySelective(ArrivalTime record);

    int updateByPrimaryKey(ArrivalTime record);
}