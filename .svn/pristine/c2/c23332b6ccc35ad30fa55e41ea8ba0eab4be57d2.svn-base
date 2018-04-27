package com.tmtc.dao;

import com.tmtc.po.ScanTemp;
import com.tmtc.po.ScanTempRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScanTempDao {
    int countByExample(ScanTempRepository example);

    int deleteByExample(ScanTempRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(ScanTemp record);

    int insertSelective(ScanTemp record);

    List<ScanTemp> selectByExample(ScanTempRepository example);

    ScanTemp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScanTemp record, @Param("example") ScanTempRepository example);

    int updateByExample(@Param("record") ScanTemp record, @Param("example") ScanTempRepository example);

    int updateByPrimaryKeySelective(ScanTemp record);

    int updateByPrimaryKey(ScanTemp record);
}