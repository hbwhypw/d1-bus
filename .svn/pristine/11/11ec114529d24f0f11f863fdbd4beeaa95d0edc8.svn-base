var ShopOrderVo = function(){};
ShopOrderVo.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COMBOBOX = 2;
    this.bind();
};

ShopOrderVo.prototype.update = function() {
    var _this = this;
    var row = $('#shopOrderVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
        $("#shopOrderVoDlg").dialog("open").dialog("setTitle", "修改订单状态");
        $('#shopOrderVoFm').form('load', row);
        _this.url = '/shopOrder/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ShopOrderVo.prototype.delete = function() {
    var row = $('#shopOrderVoDg').datagrid('getChecked');
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
                $.post('/shopOrder/delete', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#shopOrderVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#shopOrderVoDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

ShopOrderVo.prototype.forEver = function() {
    var row = $('#shopOrderVoDg').datagrid('getChecked');
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
                $.post('/shopOrder/forEver', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#shopOrderVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
                $('#shopOrderVoDg').datagrid('queryReload');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

ShopOrderVo.prototype.query = function() {
    this.checkInput('user_nameParam',this.INPUT);
    this.checkInput('order_noParam',this.INPUT);
    this.checkInput('consigneeParam',this.INPUT);
    this.checkInput('mobileParam',this.INPUT);
    this.checkInput('startParam',this.INPUT);
    this.checkInput('endParam',this.INPUT);
    this.checkInput('order_statusParam',this.COMBOBOX);
    this.checkInput('pay_typeParam',this.COMBOBOX);
    this.checkInput('is_billParam',this.COMBOBOX);
    $('#shopOrderVoDg').datagrid('queryReload');
};

ShopOrderVo.prototype.recover = function() {
	var row = $('#shopOrderVoDg').datagrid('getChecked');
	if (row) {
		var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
		$.post('/shopOrder/recover', {
			ids: ids.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#shopOrderVoDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

ShopOrderVo.prototype.detail = function () {
    var row = $('#shopOrderVoDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	$.post('/shopOrder/selectDetail', {
    		"id": row.id
    	}, function(data) {
    		var companyList = data.data
    		var html = "";			
    		if(1==data.code){
    			html += '<table id="table" border="1" style="width:100%">'
					+'<tr>'
					+'<th>公司名</th>'
					+'<th>联系人</th>'
					+'<th>联系方式</th>'
					+'<th>产品名称</th>'
					+'<th>商城价格</th>'
				+'</tr>';
    			for (var i = 0; i < companyList.length; i++) {
    				for(var j = 0;j < companyList[i].productList.length; j++){
    					html += "<tr>"+
    					"<td>"+companyList[i].name+"</td>"+
    					"<td>"+companyList[i].chairman_name+"</td>"+
    					"<td>"+companyList[i].chairman_phone+"</td>"+
    					"<td>"+companyList[i].productList[j].pro_name+"</td>"+
    					"<td>"+companyList[i].productList[j].shop_price+"</td>"+
    					"</tr>"
    				}
				}
    			html += '</table>';
    			$('#productDetail').append(html);
    			$("#detail").dialog("open").dialog("setTitle", "订单详情");
    		}
    	},"json");
    }else{
    	$.messager.alert('警告','请选择一项！','warning');
    }
}

ShopOrderVo.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#shopOrderVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#shopOrderVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

ShopOrderVo.prototype.bind = function() {
    var _this = this;
    //	查看详细信息
    $("#shopOrderVoDgTbar table tbody tr td a").eq(0).click(function () {
    	_this.detail();
    });

    //	修改按钮
    $("#shopOrderVoDgTbar table tbody tr td a").eq(1).click(function () {
    	_this.update();
    });
    // 删除按钮
    $("#shopOrderVoDgTbar table tbody tr td a").eq(2).click(function () {
    	_this.delete();
    });
    //	恢复使用按钮
    $("#shopOrderVoDgTbar table tbody tr td a").eq(3).click(function () {
    	_this.recover();
    });
    // 永久删除按钮
    $("#shopOrderVoDgTbar table tbody tr td a").eq(4).click(function () {
    	_this.forEver();
    });
    // 今天
    $("#shopOrderVoDgTbar table tbody tr td a").eq(5).click(function () {
        timeMaxMin($(this));
        _this.query();
    });
    $("#shopOrderVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 今天
    $("#shopOrderVoDgTbar table tbody tr td a").eq(6).click(function () {
        timeMaxMin($(this));
    	_this.query();
    });
    // 昨天
    $("#shopOrderVoDgTbar table tbody tr td a").eq(7).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本周
    $("#shopOrderVoDgTbar table tbody tr td a").eq(8).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本月
    $("#query").click(function () {
        _this.query();
    });

    /* 订单dialog */
    // 确定按钮
    $("#shopOrderVoDlgBtn a").eq(0).click(function() {
        $('#shopOrderVoFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#shopOrderVoDlg').dialog('close');
                    $('#shopOrderVoDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#shopOrderVoDlgBtn a").eq(1).click(function() {
        $('#shopOrderVoDlg').dialog('close');
    });
    // 关闭按钮
    $("#detailBtn a").eq(0).click(function () {
        _this.clear();
        $('#detail').dialog('close');
    });
};

ShopOrderVo.prototype.clear = function () {
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
ShopOrderVo.prototype.is_billFormatter = function(value,row,index){
    var is_bill = row.is_bill;
    switch (is_bill) {
        case 1:
            return '开票';
        case 0:
            return '不开票';
        default :
            return '';
    }
};

ShopOrderVo.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};
$(function(){
    window.shopOrderVo = new ShopOrderVo();
    shopOrderVo.init();
});