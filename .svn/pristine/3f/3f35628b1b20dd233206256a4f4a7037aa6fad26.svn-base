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

import com.tmtc.excelTools.ExcelUtils;
import com.tmtc.excelTools.JsGridReportBase;
import com.tmtc.excelTools.TableData;
import com.tmtc.frame.PageResult;
import com.tmtc.po.MoneyOrderRepository;
import com.tmtc.service.MoneyOrderService;
import com.tmtc.vo.MoneyOrderVo;

@Controller
@RequestMapping("/moneyOrder")
public class MoneyOrderController {

	@Autowired
	MoneyOrderService moneyOrderService;

	/**
	 * 查询消费记录
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param userName
	 * @param realName
	 * @param payType
	 * @param start
	 * @param end
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping("/query")
	public PageResult query(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = true) Integer page, @RequestParam(required = true) Integer rows, String userName,String realName,
			Integer payType, String start, String end,String company_id) throws ParseException {
		PageResult listVo = moneyOrderService.query(page, rows, userName,realName, payType, start, end,company_id);
		return listVo;
	}
	
	/**
	 * 导出消费记录
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
    	MoneyOrderRepository moneyOrderRepository = new MoneyOrderRepository();
    	MoneyOrderRepository.Criteria criteria = moneyOrderRepository.createCriteria();
    	criteria.andIdIn(listId);
    	List<MoneyOrderVo> list = moneyOrderService.selectById(moneyOrderRepository);
    	String[] hearders = new String[] { "用户名", "真实姓名", "公司名","卡号", "订单号", "消费", "支付方式", "订单状态", "创建时间"};
		String[] fields = new String[] { "userName", "realName", "companyName","card_no", "order_no", "money", "payTypeName","orderStatusName", "create_time"};
		TableData td = ExcelUtils.createTableData(list, ExcelUtils.createTableHeader(hearders), fields);
		JsGridReportBase report = null;
		String title = "消费记录";
		try {
			report = new JsGridReportBase(request, response);
			report.exportToExcel(title, "", td);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
