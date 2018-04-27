package com.tmtc.dao;

import com.tmtc.po.Resource;
import com.tmtc.po.ResourceRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceDao {
    int countByExample(ResourceRepository example);

    int deleteByExample(ResourceRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceRepository example);

    Resource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceRepository example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceRepository example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}