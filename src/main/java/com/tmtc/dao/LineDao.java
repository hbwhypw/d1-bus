package com.tmtc.dao;

import com.tmtc.po.Line;
import com.tmtc.po.LineRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineDao {
    int countByExample(LineRepository example);

    int deleteByExample(LineRepository example);

    int deleteByPrimaryKey(String id);

    int insert(Line record);

    int insertSelective(Line record);

    List<Line> selectByExampleWithBLOBs(LineRepository example);

    List<Line> selectByExample(LineRepository example);

    Line selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Line record, @Param("example") LineRepository example);

    int updateByExampleWithBLOBs(@Param("record") Line record, @Param("example") LineRepository example);

    int updateByExample(@Param("record") Line record, @Param("example") LineRepository example);

    int updateByPrimaryKeySelective(Line record);

    int updateByPrimaryKeyWithBLOBs(Line record);

    int updateByPrimaryKey(Line record);
    
    int updateLineEndId(String lineId);

}