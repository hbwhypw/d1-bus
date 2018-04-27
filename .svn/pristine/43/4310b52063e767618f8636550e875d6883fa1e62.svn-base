package com.tmtc.service;


import com.tmtc.frame.PageResult;
import com.tmtc.po.Line;
import com.tmtc.po.LineRepository;

public interface LineService extends IService<Line, LineRepository>,PageService<LineRepository> {
	int deleteForEver(String id);
	
	PageResult selectByPage(LineRepository example, Integer page, Integer rows, String line_name, String company_name);
}
