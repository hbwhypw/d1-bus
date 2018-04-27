package com.tmtc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.vo.UserVo;

public interface UserDetailDao {
    int countByExample(UserDetailRepository example);

    int deleteByExample(UserDetailRepository example);

    int deleteByPrimaryKey(String id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    List<UserDetail> selectByExample(UserDetailRepository example);

    UserDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserDetail record, @Param("example") UserDetailRepository example);

    int updateByExample(@Param("record") UserDetail record, @Param("example") UserDetailRepository example);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);

    List<UserVo> selectUser(@Param("map")Map map);

    Integer countUser(@Param("map")Map map);
    
    List<UserVo> selectUserById(@Param("param")List<String> param);
    
    List<UserDetail> selectEmployee(String company_id);
    
    String selectMaxLinkNum();
}