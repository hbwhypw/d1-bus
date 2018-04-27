package com.tmtc.dao;

import com.tmtc.po.VerificationCode;
import com.tmtc.po.VerificationCodeRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerificationCodeDao {
    int countByExample(VerificationCodeRepository example);

    int deleteByExample(VerificationCodeRepository example);

    int deleteByPrimaryKey(String id);

    int insert(VerificationCode record);

    int insertSelective(VerificationCode record);

    List<VerificationCode> selectByExample(VerificationCodeRepository example);

    VerificationCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VerificationCode record, @Param("example") VerificationCodeRepository example);

    int updateByExample(@Param("record") VerificationCode record, @Param("example") VerificationCodeRepository example);

    int updateByPrimaryKeySelective(VerificationCode record);

    int updateByPrimaryKey(VerificationCode record);
}