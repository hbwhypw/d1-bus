package com.tmtc.service;

import java.util.List;
import java.util.Map;

import com.tmtc.frame.PageResult;
import com.tmtc.vo.UpCar;

public interface UpCarService {
	PageResult query(Map<String, Object> map);
	List<UpCar> select(String ids);
}
