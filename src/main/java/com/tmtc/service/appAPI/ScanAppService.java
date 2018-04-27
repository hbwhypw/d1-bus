package com.tmtc.service.appAPI;

import com.tmtc.po.LineTime;
import com.tmtc.po.Scan;
import com.tmtc.po.ScanRepository;
import com.tmtc.po.UserDetail;
import com.tmtc.service.IService;
import com.tmtc.service.PageService;

public interface ScanAppService extends IService<Scan, ScanRepository>,PageService<ScanRepository>{
	int insert(String userId,String station_id,String time_line_id);

	int insertLineOrder(UserDetail userDetail, LineTime lineTime, String station_id, int userTypeCompany);
}
