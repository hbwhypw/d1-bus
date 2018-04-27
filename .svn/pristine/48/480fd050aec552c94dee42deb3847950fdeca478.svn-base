package com.tmtc.dao;

import com.tmtc.po.Company;
import com.tmtc.po.CompanyRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyDao {
    int countByExample(CompanyRepository example);

    int deleteByExample(CompanyRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExampleWithBLOBs(CompanyRepository example);

    List<Company> selectByExample(CompanyRepository example);

    Company selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyRepository example);

    int updateByExampleWithBLOBs(@Param("record") Company record, @Param("example") CompanyRepository example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyRepository example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);
}