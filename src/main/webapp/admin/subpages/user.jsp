<%@page import="com.tmtc.po.Admins"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/head.jsp" %>
</head>
<body>
<script type="text/javascript" src="/dist/js/subPages/userDetail.js"></script>
<table id="userDetailVoDg" class="easyui-datagrid" data-options="url:'./../userDetail/query',rownumbers:true,
        toolbar:'#userDetailVoDgTbar', pageSize:20,pagination:true,striped:true,fit:true,fitColumns: true,
        singleSelect: false,selectOnCheck: false,onClickRow: userDetailVo.onClickRow, rowStyler: userDetailVo.rowStyler">
    <thead>
    <tr>
        <th data-options="checkbox:true"></th>
        <th data-options="field:'id',width:80">用户ID</th>
        <th data-options="field:'username',width:80,formatter: userDetailVo.usernameFormatter">用户名</th>
        <th data-options="field:'real_name',width:80">真实姓名</th>
        <th data-options="field:'number',width:80">员工号/学号</th>
        <th data-options="field:'nick_name',width:80">昵称</th>
        <th data-options="field:'link_num',width:80">关联账号</th>
        <th data-options="field:'city_name',width:80">所属城市</th>
        <th data-options="field:'company_name',width:80">所属公司</th>
        <th data-options="field:'register_source_name',width:80">注册来源</th>
        <th data-options="field:'register_time',width:80">注册时间</th>
        <th data-options="field:'login_source_name',width:80">登录来源</th>
        <th data-options="field:'login_time',width:80">登录时间</th>
        <th data-options="field:'login_cnt',width:80">登录次数</th>
        <th data-options="field:'lock_time',width:80">锁定时间</th>
        <th data-options="field:'lock_cnt',width:80">锁定次数</th>
        <th data-options="field:'qr_code',width:80">二维码</th>
        <th data-options="field:'qr_code_secret',width:80">二维码密钥</th>
        <th data-options="field:'user_type_name',width:80">用户类型</th>
        <th data-options="field:'sex_name',width:80">性别</th>
        <th data-options="field:'id_code',width:80,formatter: userDetailVo.id_codeFormatter">身份证号</th>
        <th data-options="field:'birthday',width:80">生日</th>
        <th data-options="field:'email',width:80">邮箱</th>
        <th data-options="field:'address',width:80">地址</th>
        <th data-options="field:'card_num',width:80">剩余公里数</th>
        <th data-options="field:'exp_score',width:80">积分</th>
        <th data-options="field:'invitation_code',width:80">邀请码</th>
        <th data-options="field:'last_order_time',width:80">最后下单时间</th>
        <th data-options="field:'remark',width:80">备注</th>
        <th data-options="field:'is_check',width:10,formatter: userDetailVo.is_checkFormatter">有效</th>
    </tr>
    </thead>
</table>
<div id="userDetailVoDgTbar">
    <table width="100%">
        <tr>
            <td align="left">
                &nbsp;&nbsp;真实姓名：&nbsp;&nbsp;
                <input id="real_nameParam" name="real_name" class="easyui-validatebox" style="width: 150px;">
                &nbsp;&nbsp;用户名：&nbsp;&nbsp;
                <input id="usernameParam" name="username" class="easyui-validatebox" style="width: 150px;">
               	 &nbsp;&nbsp;所属公司：&nbsp;&nbsp;
               	<input id="company_idParam" class="easyui-combobox" name="company_id" data-options="
									valueField:'id',textField:'name',url:'./../company/query',
									loader: common.comboBoxLoaderPage, editable: false,
									onBeforeLoad: function(param){
										param.page = 1;param.rows = 100; 
									} " style="width: 150px;"/>
            </td>
            <td align="right" width="550px">
                <a id="look" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-search" plain="true">查看图片</a>
                <a id="resetqrcode" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-edit" plain="true">重置二维码</a>
                <a id="resetpwd" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-edit" plain="true">重置密码</a>
                <a id="recover" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-edit" plain="true">恢复使用</a>
            </td>
            <td align="right" width="10px">&nbsp;</td>
        </tr>
        <tr>
            <td align="left">
                &nbsp;&nbsp;所属城市：&nbsp;&nbsp;${sessionScope.admins.username}
                <input id="cityParam" class="easyui-combobox" name="cityParam" data-options="
                    valueField:'code',textField:'name',url:'./../dictionary/selectByCode?code=10',
                    editable: false,loader: common.comboBoxLoader" style="width: 154px;"/>
                &nbsp;&nbsp;性&nbsp; &nbsp;别：&nbsp;&nbsp;
                <input id="sexParam" class="easyui-combobox" name="sexParam" data-options="
                    valueField:'code',textField:'name',url:'./../dictionary/selectByCode?code=13',
                    editable: false,loader: common.comboBoxLoader" style="width: 154px;"/>
                <a id="query" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-search" plain="true">查 询</a>
                <a id="import" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-excel" plain="true">导 入</a>
                <a id="export" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-excel" plain="true">导 出</a>
                <a id="push" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-excel" plain="true">推 送</a>
            </td>
            <td align="right" width="550px">
                <a id="add" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-add" plain="true">添加</a>
                <a id="update" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-edit" plain="true">修改</a>
                <a id="delete" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-remove" plain="true">删除</a>
                <a id="forEver" class="easyui-linkbutton" href="javascript:void(0);" iconCls="icon-remove" plain="true">永久删除</a>
            </td>
            <td align="right" width="10px">&nbsp;</td>
        </tr>
    </table>
