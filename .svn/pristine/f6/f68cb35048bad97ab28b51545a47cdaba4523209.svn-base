package com.tmtc.dao;

import com.tmtc.po.ShopAdress;
import com.tmtc.po.ShopAdressRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopAdressDao {
    int countByExample(ShopAdressRepository example);

    int deleteByExample(ShopAdressRepository example);

    int deleteByPrimaryKey(String id);

    int insert(ShopAdress record);

    int insertSelective(ShopAdress record);

    List<ShopAdress> selectByExample(ShopAdressRepository example);

    ShopAdress selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopAdress record, @Param("example") ShopAdressRepository example);

    int updateByExample(@Param("record") ShopAdress record, @Param("example") ShopAdressRepository example);

    int updateByPrimaryKeySelective(ShopAdress record);

    int updateByPrimaryKey(ShopAdress record);
}