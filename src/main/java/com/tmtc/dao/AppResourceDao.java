package com.tmtc.dao;

import com.tmtc.po.AppResource;
import com.tmtc.po.AppResourceRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppResourceDao {
    int countByExample(AppResourceRepository example);

    int deleteByExample(AppResourceRepository example);

    int deleteByPrimaryKey(String id);

    int insert(AppResource record);

    int insertSelective(AppResource record);

    List<AppResource> selectByExample(AppResourceRepository example);

    AppResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppResource record, @Param("example") AppResourceRepository example);

    int updateByExample(@Param("record") AppResource record, @Param("example") AppResourceRepository example);

    int updateByPrimaryKeySelective(AppResource record);

    int updateByPrimaryKey(AppResource record);
}