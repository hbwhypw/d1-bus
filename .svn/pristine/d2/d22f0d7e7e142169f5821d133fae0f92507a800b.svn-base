package com.tmtc.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmtc.constant.MessageVar;
import com.tmtc.excelTools.ExcelUtils;
import com.tmtc.excelTools.JsGridReportBase;
import com.tmtc.excelTools.TableData;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.ScanRepository;
import com.tmtc.service.ScanService;
import com.tmtc.vo.ScanVo;

@Controller
@RequestMapping("/scan")
public class ScanController {

	@Autowired
	ScanService scanService;
	/**
	 * 查询所有扫描记录
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param userName
	 * @param stationName
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageResult query(HttpServletRequest request,HttpServletResponse response,
			@RequestParam Integer page,
			@RequestParam Integer rows,
			@RequestParam(required = false) String userName,
			@RequestParam(required = false) String stationName,
			@RequestParam(required = false) String start,
			@RequestParam(required = false) String end) throws ParseException{
		PageResult pageResult = scanService.select(page, rows, userName, stationName, start, end);
		return pageResult;
	}
	
	/**
	 * 删除扫描记录
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
	public JsonResult delete(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			if(0 == scanService.delete(id)){
				return new JsonResult(0, MessageVar.DELETE_ERROR, 0);
			}
		}
		return new JsonResult(1,MessageVar.DELETE_SUCCESS,1);
	}
	/**
	 * 恢复
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 */
	@RequestMapping("/updateRecover")
	@ResponseBody
	public JsonResult updateRecover(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String ids){
		String[] idArr = ids.split(",");
		for(String id: idArr){
			if(0 == scanService.updateRecover(id)){
				return new JsonResult(0,MessageVar.ISCHECK_ERROR,0);
			}
		}
		return new JsonResult(1,MessageVar.ISCHECK_SUCCESS,1);
	}
	
	/**
	 * 扫描记录导出
	 * @param request
	 * @param response
	 * @param ids
	 */
	@RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(required = false) String ids) {
		String[] idArr = ids.split(",");
    	List<String> listId = new ArrayList<String>();
    	for (int i = 0; i < idArr.length; i++) {
			listId.add(idArr[i]);
		}
    	ScanRepository scanRepository = new ScanRepository();
    	ScanRepository.Criteria criteria = scanRepository.createCriteria();
    	criteria.andIdIn(listId);
    	List<ScanVo> list = scanService.selectById(scanRepository);
    	String[] hearders = new String[] { "用户名", "站点名称", "创建时间", "状态"};
		String[] fields = new String[] { "userName", "stationName", "create_time", "statusName"};
		TableData td = ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
		JsGridReportBase report = null;
		String title = "扫描记录";
		try {
			report = new JsGridReportBase(request, response);
			report.exportToExcel(title, "", td);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
