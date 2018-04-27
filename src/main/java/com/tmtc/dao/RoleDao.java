package com.tmtc.dao;

import com.tmtc.po.Role;
import com.tmtc.po.RoleRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {
    int countByExample(RoleRepository example);

    int deleteByExample(RoleRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExampleWithBLOBs(RoleRepository example);

    List<Role> selectByExample(RoleRepository example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleRepository example);

    int updateByExampleWithBLOBs(@Param("record") Role record, @Param("example") RoleRepository example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleRepository example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);
}