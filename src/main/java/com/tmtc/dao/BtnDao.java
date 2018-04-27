package com.tmtc.dao;

import com.tmtc.po.Btn;
import com.tmtc.po.BtnRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BtnDao {
    int countByExample(BtnRepository example);

    int deleteByExample(BtnRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Btn record);

    int insertSelective(Btn record);

    List<Btn> selectByExample(BtnRepository example);

    Btn selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Btn record, @Param("example") BtnRepository example);

    int updateByExample(@Param("record") Btn record, @Param("example") BtnRepository example);

    int updateByPrimaryKeySelective(Btn record);

    int updateByPrimaryKey(Btn record);

    List<Btn> selectGroupId();
}