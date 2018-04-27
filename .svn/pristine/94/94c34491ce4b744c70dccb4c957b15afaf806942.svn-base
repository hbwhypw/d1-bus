package com.tmtc.service;

import java.text.ParseException;
import java.util.List;

import com.tmtc.frame.PageResult;
import com.tmtc.po.Scan;
import com.tmtc.po.ScanRepository;
import com.tmtc.vo.ScanVo;

public interface ScanService extends IService<Scan, ScanRepository>,PageService<ScanRepository>{
	PageResult select(Integer page,Integer rows,String userName,String stationName,
			String start,String end)throws ParseException;
	int updateRecover(String id);
	List<ScanVo> selectById(ScanRepository scanRepository); 
}
