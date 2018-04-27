package com.tmtc.service.appAPI;

import com.tmtc.frame.ServiceRuntimeException;
import com.tmtc.po.BaiduTemp;
import com.tmtc.po.BaiduTempRepository;
import com.tmtc.service.IService;
import com.tmtc.service.PageService;

public interface BaiduScanService extends IService<BaiduTemp, BaiduTempRepository>,PageService<BaiduTempRepository>{
	int insert(BaiduTemp baiduTemp,String arrival_time,String depart_time,String param)throws ServiceRuntimeException;
}
