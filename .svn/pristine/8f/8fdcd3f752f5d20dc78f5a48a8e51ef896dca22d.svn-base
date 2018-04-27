package com.tmtc.dao;

import com.tmtc.po.Company;
import com.tmtc.po.ExpOrder;
import com.tmtc.po.ExpOrderRepository;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpOrderDao {
    int countByExample(ExpOrderRepository example);

    int deleteByExample(ExpOrderRepository example);

    int deleteByPrimaryKey(String id);

    int insert(ExpOrder record);

    int insertSelective(ExpOrder record);

    List<ExpOrder> selectByExample(ExpOrderRepository example);

    ExpOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ExpOrder record, @Param("example") ExpOrderRepository example);

    int updateByExample(@Param("record") ExpOrder record, @Param("example") ExpOrderRepository example);

    int updateByPrimaryKeySelective(ExpOrder record);

    int updateByPrimaryKey(ExpOrder record);
    
    Company selectCompanyById(@Param("pro_id") String pro_id);
}