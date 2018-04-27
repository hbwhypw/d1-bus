package com.tmtc.dao;

import com.tmtc.po.CarLocation;
import com.tmtc.po.CarLocationRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarLocationDao {
    int countByExample(CarLocationRepository example);

    int deleteByExample(CarLocationRepository example);

    int deleteByPrimaryKey(String id);

    int insert(CarLocation record);

    int insertSelective(CarLocation record);

    List<CarLocation> selectByExample(CarLocationRepository example);

    CarLocation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CarLocation record, @Param("example") CarLocationRepository example);

    int updateByExample(@Param("record") CarLocation record, @Param("example") CarLocationRepository example);

    int updateByPrimaryKeySelective(CarLocation record);

    int updateByPrimaryKey(CarLocation record);
}