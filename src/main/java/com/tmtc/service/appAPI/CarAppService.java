package com.tmtc.service.appAPI;

import com.tmtc.po.Car;
import com.tmtc.po.CarRepository;
import com.tmtc.service.IService;
import com.tmtc.service.PageService;

public interface CarAppService extends IService<Car, CarRepository>,PageService<CarRepository>{
	int updateSeat(String lineTimeId);
}
