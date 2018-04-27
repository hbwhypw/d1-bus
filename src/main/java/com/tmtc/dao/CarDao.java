package com.tmtc.dao;

import com.tmtc.po.Car;
import com.tmtc.po.CarRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarDao {
    int countByExample(CarRepository example);

    int deleteByExample(CarRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarRepository example);

    Car selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarRepository example);

    int updateByExample(@Param("record") Car record, @Param("example") CarRepository example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}