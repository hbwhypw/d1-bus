package com.tmtc.service.appAPI;

import com.tmtc.po.LineOrder;
import com.tmtc.po.LineOrderRepository;
import com.tmtc.service.IService;
import com.tmtc.service.PageService;

public interface LineOrderAppService extends IService<LineOrder, LineOrderRepository>,PageService<LineOrderRepository>{
//	int add(String userId,Integer city_id,String time_line_id,String station_id);
	LineOrder add(String userId,Integer city_id,String time_line_id);
	LineOrder update(String userId,String time_line_id);
	int select(String userId,String line_time_id);
}
