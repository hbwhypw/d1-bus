package com.tmtc.dao;

import com.tmtc.po.Version;
import com.tmtc.po.VersionRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionDao {
    int countByExample(VersionRepository example);

    int deleteByExample(VersionRepository example);

    int deleteByPrimaryKey(Long id);

    int insert(Version record);

    int insertSelective(Version record);

    List<Version> selectByExample(VersionRepository example);

    Version selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Version record, @Param("example") VersionRepository example);

    int updateByExample(@Param("record") Version record, @Param("example") VersionRepository example);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}