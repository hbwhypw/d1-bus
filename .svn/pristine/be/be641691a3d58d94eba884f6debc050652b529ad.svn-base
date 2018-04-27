package com.tmtc.service;


import java.util.List;

import com.tmtc.frame.PageResult;
import com.tmtc.po.Line;
import com.tmtc.po.LineStation;
import com.tmtc.po.LineStationRepository;

public interface LineStationService extends IService<LineStation, LineStationRepository>,PageService<LineStationRepository> {
	List<Line> search(Double xStart,Double yStart,Double xEnd,Double yEnd,Integer page,Integer rows,String date);
	
	PageResult query(String line_name, String station_name, Integer page, Integer rows);
	
	int deleteForEver(String id);
	
	LineStation location(Double x_min,Double x_max,Double y_min,Double y_max,String line_id);
}
