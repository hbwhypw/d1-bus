package com.tmtc.service;

import com.tmtc.frame.ServiceException;
import com.tmtc.po.ExpOrder;
import com.tmtc.po.User;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.vo.UserDetailVo;
import com.tmtc.vo.UserVo;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;
import java.util.Map;

public interface UserDetailService
		extends IService<UserDetail, UserDetailRepository>, PageService<UserDetailRepository> {
	int insert(UserDetailVo record, CommonsMultipartFile portrait, CommonsMultipartFile background, String id) throws ServiceException;
    int insertVo(UserDetailVo record);
	int update(UserDetailVo record, CommonsMultipartFile portrait, CommonsMultipartFile background) throws ServiceException;
	int updateQrCode(String id);

	// PageResult selectByPage(UserDetailRepository example,String Company_id);
	int updatePhone(String userid, String phone);

	String updatePhoto(String userid, CommonsMultipartFile file);

	int updatePassWord(User user);

	Map<String, List<String>> img(String id);

	int updateRecover(String id);

	int deleteForEver(String id);

	List<UserVo> selectUser(Map map);

	int countUser(Map map);

	String insertExcel(Map map);
	
	String insertTxt(Map map);

	/**
	 * 减积分
	 * 
	 * @param expOrder
	 * @return
	 */
	int updateExpOrder(ExpOrder expOrder);

	/**
	 * 回滚积分
	 * 
	 * @param orderNum
	 * @return
	 */
	int updateExpOrder(String orderNum);

	List<UserVo> selectUserById(List<String> map);

	/**
	 * 激活
	 * 
	 * @param id
	 * @return
	 */
	int updateInvoke(String id);

	String selectCard(String companyId, String cardNum);
	
	/**
	 * 生成环信id
	 * @return
	 */
	String getLinkNum();
	
	/**
	 * 创建二维码
	 * @param id
	 * @return
	 */
	Map<String, String> createQR_code(String id);
}