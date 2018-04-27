/**
 * 复制上一个月的司机
 */
function copyDriver() {
	var line_id = $("#line_id_id").val();
	$.post("/lineTime/selectDriverAndCar", {
		"line_id" : line_id
	}, function(data) {
		
		if("" == data.data){
			$.messager.alert('提示', '近30天中有多个司机，或者没有司机!');
		} else {
			$("#driver_id").val(data.data.driver_id);
			$("#car_id").val(data.data.car_id);
			$("#driver_name").val(data.data.driver_name);
			$("#car_num").val(data.data.car_num);
			$("#sendTime").val(data.data.sendTime);
			$("#doneTime").val(data.data.doneTime);
		}
	}, "json");
}

/**
 * 发布班次
 */
Line.prototype.addTime = function() {
	var _this = this;
	var row = $('#lineDg').datagrid('getSelected');
	if (row) {
		$("#addTime").dialog("open").dialog("setTitle", "发布班次");
		$("#lineName").val(row.line_name);
		$("#line_id_id").val(row.id);
		_this.url = '/lineStation/add';
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

/**
 * 查询车辆
 */
function openCar() {
	$("#selectCar").dialog("open").dialog("setTitle", "查询司机");
}

function selectCar() {
	this.checkInput('selectCarDg', 'car_numParam', 0);
	this.checkInput('selectCarDg', 'from_companyParam', 2);
	$('#selectCarDg').datagrid('queryReload');
}

/**
 * 查询司机
 */
function openDriver() {
	$("#selectDriver").dialog("open").dialog("setTitle", "查询司机");
}

function selectDriver() {
	this.checkInput('selectDriverDg', 'mobileParam', 0);
	this.checkInput('selectDriverDg', 'real_nameParam', 0);
	$('#selectDriverDg').datagrid('queryReload');
}

function checkInput(Dg, paramName, formType) {
	var param;
	switch (formType) {
	case 0:
		param = $('#' + paramName).val();
		break;
	case 1:
		param = $('#' + paramName + ' option:selected').val();
		break;
	case 2:
		param = $('#' + paramName).combobox('getValue');
		break;
	default:
		param = $('#' + paramName).val();
	}
	var requestParam = paramName.substring(0, paramName.indexOf("P"));
	if (param != "") {
		var queryParams = $('#' + Dg).datagrid('options').queryParams;
		queryParams[requestParam] = param;
	} else {
		var queryParams = $('#' + Dg).datagrid('options').queryParams;
		delete queryParams[requestParam];
	}
};

$(function() {

	/* 班次dialog */
	// 确定按钮
	$("#addTimeDlgBtn a").eq(0).click(function() {
		
		var id_array=new Array();
		$('input[name="sendDate"]:checked').each(function(){
			id_array.push($(this).val());//向数组中添加元素
		});
		if(id_array.length == 0 ) {
			$.messager.alert('警告','请选择日期！','warning');
			return;
		}
		$('#addTimeFm').form('submit', {
			url : "/lineTime/add",
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code === 1) {
					$('#addTime').dialog('close');
					$('#lineDg').datagrid('reload');
				}
				$.messager.show({
					title : '系统提示',
					msg : data.msg
				});
			}
		});
	});
	// 取消按钮
	$("#addTimeDlgBtn a").eq(1).click(function() {
		$('#addTime').dialog('close');
	});

	/* 查询司机dialog */
	// 确定按钮
	$("#selectDriverDlgBtn a").eq(0).click(function() {
		var row = $('#selectDriverDg').datagrid('getSelected');
		if (row) {
			$("#driver_id").val(row.id);
			$("#driver_name").val(row.real_name);
			$('#selectDriver').dialog('close');
		} else {
			$.messager.alert('警告', '请选择一项！', 'warning');
		}

	});

	// 查询司机取消按钮
	$("#selectDriverDlgBtn a").eq(1).click(function() {
		$('#selectDriver').dialog('close');
	});

	/* 查询汽车dialog */
	// 确定按钮
	$("#selectCarDlgBtn a").eq(0).click(function() {
		var row = $('#selectCarDg').datagrid('getSelected');
		if (row) {
			$("#car_id").val(row.id);
			$("#car_num").val(row.car_num);
			$('#selectCar').dialog('close');
		} else {
			$.messager.alert('警告', '请选择一项！', 'warning');
		}

	});

	// 查询汽车取消按钮
	$("#selectCarDlgBtn a").eq(1).click(function() {
		$('#selectCar').dialog('close');
	});
});