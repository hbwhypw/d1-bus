var Car = function(){};
Car.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.COBOBOX = 2;
    this.bind();
};
Car.prototype.add = function() {
    $("#carDlg").dialog("open").dialog("setTitle", "添加车辆信息");
    $('#phone').focusout(function(){
    	var phone = $('#phone').val();
    	$.post('/car/selectByPhone', {
    		"phone": phone
    	}, function(data) {
    		var result = eval("("+data+")");
    		if(1==result.code){
    			$.messager.show({
                    title: '系统提示',
                    msg: '手机号已存在'
                });
    			$('#phone').attr("value","");
    		}
    	});
    });
    /*$('#car_num').focusout(function(){
    	var car_num = $('#car_num').val();
    	$.post('/car/selectByCar_num', {
    		"car_num": car_num
    	}, function(data) {
    		var result = eval("("+data+")");
    		if(1==result.code){
    			$.messager.show({
                    title: '系统提示',
                    msg: '此车牌已存在'
                });
    			$('#car_num').attr("value","");
    		}
    	});
    });*/
    $('#imei').focusout(function(){
    	var imei = $('#imei').val();
    	$.post('/car/selectByImei', {
    		"imei": imei
    	}, function(data) {
    		var result = eval("("+data+")");
    		if(1==result.code){
    			$.messager.show({
    				title: '系统提示',
    				msg: '此设备已被绑定'
    			});
    			$('#imei').attr("value","");
    		}
    	});
    });
    $('#seat').focusout(function(){
    	var seat = $('#seat').val();
    	var total_seat = $('#total_seat').val();
    	var i = total_seat - seat;
    	if(i<0){
    		$.messager.show({
                title: '系统提示',
                msg: '乘车座位数不能大于总座位数'
            });
    		$('#seat').attr("value","");
    	}
    });
    var _this = this;
    $('#carFm').form('clear');
    _this.url = '/car/add';
};
Car.prototype.update = function() {
	/*$('#car_num').focusout(function(){
    	var car_num = $('#car_num').val();
    	$.post('/car/selectByCar_num', {
    		"car_num": car_num
    	}, function(data) {
    		var result = eval("("+data+")");
    		if(1==result.code){
    			$.messager.alert('警告','此车牌已存在！','warning');
    			$('#car_num').attr("value","");
    		}
    	});
    });
    $('#seat').focusout(function(){
    	var seat = $('#seat').val();
    	var total_seat = $('#total_seat').val();
    	var total_seatTime=new Date(total_seat.replace("-", "/").replace("-", "/"));  
    	if(seat>total_seat){
    		if(confirm("乘车座位数不能大于总座位数!!!")){
    			result = true;
    		}else{
    			$('#seat').attr("value","");
    		}
    	}
    });
    $('#imei').focusout(function(){
    	var imei = $('#imei').val();
    	$.post('/car/selectByImei', {
    		"imei": imei
    	}, function(data) {
    		var result = eval("("+data+")");
    		if(1==result.code){
    			$.messager.show({
    				title: '系统提示',
    				msg: '此设备已被绑定'
    			});
    			$('#imei').attr("value","");
    		}
    	});
    });*/
    var _this = this;
    var row = $('#carDg').datagrid('getSelected');
    if (row) {
        $("#carDlg").dialog("open").dialog("setTitle", "修改车辆信息");
        $('#carFm').form('load', row);
        _this.url = '/car/update';
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Car.prototype.delete = function() {
    var row = $('#carDg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/car/delete', {
                	ids: row.id.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#carDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                    $('#carDg').datagrid('reload');
                }, 'json');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Car.prototype.forEver = function() {
    var row = $('#carDg').datagrid('getSelect');
    if (row) {
        $.messager.confirm('系统确认', '是否确定删除？', function(r) {
            if (r) {
                $.post('/car/forEver', {
                	ids: row.id.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#carDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                }, 'json');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

Car.prototype.query = function() {
    this.checkInput('car_numParam',this.INPUT);
    this.checkInput('car_brandParam',this.INPUT);
    this.checkInput('from_companyParam',this.COBOBOX);
    this.checkInput('car_statusParam',this.COBOBOX);
    this.checkInput('is_checkParam',this.SELCET);
    $('#carDg').datagrid('queryReload');
};

Car.prototype.look = function() {
	var _this = this;
    var row = $('#carDg').datagrid('getSelected');
    if (row) {
    	if(0==row.is_check){
    		$.messager.show({
                title: '系统提示',
                msg: '此项已删除'
            });
    		return;
    	}
    	$.post('/car/selectById', {
    		"id": row.id
    	}, function(data) {
    		var result = eval("("+data+")");
    		var map = result.data;
    		var html = '';
    		var alist = map.carPic;
    		var blist = map.registration;
    		var clist = map.appearancePic;
    		var dlist = map.trimPic;
    		if(1==result.code){
    			html += "<div>车辆照片</div>";
    			for(var i = 0;i < alist.length; i++){
    				html += '<img src="' + alist[i] + '" width=100%>';
    			}
    			html += "<div>驾照图片</div>";
    			for(var i = 0;i < blist.length; i++){
    				html += '<img src="' + blist[i] + '" width=100%>';
    			}
    			html += "<div>外观照片</div>";
    			for(var i = 0;i < clist.length; i++){
    				html += '<img src="' + clist[i] + '" width=100%>';
    			}
    			html += "<div>内饰照片</div>";
    			for(var i = 0;i < dlist.length; i++){
    				html += '<img src="' + dlist[i] + '" width=100%>';
    			}
    			$('#img').append(html);
    			$("#carImg").dialog("open").dialog("setTitle", "车辆图片");
    		}
    	});
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

Car.prototype.recover = function() {
	var row = $('#carDg').datagrid('getSelected');
	if (row) {
		$.post('/car/updateRecover', {
			ids: row.id.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#carDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

Car.prototype.stop = function() {
	var row = $('#carDg').datagrid('getSelected');
	if(row) {
		$.post('/car/stop',{
			id:row.id
		},function(data) {
			$.messager.show({
				title:'系统提示',
				msg:data.msg
			});
			$('#carDg').datagrid('reload');
		},'json');
	} else {
		$.messager.alert('警告','请选择一项','warning');
	}
}

Car.prototype.export = function() {
	var row = $('#carDg').datagrid('getChecked');
    if (row) {
    	var ids = [];
        if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
        var param = $.param({
			ids: ids.toString()
        });
    document.location.href = "/car/export/?" + param;
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Car.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#carDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#carDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Car.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#carDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#carnameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 查看图片按钮
    $("#carDgTbar table tbody tr td a").eq(1).click(function () {
        _this.look();
    });
    // 添加按钮
    $("#carDgTbar table tbody tr td a").eq(2).click(function () {
        _this.add();
    });
    // 修改按钮
    $("#carDgTbar table tbody tr td a").eq(3).click(function () {
        _this.update();
    });
    // 删除按钮
    $("#carDgTbar table tbody tr td a").eq(4).click(function () {
        _this.delete();
    });
    // 恢复按钮
    $("#carDgTbar table tbody tr td a").eq(5).click(function () {
        _this.recover();
    });
    // 永久删除按钮
    $("#carDgTbar table tbody tr td a").eq(6).click(function () {
        _this.forEver();
    });
    $("#carDgTbar table tbody tr td a").eq(7).click(function () {
    	_this.stop();
    });
    $("#export").click(function () {
        _this.export();
    });

    /* 用户dialog */
    // 确定按钮
    $("#carDlgBtn a").eq(0).click(function() {
        $('#carFm').form('submit', {
            url: _this.url,
            onSubmit: function() {
                return $(this).form('validate');
            },
            success: function(data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    $('#carDlg').dialog('close');
                    $('#carDg').datagrid('reload');
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });
            }
        });
    });
    // 取消按钮
    $("#carDlgBtn a").eq(1).click(function() {
        $('#carDlg').dialog('close');
    });
    // 关闭按钮
    $("#carImgBtn a").eq(0).click(function() {
    	_this.clearImg();
        $('#carImg').dialog('close');
    });
};

Car.prototype.clearImg = function() {
	$('#img').empty();
};

Car.prototype.is_checkFormatter = function(value,row,index){
	var is_check = row.is_check;
    switch (is_check) {
        case 1:
            return '√';
        case 0:
            return 'X';
        default :
            return '';
    }
}

Car.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};

$(function(){
    window.car = new Car();
    car.init();
});