</div>
<div id="userDetailVoDlg" class="easyui-dialog" style="width:450px;height:660px;padding:20px"
     data-options="resizable:true,modal:true" closed="true" buttons="#userDetailVoDlgBtn">
    <form id="userDetailVoFm" class="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label> 关联账号： </label>
            <input id="id" name="id" type="hidden">
            <input id="link_num" name="link_num" class="easyui-validatebox">
        </div>
        <div class="fitem">
            <label> 所属城市： </label>
            <input id="city_id" class="easyui-combobox" name="city_id" data-options="
								valueField:'code',textField:'name',url:'./../dictionary/selectByCode?code=10',
								editable:false,
								loader: common.comboBoxLoader" required="true"/>
        </div>
        <div class="fitem">
            <label> 所属公司： </label>
            <input id="company_id" class="easyui-combobox" name="company_id" data-options="
									valueField:'id',textField:'name',url:'./../company/query',
									editable:false,
									loader: common.comboBoxLoaderPage,
									onBeforeLoad: function(param){
										param.page = 1;param.rows = 100; 
									} " required="true"/>
        </div>
        <div class="fitem">
            <label> 员工号： </label>
            <input id="number" name="number" class="easyui-validatebox" required="true"
                   data-options="validType: ['maxLength[18]','specialChar']">
        </div>
        <div class="fitem">
            <label> 用户名： </label>
            <input id="username" name="username" class="easyui-validatebox"
                   data-options="validType: ['maxLength[18]', 'specialChar']">
        </div>
        <div class="fitem">
            <label> 昵称： </label>
            <input id="nick_name" name="nick_name" class="easyui-validatebox"
                   data-options="validType: ['maxLength[18]', 'specialChar']">
        </div>
        <div class="fitem">
            <label> 真实姓名： </label>
            <input id="real_name" name="real_name" class="easyui-validatebox" required="true"
                   data-options="validType: ['maxLength[18]', 'specialChar']">
        </div>
        <div class="fitem">
            <label> 性别： </label>
            <input id="sex" class="easyui-combobox" name="sex" data-options="
								valueField:'code',textField:'name',url:'./../dictionary/selectByCode?code=13',
								editable:false,
								loader: common.comboBoxLoader" required="true"/>
        </div>
        <div class="fitem">
            <label> 身份证： </label>
            <input id="id_code" name="id_code" class="easyui-validatebox" data-options="validType: 'equalsLength[18]'">
        </div>
        <div class="fitem">
            <label> 生日： </label>
            <input id="birthday" name="birthday" class="Wdate" type="text" style="width: 172px"
                   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
        </div>
        <div class="fitem">
            <label> 用户类型： </label>
            <input id="user_type" class="easyui-combobox" name="user_type" data-options="
								valueField:'code',textField:'name',url:'./../dictionary/selectByCode?code=14',
								editable:false,
								loader: common.comboBoxLoader" required="true"/>
        </div>
        <div class="fitem">
          	<label> 头像： </label>
        	<input id="portrait" name="portraitUrl" type="file">
       	</div>
       	<div class="fitem">
          	<label> 背景图片： </label>
        	<input id="background" name="backgroundUrl" type="file">
       	</div>
       	<div class="fitem">
            <label> 邮箱： </label>
            <input id="email" name="email" class="easyui-validatebox"
                   data-options="required:true,validType: ['email', 'maxLength[50]']" />
        </div>
        <div class="fitem">
            <label> 地址： </label>
            <input id="address" name="address" class="easyui-validatebox"
                   data-options="validType: ['maxLength[200]', 'specialChar']">
        </div>
        <div class="fitem">
            <label> 备注： </label>
            <input id="remark" name="remark" class="easyui-validatebox"
                   data-options="validType: ['maxLength[20]', 'specialChar']">
        </div>
        <div class="fitem">
            <label> 邀请码： </label>
            <input id="invitation_code" name="invitation_code" class="easyui-validatebox">
        </div>
        <div class="fitem">
            <label> 最后下单时间： </label>
            <input id="last_order_time" name="last_order_time" class="Wdate" type="text" style="width: 172px" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
        </div>
    </form>
    <div id="userDetailVoDlgBtn">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
    <div id="userImg" class="easyui-dialog" style="width:800px;height:800px;padding:20px"
   			data-options="resizable:true,modal:true,closable: false" closed="true" buttons="#userImgBtn">
    	<div id="img"></div>
    	<div id="userImgBtn">
	        <a href="#" class="easyui-linkbutton" iconCls="icon-ok">关闭</a>
    	</div>
    </div>
</div>
<div id="uploadDlg" class="easyui-dialog" style="width:400px;height:200px;padding:20px"
     data-options="resizable:true,modal:true" closed="true" buttons="#uploadDlgBtn">
    <form id="uploadFm" class="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label> 用户导入： </label>
            <input id="file" name="file" type="file">
        </div>
    </form>
    <div id="uploadDlgBtn">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</div>
<div id="pushDlg" class="easyui-dialog" style="width:370px;height:300px;padding:20px"
     data-options="resizable:true,modal:true" closed="true" buttons="#pushDlgBtn">
    <form id="pushFm" class="fm" method="post">
        <label> 消息内容： </label>
        <input type="hidden" name="pushTitle" value="系统消息">
        <input type="hidden" id="idstr" name="idstr" value="">
        <textarea id="pushContent" name="pushContent" rows="5" cols="35"></textarea>
    </form>
    <div id="pushDlgBtn">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok">确定</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
    </div>
</div>
</body>
</html>