package com.tmtc.controller.appAPI;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.ParameterConstant;
import com.tmtc.po.AdPic;
import com.tmtc.po.AdPicRepository;
import com.tmtc.service.AdPicService;
import com.tmtc.service.appAPI.AppLogAppService;
import com.tmtc.utils.IP;
import com.tmtc.utils.VerificationUtil;

/**
 * 广告的查询
 * 
 * @author zxs
 *
 */
@Controller
@RequestMapping("/App/adPic")
public class AdPicAppController extends BaseController {

	private static final String name = "广告或活动访问连接";
	
	@Autowired
	AdPicService adPicService;
	
	@Autowired
	AppLogAppService appLogAppService;

	/**
	 * 访问广告   /App/adPic/url
	 * 
	 * @param request
	 * @param ad_pic_id
	 *            活动id或者广告id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/url")
	public Map<String,Object> selectUrl(HttpServletRequest request, String ad_pic_id) {
		AdPic adPic = adPicService.selectByPrimaryKey(ad_pic_id);
		if(null == adPic){
			return getMap(request, "",0);
		}
		String url = adPic.getUrl();
		String userId = getUserId(request);
		appLogAppService.insert(name, adPic.getId(), userId, IP.getIP(request));
		return getMap(request, "", url);
	}

	/**
	 * 查询所有未过期广告/App/adPic/selectByDate?
	 * 
	 * @param request
	 * @param response
	 * @param type
	 *            广告类型
	 * @param company_id
	 *            公司ID
	 * @return 广告列表
	 */
	@RequestMapping("/selectByDate")
	@ResponseBody
	public Map<String, Object> selectByDate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Integer type, @RequestParam(required = false) String company_id) {
		AdPicRepository adPicRepository = new AdPicRepository();
		AdPicRepository.Criteria criteria = adPicRepository.createCriteria();
		criteria.andEnd_timeGreaterThan(new Date());
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		criteria.andTypeEqualTo(type);
		if (0 < VerificationUtil.length(company_id)) {
			criteria.andCompany_idEqualTo(company_id);
		} else {
			criteria.andCompany_idEqualTo(ParameterConstant.COMPANY_ID);
		}
		List<AdPic> listAdPic = adPicService.select(adPicRepository);
		if(0 == VerificationUtil.size(listAdPic)){
			AdPicRepository adPicRepository2 = new AdPicRepository();
			AdPicRepository.Criteria criteria2 = adPicRepository2.createCriteria();
			criteria2.andEnd_timeGreaterThan(new Date());
			criteria2.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			criteria2.andTypeEqualTo(type);
			criteria2.andCompany_idEqualTo(ParameterConstant.COMPANY_ID);
			List<AdPic> listAdPic2 = adPicService.select(adPicRepository2);
			return getMap(request, "", listAdPic2);
		}
		return getMap(request, "", listAdPic);
	}
	
	/**
	 * 活动	/App/adPic/selectActivity
	 * @param request
	 * @param response
	 * @param page	第几页
	 * @param rows	一页几条数据
	 * @return
	 */
	@RequestMapping("/selectActivity")
	@ResponseBody
	public Map<String, Object> selectActivity(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Integer page,@RequestParam Integer rows) {
		AdPicRepository adPicRepository = new AdPicRepository();
		AdPicRepository.Criteria criteria = adPicRepository.createCriteria();
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		criteria.andTypeEqualTo(ParameterConstant.ADPIC_TYPE_ACTIVITY);
		adPicRepository.setPageSize(rows);
		adPicRepository.setRowIndex((page-1)*rows);
		List<AdPic> listAdPic = adPicService.selectActivity(adPicRepository);
		return getMap(request, "", listAdPic);
	}
}
