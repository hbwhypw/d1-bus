package com.tmtc.controller;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.frame.ServiceException;
import com.tmtc.po.UserDetail;
import com.tmtc.po.UserDetailRepository;
import com.tmtc.service.CompanyService;
import com.tmtc.service.UserDetailService;
import com.tmtc.service.UserService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.PropertiesUtil;
import com.tmtc.utils.VerificationUtil;
import com.tmtc.vo.UserDetailVo;
import com.tmtc.vo.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userAdmin")
public class UserAdminController extends CookieController {
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    UserService userService;
    @Autowired
    CompanyService companyService;

    /**
     * 添加和修改用户信息
     *
     * @throws ServiceException
     */
    @RequestMapping("/{edit}")
    @ResponseBody
    @SystemControllerLog("用户信息-添加和修改")
    public JsonResult edit(HttpServletRequest request, HttpServletResponse response, @PathVariable String edit,
                           @Valid @ModelAttribute UserDetailVo userdetailVo) throws ServiceException {
        if(!vaildLogin(request)){
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        if (edit.equals("add")) {
            // 用户名唯一检查
            UserDetailRepository userDetailRepository = new UserDetailRepository();
            userDetailRepository.or().andUsernameEqualTo(userdetailVo.getUsername());
            if (userDetailService.count(userDetailRepository) > 0) {
                return new JsonResult(0, MessageVar.ADMINS_USERNAME_REPEAT, null);
            }

            // 卡号唯一检查
//            String a = userdetailVo.getCard_num();
            if(!userdetailVo.getCard_num().equals("0")){
            	if(null != userDetailService.selectCard(userdetailVo.getCompany_id(), userdetailVo.getCard_num())){
            		return new JsonResult(0,MessageVar.USER_CARDNUM_REPEAT,null);
            	}
            }
            String id = IdWorker.nextId();
            userdetailVo.setId(id);
            userdetailVo.setIs_check(ParameterConstant.IS_CHECK);
            userdetailVo.setRegister_time(new Date());
            userdetailVo.setRegister_source(ParameterConstant.REGISTER_SOURCE_COMPANY);
            userdetailVo.setExp_score(0);
            userdetailVo.setBalance(0);// 禁用金额修改
            userDetailService.insertVo(userdetailVo);
            return new JsonResult();
        } else if (edit.equals("update")) {
            UserDetailRepository userDetailRepository = new UserDetailRepository();
            userDetailRepository.or()
                    .andUsernameEqualTo(userdetailVo.getUsername())
					.andIdNotEqualTo(userdetailVo.getId());
            if (userDetailService.count(userDetailRepository) > 0) {
                return new JsonResult(0, MessageVar.ADMINS_USERNAME_REPEAT, null);
            }
            userDetailService.update(userdetailVo);
            return new JsonResult();
        }
        return new JsonResult();
    }

	/**
	 * 查询用户信息
	 */
	@RequestMapping("/query")
	@ResponseBody
    @SystemControllerLog("用户信息-查询")
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) String real_name,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String sex,
			@RequestParam(required = false) String company_id){
        if(!vaildLogin(request)){
            return new PageResult(null, null, 2);
        }
        Map<String, String> map = new HashMap<>();
        if (null != page && null != rows) {
            map.put("rowIndex", String.valueOf((page - 1) * rows));
            map.put("pageSize", String.valueOf(rows));
        }
        if (StringUtils.isNotEmpty(real_name)) {
            map.put("real_name", "%" + real_name + "%");
        }
        if (StringUtils.isNotEmpty(username)) {
            map.put("username", "%" + username + "%");
        }
        if (StringUtils.isNotEmpty(sex)) {
            map.put("sex", sex);
        }
        if (StringUtils.isNotEmpty(city)) {
            map.put("city_id", city);
        }
        if (StringUtils.isNotEmpty(company_id)) {
            map.put("company_id", company_id);
        }
        map.put("is_check", "" + ParameterConstant.IS_CHECK);
        List<UserVo> list = userDetailService.selectUser(map);
        int count = userDetailService.countUser(map);
        return new PageResult(count, list, 1);
    }

	/**
	 * 用户信息-查询手机号
	 * @param request
	 * @param response
	 * @param phone
	 * @return
	 */
    @RequestMapping("/selectByPhone")
    @ResponseBody
    @SystemControllerLog("用户信息-查询手机号")
    public JsonResult selectByPhone(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(required = false) String phone) {
        UserDetailRepository userDetailRepository = new UserDetailRepository();
        UserDetailRepository.Criteria criteria = userDetailRepository.createCriteria();
        if (0 != VerificationUtil.length(phone)) {
            if (VerificationUtil.checkMobilePhone(phone)) {
                criteria.andUsernameEqualTo(phone);
                List<UserDetail> listUserDetail = userDetailService.select(userDetailRepository);
                if (0 != VerificationUtil.size(listUserDetail)) {
                    return new JsonResult();
                } else {
                    return new JsonResult(0, PropertiesUtil.getPropertyValue("message", "do.error"), null);
                }
            }
        }
        return new JsonResult(0, PropertiesUtil.getPropertyValue("message", "do.error"), null);
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog("用户信息-删除")
    public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
                             @RequestParam(required = true) String id){
        if(!vaildLogin(request)){
            return new JsonResult(2, JsonResult.FAIL, null);
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setId(id);
        userDetailService.delete(id);
        return new JsonResult();
    }
}
