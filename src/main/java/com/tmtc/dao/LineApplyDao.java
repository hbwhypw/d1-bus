package com.tmtc.dao;

import com.tmtc.po.LineApply;
import com.tmtc.po.LineApplyRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineApplyDao {
    int countByExample(LineApplyRepository example);

    int deleteByExample(LineApplyRepository example);

    int deleteByPrimaryKey(String id);

    int insert(LineApply record);

    int insertSelective(LineApply record);

    List<LineApply> selectByExample(LineApplyRepository example);

    LineApply selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LineApply record, @Param("example") LineApplyRepository example);

    int updateByExample(@Param("record") LineApply record, @Param("example") LineApplyRepository example);

    int updateByPrimaryKeySelective(LineApply record);

    int updateByPrimaryKey(LineApply record);
}