package com.tmtc.controller;

import com.tmtc.annotation.SystemControllerLog;
import com.tmtc.constant.ParameterConstant;
import com.tmtc.frame.JsonResult;
import com.tmtc.frame.PageResult;
import com.tmtc.po.Role;
import com.tmtc.po.RoleRepository;
import com.tmtc.service.RoleService;
import com.tmtc.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created:  hbwhypw
 * Date: 2015/9/24 9:35
 * Function: 角色
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;

    /**
     * 角色-查询
     * @param request
     * @param response
     * @param page
     * @param rows
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/query")
    @SystemControllerLog("角色-查询")
    public PageResult query(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer rows,
                            @RequestParam(required = false) String name) {
        RoleRepository roleRepository = new RoleRepository();
        RoleRepository.Criteria criteria = roleRepository.createCriteria();
        if (name != null && !name.isEmpty()){
        	criteria.andNameLike("%"+name+"%");
        }
        criteria.andIs_checkEqualTo(ParameterConstant.IS_CHECK);
        setPageParams(roleRepository, page, rows);
        return roleService.selectByPage(roleRepository);
    }

    /**
     * 角色-菜单权限树
     * @param request
     * @param response
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/tree")
    @SystemControllerLog("角色-菜单权限树")
    public JsonResult tree(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(required = false) String roleId) {
        return new JsonResult(1, JsonResult.SUCCESS, roleService.selectTree(roleId));
    }

    /**
     * 根据角色查询按钮
     * @param roleId 角色编号
     */
    @ResponseBody
    @RequestMapping("/btn")
    @SystemControllerLog("角色-按钮权限")
    public JsonResult btn(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam String roleId) {
        return new JsonResult(1, JsonResult.SUCCESS, roleService.selectBtn(roleId));
    }

    /**
     * 角色-编辑
     * @param request
     * @param response
     * @param edit
     * @param role
     * @param bindingResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{edit}")
    @SystemControllerLog("角色-编辑")
    public JsonResult add(HttpServletRequest request, HttpServletResponse response,@PathVariable String edit,
                          @Valid @ModelAttribute Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            handlerErrors(bindingResult);
        }
        if (edit.equals(ADD)){
            role.setId(IdWorker.nextId());
            roleService.insert(role);
        } else if (edit.equals(UPDATE)){
            roleService.update(role);
        }
        return new JsonResult();
    }

    /**
     * 角色-删除
     * @param request
     * @param response
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    @SystemControllerLog("角色-删除")
    public JsonResult delete(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam String id) {
        Role role = new Role();
        role.setId(id);
        role.setIs_check(ParameterConstant.IS_NOT_CHECK);
        roleService.update(role);
        return new JsonResult();
    }
}
