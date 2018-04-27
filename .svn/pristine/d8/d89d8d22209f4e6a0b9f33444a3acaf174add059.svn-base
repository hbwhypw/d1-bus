package com.tmtc.dao;

import com.tmtc.po.MoneyOrder;
import com.tmtc.po.MoneyOrderRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyOrderDao {
    int countByExample(MoneyOrderRepository example);

    int deleteByExample(MoneyOrderRepository example);

    int deleteByPrimaryKey(String id);

    int insert(MoneyOrder record);

    int insertSelective(MoneyOrder record);

    List<MoneyOrder> selectByExample(MoneyOrderRepository example);

    MoneyOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MoneyOrder record, @Param("example") MoneyOrderRepository example);

    int updateByExample(@Param("record") MoneyOrder record, @Param("example") MoneyOrderRepository example);

    int updateByPrimaryKeySelective(MoneyOrder record);

    int updateByPrimaryKey(MoneyOrder record);
}