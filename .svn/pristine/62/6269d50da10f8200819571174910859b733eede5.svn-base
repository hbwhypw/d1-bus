var ExpOrderVo = function(){};
ExpOrderVo.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

ExpOrderVo.prototype.update = function() {
    var _this = this;
    var row = $('#expOrderVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#expOrderVoDlg").dialog("open").dialog("setTitle", "修改订单状态");
        $('#expOrderVoFm').form('load', row);
        _this.url = '/expOrder/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ExpOrderVo.prototype.delete = function() {
    var row = $('#expOrderVoDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/expOrder/delete', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#expOrderVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#expOrderVoDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ExpOrderVo.prototype.forEver = function() {
    var row = $('#expOrderVoDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/expOrder/forEver', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#expOrderVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#expOrderVoDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

ExpOrderVo.prototype.query = function() {
    this.checkInput('user_nameParam',this.INPUT);
    this.checkInput('order_noParam',this.INPUT);
    this.checkInput('consigneeParam',this.INPUT);
    this.checkInput('mobileParam',this.INPUT);
    this.checkInput('startParam',this.INPUT);
    this.checkInput('endParam',this.INPUT);
    this.checkInput('order_statusParam',this.COMBOBOX);
    $('#expOrderVoDg').datagrid('queryReload');
};

ExpOrderVo.prototype.recover = function() {
	var row = $('#expOrderVoDg').datagrid('getChecked');
	if (row) {
		var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
		$.post('/expOrder/recover', {
			ids: ids.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#expOrderVoDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

ExpOrderVo.prototype.detail = function () {
    var row = $('#expOrderVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	$.post('/expOrder/selectDetail', {
    		"id": row.id
    	}, function(data) {
    		var company = data.data.company;
    		var product = data.data.product;
    		if(1==data.code){
    			var html = '<table style="width:100%" border="1">'+
    							'<tr>'+
    								'<th>公司名</th>'+
    								'<th>联系人</th>'+
    								'<th>联系电话</th>'+
    								'<th>商品名</th>'+
    								'<th>消费积分额度</th>'+
    							'</tr>'+
    							'<tr>'+
    								'<td>'+company.name+'</td>'+
    								'<td>'+company.chairman_name+'</td>'+
    								'<td>'+company.chairman_phone+'</td>'+
    								'<td>'+product.pro_name+'</td>'+
    								'<td>'+product.exp_score+'</td>'+
    							'</tr>'+
    						'</table>';			
    			$('#productDetail').append(html);
    			$("#detail").dialog("open").dialog("setTitle", "订单详情");
    		}
    	},"json");
    }else{
    	$.messager.alert('警告','请选择一项！','warning');
    }
}

ExpOrderVo.prototype.checkInput = function(paramName,formType) {
    var param;
    switch (formType){
        case 0:
            param = $('#' + paramName).val();
            break;
        case 1:
            param = $('#' + paramName + ' option:selected').val();
            break;
        case 2:
            param = $('#' + paramName ).combobox('getValue');
            break;
        default :
            param = $('#' + paramName).val();
    }
    var requestParam = paramName.substring(0, paramName.indexOf("P"));
    if (param != "") {
        var queryParams = $('#expOrderVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#expOrderVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

ExpOrderVo.prototype.bind = function() {
    var _this = this;
    //	查看详细信息
    $("#expOrderVoDgTbar table tbody tr td a").eq(0).click(function () {
    	_this.detail();
    });

    //	修改按钮
    $("#expOrderVoDgTbar table tbody tr td a").eq(1).click(function () {
    	_this.update();
    });
    // 删除按钮
    $("#expOrderVoDgTbar table tbody tr td a").eq(2).click(function () {
    	_this.delete();
    });
    //	恢复使用按钮
    $("#expOrderVoDgTbar table tbody tr td a").eq(3).click(function () {
    	_this.recover();
    });
    // 永久删除按钮
    $("#expOrderVoDgTbar table tbody tr td a").eq(4).click(function () {
    	_this.forEver();
    });
    //	查询按钮
    $("#expOrderVoDgTbar table tbody tr td a").eq(5).click(function () {
        _this.query();
    });
    $("#expOrderVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 今天
    $("#expOrderVoDgTbar table tbody tr td a").eq(6).click(function () {
    	timeMaxMin($(this));
    	_this.query();
    });
    // 昨天
    $("#expOrderVoDgTbar table tbody tr td a").eq(7).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本周
    $("#expOrderVoDgTbar table tbody tr td a").eq(8).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本月
    $("#expOrderVoDgTbar table tbody tr td a").eq(9).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });

    /* 订单dialog */
    // 确定按钮
    $("#expOrderVoDlgBtn a").eq(0).click(function() {
        $('#expOrderVoFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#expOrderVoDlg').dialog('close');
                    $('#expOrderVoDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#expOrderVoDlgBtn a").eq(1).click(function() {
        $('#expOrderVoDlg').dialog('close');
    });
    // 关闭按钮
    $("#detailBtn a").eq(0).click(function () {
        _this.clear();
        $('#detail').dialog('close');
    });
};

ExpOrderVo.prototype.clear = function () {
    $('#productDetail').empty();
}
function timeMaxMin(s){

	var now = new Date();
	var name = $(s).attr('name');

	var min = '';
	var max = '';
	switch (name) {
	   case 'today' :
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate()) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate()) + " 23:59:59"; 
	   break;
	   case 'yesterday' :
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate() - 1) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(now.getDate() - 1) + " 23:59:59";  
	   break;
	   case 'thisWeek' :		  
		   nowDay = now.getDate();
		   nowDayOfWeek = now.getDay(); 
		   thisweek = nowDay - nowDayOfWeek	 ; 		   
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(thisweek + 1) + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-'+fillZero(thisweek + 7) + " 23:59:59"; 
	   break;
	   case 'thisMonth' :	
		   var hour=now.getHours();     
		   var minute=now.getMinutes();     
		   var second=now.getSeconds(); 	
		   min = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-' + 01 + " 00:00:00";
		   max = now.getFullYear()+'-' + fillZero(now.getMonth() + 1 ) + '-' + fillZero(now.getDate() ) +" " + fillZero(hour)+":" + fillZero(minute)+":" + fillZero(second); 
       break;
	   default :
	       alert('error');
	} 
	$('#startParam').val( min );//必须用id才行
	$('#endParam').val( max );//必须用id才行
	$('#startParam').datetimebox('setValue' , min );//必须用id才行
 	$('#endParam').datetimebox('setValue' , max );//必须用id才行
		
};	

var fillZero = function(n){
	if(n<10){
		return '0'+n;
	}else{
		return n;
	}
};
ExpOrderVo.prototype.is_checkFormatter = function(value,row,index){
    var is_check = row.is_check;
    switch (is_check) {
        case 1:
            return '√';
        case 0:
            return 'X';
        default :
            return '';
    }
};

ExpOrderVo.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function(){
    window.expOrderVo = new ExpOrderVo();
    expOrderVo.init();
});