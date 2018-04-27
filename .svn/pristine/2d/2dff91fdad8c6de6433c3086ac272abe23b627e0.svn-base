package com.tmtc.dao;

import com.tmtc.po.Driver;
import com.tmtc.po.DriverRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverDao {
    int countByExample(DriverRepository example);

    int deleteByExample(DriverRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Driver record);

    int insertSelective(Driver record);

    List<Driver> selectByExample(DriverRepository example);

    Driver selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Driver record, @Param("example") DriverRepository example);

    int updateByExample(@Param("record") Driver record, @Param("example") DriverRepository example);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
}