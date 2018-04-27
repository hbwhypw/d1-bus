package com.tmtc.service.appAPI;

import java.util.List;

import com.tmtc.po.Driver;
import com.tmtc.po.DriverRepository;
import com.tmtc.service.IService;
import com.tmtc.service.PageService;

public interface DriverAppService extends IService<Driver, DriverRepository>,PageService<DriverRepository>{
	List<Driver> selectByPhone(String phone);
	boolean updatePW(Driver driver);
}
