package com.tmtc.dao;

import com.tmtc.po.AreaAdmin;
import com.tmtc.po.AreaAdminRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaAdminDao {
    int countByExample(AreaAdminRepository example);

    int deleteByExample(AreaAdminRepository example);

    int deleteByPrimaryKey(String id);

    int insert(AreaAdmin record);

    int insertSelective(AreaAdmin record);

    List<AreaAdmin> selectByExample(AreaAdminRepository example);

    AreaAdmin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AreaAdmin record, @Param("example") AreaAdminRepository example);

    int updateByExample(@Param("record") AreaAdmin record, @Param("example") AreaAdminRepository example);

    int updateByPrimaryKeySelective(AreaAdmin record);

    int updateByPrimaryKey(AreaAdmin record);
}