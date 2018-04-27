package com.tmtc.serviceImpl.appAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtc.dao.UserDetailDao;
import com.tmtc.po.UserDetail;
import com.tmtc.service.appAPI.DownEmployeeAppService;
import com.tmtc.utils.VerificationUtil;

@Service
public class DownEmployeeAppServiceImpl implements DownEmployeeAppService {

	@Autowired
	UserDetailDao userDetailDao;
	
	@Override
	public String downEmloyeeAppService(String company_id) {
		
		List<UserDetail> list = userDetailDao.selectEmployee(company_id);
		if (0 == VerificationUtil.size(list)) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		String str = ",";
		String str1 = ";";
		for (UserDetail ud : list) {
			sb.append(changStringNull(ud.getCard_num()));
			sb.append(str);
			sb.append(changStringNull(ud.getLast_order_time()));
			sb.append(str);
			sb.append(changStringNull(ud.getIs_check()));
			sb.append(str);
			sb.append(changStringNull(ud.getUser_type()));
			sb.append(str1);
		}
		return sb.toString();
	}

	private Object changStringNull(Object str){
		return str == null ? "":str;
	}
}
