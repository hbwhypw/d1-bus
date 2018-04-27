package com.tmtc.dao;

import com.tmtc.po.ShopProDiscuss;
import com.tmtc.po.ShopProDiscussRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopProDiscussDao {
    int countByExample(ShopProDiscussRepository example);

    int deleteByExample(ShopProDiscussRepository example);

    int deleteByPrimaryKey(String id);

    int insert(ShopProDiscuss record);

    int insertSelective(ShopProDiscuss record);

    List<ShopProDiscuss> selectByExample(ShopProDiscussRepository example);

    ShopProDiscuss selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopProDiscuss record, @Param("example") ShopProDiscussRepository example);

    int updateByExample(@Param("record") ShopProDiscuss record, @Param("example") ShopProDiscussRepository example);

    int updateByPrimaryKeySelective(ShopProDiscuss record);

    int updateByPrimaryKey(ShopProDiscuss record);
}