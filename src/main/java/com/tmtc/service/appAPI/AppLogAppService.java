package com.tmtc.service.appAPI;

import com.tmtc.po.AppLog;
import com.tmtc.po.AppLogRepository;
import com.tmtc.service.IService;
import com.tmtc.service.PageService;

public interface AppLogAppService extends IService<AppLog, AppLogRepository>,PageService<AppLogRepository>{
	int insert(String name,String param,String userId,String ip);
}
