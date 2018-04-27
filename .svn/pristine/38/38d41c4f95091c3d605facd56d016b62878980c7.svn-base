package com.tmtc.controller;

import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Btn;
import com.tmtc.po.BtnRepository;
import com.tmtc.service.BtnService;
import com.tmtc.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Function: 按钮权限
 *
 * @auther: hbwhypw
 * Date: 2015-11-14 17:15
 */
@Controller
@RequestMapping("/btn")
public class BtnController extends BaseController {
    @Autowired
    BtnService btnService;

    /**
     * 所有按钮
     * @param request
     * @param response
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    public PageResult query(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(required = false) String username) {
        BtnRepository btnRepository = new BtnRepository();
        return new PageResult(btnService.count(btnRepository), btnService.select(btnRepository), 1);
    }

    /**
     * 根据菜单分组显示按钮
     */
    @ResponseBody
    @RequestMapping("/group")
    public JsonResult group(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(required = false) String username) {
        BtnRepository btnRepository = new BtnRepository();
        return new JsonResult(1, JsonResult.SUCCESS, btnService.selectGroupBtn(btnRepository));
    }

    /**
     * 根据权限显示按钮
     * @param btn_ids
     * @param menu_id
     * @return
     */
    @ResponseBody
    @RequestMapping("/show")
    public JsonResult show(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam String btn_ids, @RequestParam String menu_id) {
        List<String> id = new ArrayList<String>(Arrays.asList(btn_ids.split(",")));
        BtnRepository btnRepository = new BtnRepository();
        btnRepository.or().andIdIn(id).andGroup_idEqualTo(menu_id);
        List<Btn> btnList = btnService.select(btnRepository);
        return new JsonResult(1, JsonResult.SUCCESS, btnList);
    }

    /**
     * 按钮编辑
     * @param request
     * @param response
     * @param edit
     * @param btn
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{edit}")
    public JsonResult add(HttpServletRequest request, HttpServletResponse response, @PathVariable String edit,
                          @Valid @ModelAttribute Btn btn, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            handlerErrors(bindingResult);
        }
        if (edit.equals(ADD)) {
            btn.setId(IdWorker.nextId());
            btnService.insert(btn);
        } else if (edit.equals(UPDATE)) {
            btnService.update(btn);
        }
        return new JsonResult();
    }

    /**
     * 删除按钮
     * @param request
     * @param response
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public JsonResult delete(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(required = true) String id) {
        btnService.delete(id);
        return new JsonResult();
    }
}
