package com.tmtc.dao;

import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineOrderDao {
    int countByExample(LineOrderRepository example);

    int deleteByExample(LineOrderRepository example);

    int deleteByPrimaryKey(String id);

    int insert(LineOrder record);

    int insertSelective(LineOrder record);

    List<LineOrder> selectByExample(LineOrderRepository example);

    LineOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LineOrder record, @Param("example") LineOrderRepository example);

    int updateByExample(@Param("record") LineOrder record, @Param("example") LineOrderRepository example);

    int updateByPrimaryKeySelective(LineOrder record);

    int updateByPrimaryKey(LineOrder record);
    
    int updateByOrderTime(@Param("past") Integer past,@Param("noPay") Integer noPay);
    
    List<LineOrder> selectByOrderTime(@Param("noPay") Integer noPay);
}