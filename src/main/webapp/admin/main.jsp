<%@ page import="com.tmtc.po.Admins" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store, must-revalidate">
<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">
<meta http-equiv="expires" content="0">
<title>欢迎使用嘀一巴士管理系统</title>
<link rel="stylesheet" type="text/css" href="/dist/lib/easyui/themes/bootstrap/easyui.css" id="swicth-style">
<link rel="stylesheet" type="text/css" href="/dist/lib/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/dist/css/main.css">
<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.css" />
</head>

<body class="easyui-layout">
	<div region="north" border="true" class="cs-north">
		<div class="cs-north-bg">
			<div class="cs-north-logo">嘀一巴士管理系统</div>
            <% Admins admin = (Admins)request.getSession().getAttribute("admins"); %>
            <% if(admin==null) response.sendRedirect("index.jsp");%>
 			<div id="welcome" class="cs-north-welcome" role="<%=admin!=null?admin.getRole_id():"" %>">
                <span class="welcome-text" id="userName">欢迎光临，
                     <label style="font-weight: 600"><%=admin!=null?admin.getNick_name():"" %></label>
                </span>
                <a id="pwd" class="easyui-linkbutton" plain="true" href="javascript:void(0)">修改密码</a>
                <a class="easyui-linkbutton" plain="true" href="/admins/logout">安全退出</a>
            </div>
		</div>
	</div>
	<div region="west" border="true" split="true" title="菜单栏" class="cs-west">
		<div id="left-menu" class="easyui-accordion" fit="true" border="false">
            菜单加载中……
		</div>
	</div>
	<div id="mainPanle" region="center" border="true" border="false">
		 <div id="tabs" class="easyui-tabs" fit="true" border="false" data-options="onClose: tabClose,onAdd: tabAdd">
            <div title="Home">
				<div class="cs-home-remark">
                    欢迎使用嘀一巴士班车管理系统
				</div>
			</div>
        </div>
	</div>
	<div region="south" border="false" id="south"><center>嘀一科技@2015</center></div>
    <div id="updatePasswordDlg" class="easyui-dialog" style="width:400px;height:290px;padding:20px;"
         data-options="resizable:true,modal:true" closed="true" buttons="#updatePasswordDlgBtn">
        <div class="ftitle">
            管理员信息
        </div>
        <form id="updatePasswordFm" class="fm" method="post" novalidate>
            <div class="fitem">
                <label> 原来密码： </label>
                <input id="oldPassword" name="oldPassword" class="easyui-validatebox" validType="username" required="true">
            </div>
            <div class="fitem">
                <label> 修改密码： </label>
                <input id="newPassword" name="newPassword" type="password" class="easyui-validatebox" validType="username" required="true">
            </div>
            <div class="fitem">
                <label> 确认密码： </label>
                <input id="repassword" name="repassword" type="password" class="easyui-validatebox" validType="equals['#newPassword']" required="true">
            </div>
        </form>
        <div id="updatePasswordDlgBtn">
            <a href="#" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
        </div>
    </div>
    <script type="text/javascript" src="/dist/lib/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/dist/lib/art-template/template.min.js"></script>
    <script type="text/javascript" src="/dist/lib/art-template/template-syntax.js"></script>
    <script type="text/javascript" src="/dist/js/main.js"></script>
    <script type="text/javascript" src="/dist/lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/dist/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/dist/lib/My97DatePicker/WdatePicker.js" ></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=3315b6f159e4daff64533606d1c4bf76"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <!--加载检索信息窗口-->
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.js"></script>
    <script id="menus_tmpl" type="text/html">
        {each data as item index}
        {if index==0}
        <div title="{ item.name }" selected="true">
            {include 'sub_menus_tmpl' item}
        </div>
        {else}
        <div title="{ item.name }">
            {include 'sub_menus_tmpl' item}
        </div>
        {/if}
        {/each}
    </script>

    <script id="sub_menus_tmpl" type="text/html">
        {each children as subListItem subListIndex}
        <li class="menuItem">
            <a href="javascript:void(0);" src="subpages{ url }{ subListItem.url }" option-id="{ subListItem.id }" class="cs-navi-tab">
                {subListItem.name}
            </a>
        </li>
        {/each}
    </script>

    <script id="fieldset_tmpl" type="text/html">
        {each data as item index}
            <fieldset id="{ item.group_id }">
                <legend>{ item.group_name }：</legend>
                {include 'checkbox_tmpl' item}
            </fieldset>
        {/each}
    </script>

    <script id="checkbox_tmpl" type="text/html">
        {each children as checkboxItem checkboxIndex}
            <input id="{ checkboxItem.btn_id }" type="checkbox" name="{ checkboxItem.btn_id }" data-options="{ checkboxItem.id }"/>
            <label for="{ checkboxItem.btn_id }">{ checkboxItem.btn_name }</label>
        {/each}
    </script>

    <script id="btn_tmpl" type="text/html">
        {each data as item index}
            <a id="{item.btn_id}" class="easyui-linkbutton" href="javascript:void(0);" plain="true">{item.btn_name}</a>
        {/each}
    </script>
</body>
</html>