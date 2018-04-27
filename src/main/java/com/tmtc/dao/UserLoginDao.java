package com.tmtc.dao;

import com.tmtc.po.UserLogin;
import com.tmtc.po.UserLoginRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

public interface UserLoginDao {
    int countByExample(UserLoginRepository example);

    int deleteByExample(UserLoginRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    List<UserLogin> selectByExample(UserLoginRepository example);

    UserLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLogin record, @Param("example") UserLoginRepository example);

    int updateByExample(@Param("record") UserLogin record, @Param("example") UserLoginRepository example);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
    
    List<UserLogin> selectBySession(String session);
}