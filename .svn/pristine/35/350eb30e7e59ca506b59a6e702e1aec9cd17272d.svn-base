package com.tmtc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Dictionary;
import com.tmtc.po.DictionaryRepository;
import com.tmtc.service.DictionaryService;
import com.tmtc.utils.IdWorker;
import com.tmtc.utils.VerificationUtil;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
	
	@Autowired
	DictionaryService dictionaryService;
	/**
	 * 添加和修改字典
	 * */
	@RequestMapping("/{edit}")
	@ResponseBody
	public JsonResult insert(HttpServletRequest request,HttpServletResponse response,
			@PathVariable String edit,
			@Valid @ModelAttribute Dictionary dictionary,
			@RequestParam(required = false) Integer code){
		if (edit.equals("add")){
			Dictionary dictionaryRootMax = dictionaryService.selectRootMax();
			dictionary.setId(IdWorker.nextId());
			dictionary.setIs_sub(ParameterConstant.NOT_SUB);
			dictionary.setCode(dictionaryRootMax.getCode()+1);
			dictionary.setSort(dictionaryRootMax.getSort()+1);
			dictionary.setIs_check(ParameterConstant.IS_CHECK);
			dictionaryService.insert(dictionary);
			return new JsonResult();
		}else if (edit.equals("addsub")){
			if(null != code && 0 != code){
				DictionaryRepository dictionaryRepository = new DictionaryRepository();
				DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
				criteria.andCodeEqualTo(code);
				List<Dictionary> list = dictionaryService.select(dictionaryRepository);
				if(null != list && 0 != list.size()){
					Dictionary dictionaryMax = dictionaryService.selectMax(code);
					if(null != dictionaryMax){
						dictionary.setId(IdWorker.nextId());
						dictionary.setIs_sub(ParameterConstant.IS_SUB);
						dictionary.setCode(dictionaryMax.getCode()+1);
						dictionary.setSort(dictionaryMax.getSort()+1);
						dictionary.setIs_check(ParameterConstant.IS_CHECK);
						dictionaryService.insert(dictionary);
						return new JsonResult();
					}else{
						dictionary.setId(IdWorker.nextId());
						dictionary.setIs_sub(ParameterConstant.IS_SUB);
						dictionary.setCode(code*100+1);
						dictionary.setSort(1);
						dictionary.setIs_check(ParameterConstant.IS_CHECK);
						dictionaryService.insert(dictionary);
					}
				}else{
					return new JsonResult(0,MessageVar.DICTIONARY_ADDSUB_NOTROOT,null);
				}
			}else{
				return new JsonResult(0,MessageVar.DICTIONARY_ADDSUB_PLROOT,null);
			}
		}else if (edit.equals("update")){
			dictionaryService.update(dictionary);
			return new JsonResult(1,"修改成功",null);
		}
		return new JsonResult();
	}
	/**
	 * 删除字典
	 * */
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		Dictionary dictionary = new Dictionary();
		dictionary.setId(id);
		dictionary.setIs_check(ParameterConstant.IS_NOT_CHECK);
		dictionaryService.delete(dictionary);
		return new JsonResult();
	}
	/**
	 * 永久删除字典
	 * */
	@RequestMapping("/forEver")
	@ResponseBody
	public JsonResult forEver(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) String id){
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,dictionaryService.deleteForEver(id));
	}
	/**
	 * 查询所有
	 * */
	@RequestMapping("/query")
	@ResponseBody
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer rows,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer is_sub){
		if (page != null && rows != null) {
			DictionaryRepository dictionaryRepository = new DictionaryRepository();
			DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
			dictionaryRepository.setPageSize(rows);
			dictionaryRepository.setRowIndex((page-1)*rows);
			if(null!=name && ""!=name){
				criteria.andNameLike("%"+name+"%");
			}
			if(null!=is_sub){
				criteria.andIs_subEqualTo(is_sub);
			}
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			PageResult pageResult = dictionaryService.selectByPage(dictionaryRepository);
			return pageResult;
		}else{
			return new PageResult(0,null,0);
		}
	}
	/**
	 * dictionary/selectByCode 根据code查询
	 * @param request
	 * @param response
	 * @param code 代码值（int类型）
	 * @return
	 */
	@RequestMapping("/selectByCode")
	@ResponseBody
	public JsonResult selectByCode(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false) Integer code){
		DictionaryRepository dictionaryRepository = new DictionaryRepository();
		DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
		code = code*100;
		criteria.andCodeBetween(code, code+99);
		criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
		List<Dictionary> dictionaryList = dictionaryService.selectByCode(dictionaryRepository);
		return new JsonResult(1,"",dictionaryList);
	}
	
	/**
	 * dictionary/select 查询是否有相同code
	 * @param request
	 * @param response
	 * @param code 代码值（int类型）
	 * @return
	 */
	@RequestMapping("/select")
	@ResponseBody
	public JsonResult select(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false) Integer code){
		if(0 != code && null != code){
			DictionaryRepository dictionaryRepository = new DictionaryRepository();
			DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
			criteria.andCodeEqualTo(code);
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			List<Dictionary> listDictronary = dictionaryService.select(dictionaryRepository);
			if(0 != VerificationUtil.size(listDictronary)){
				return new JsonResult();
			}else{
				return new JsonResult(0,MessageVar.DO_ERROR,null);
			}
		}
		return new JsonResult(0,MessageVar.DO_ERROR,null);
	}
	
	/**
	 * dictionary/selectCode 根据code查找
	 * @param request
	 * @param response
	 * @param code 代码值（int类型）
	 * @return
	 */
	@RequestMapping("/selectCode")
	@ResponseBody
	public JsonResult selectCode(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false) Integer code){
		if(0 != code && null != code){
			DictionaryRepository dictionaryRepository = new DictionaryRepository();
			DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
			criteria.andCodeEqualTo(code);
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			Dictionary dictionary = dictionaryService.select(dictionaryRepository).get(0);
			return new JsonResult(1,"",dictionary);
		}
		return new JsonResult(0,MessageVar.DO_ERROR,null);
	}
	/**
	 * 查询父节点
	 * */
	@RequestMapping("/root")
	@ResponseBody
	public JsonResult root(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer is_sub){
			DictionaryRepository dictionaryRepository = new DictionaryRepository();
			DictionaryRepository.Criteria criteria = dictionaryRepository.createCriteria();
			criteria.andIs_subEqualTo(ParameterConstant.NOT_SUB);
			if(null!=name && ""!=name){
				criteria.andNameLike("%"+name+"%");
			}
			if(null!=is_sub){
				criteria.andIs_subEqualTo(is_sub);
			}
			criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
			JsonResult jsonResult = new JsonResult(1,"",dictionaryService.select(dictionaryRepository));
			return jsonResult;
	}
	
	/**
	 * 恢复使用
	 * @param request
	 * @param response
	 * @param id	字典ID
	 * @return
	 */
	@RequestMapping("/updateRecover")
	@ResponseBody
	public JsonResult updateRecover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String id){
		int a = dictionaryService.updateRecover(id);
		return new JsonResult(1,MessageVar.ISCHECK_SUCCESS,a);
	}
}
