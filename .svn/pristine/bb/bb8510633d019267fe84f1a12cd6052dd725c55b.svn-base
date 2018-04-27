package com.tmtc.dao;

import com.tmtc.po.Line;
import com.tmtc.po.LineStation;
import com.tmtc.po.LineStationRepository;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineStationDao {
    int countByExample(LineStationRepository example);

    int deleteByExample(LineStationRepository example);

    int deleteByPrimaryKey(String id);

    int insert(LineStation record);

    int insertSelective(LineStation record);

    List<LineStation> selectByExample(LineStationRepository example);

    LineStation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LineStation record, @Param("example") LineStationRepository example);

    int updateByExample(@Param("record") LineStation record, @Param("example") LineStationRepository example);

    int updateByPrimaryKeySelective(LineStation record);

    int updateByPrimaryKey(LineStation record);
    
    int updateBySort(@Param("line_id") String line_id,@Param("sort") Integer sort);
    
    int updateBySortReduction(@Param("line_id") String line_id,@Param("sort") Integer sort);
    
    List<Line> search(@Param("xStart_min") Double xStart_min,@Param("xStart_max") Double xStart_max,@Param("xEnd_min") Double xEnd_min,
    		@Param("xEnd_max") Double xEnd_max,@Param("yStart_min") Double yStart_min,@Param("yStart_max") Double yStart_max,
    		@Param("yEnd_min") Double yEnd_min,@Param("yEnd_max") Double yEnd_max);
    
    List<LineStation> location(@Param("x_min") Double x_min,@Param("x_max") Double x_max,@Param("y_min") Double y_min,@Param("y_max") Double y_max,@Param("line_id") String line_id);
}