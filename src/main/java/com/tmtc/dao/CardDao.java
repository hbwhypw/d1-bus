package com.tmtc.dao;

import com.tmtc.po.Card;
import com.tmtc.po.CardRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardDao {
    int countByExample(CardRepository example);

    int deleteByExample(CardRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Card record);

    int insertSelective(Card record);

    List<Card> selectByExample(CardRepository example);

    Card selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardRepository example);

    int updateByExample(@Param("record") Card record, @Param("example") CardRepository example);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}