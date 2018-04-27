/**
 * Created by hbwhypw on 2015/8/21.
 */
var Line = function() {
};

Line.prototype.init = function() {
	this.url = "";
	this.INPUT = 0;
	this.bind();
};

Line.prototype.add = function() {
	var _this = this;
	$("#lineDlg").dialog("open").dialog("setTitle", "添加线路");
	$('#lineFm').form('clear');
	document.getElementById("add_id").style.display = "block";
	document.getElementById("update_id").style.display = "none";
	close_map();
	_this.url = '/line/add';
};

Line.prototype.update = function() {
	var _this = this;
	var row = $('#lineDg').datagrid('getSelected');
	if (row) {
		$("#lineDlg").dialog("open").dialog("setTitle", "修改路线");
		$('#lineFm').form('load', row);
		document.getElementById("add_id").style.display = "none";
		document.getElementById("update_id").style.display = "block";
		close_map();
		_this.url = '/line/update';
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

Line.prototype.select = function() {
	var _this = this;
	var row = $('#lineDg').datagrid('getSelected');
	if (row) {
		var station = row.lineStation;
		var sta = station.split("|");
		var stations = "";
		for (var i = 0; i < sta.length; i++) {
			var s = sta[i].split(":");
			stations += "<p style='font-size: 20px;'>";
			stations += s[0];
			stations += "</p>";
		}
		$("#selectStation").dialog("open").dialog("setTitle", "查看线路站点");
		$("#selectStation_id").html(stations);
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

Line.prototype._delete = function() {
	var row = $('#lineDg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('系统确认', '是否确定删除？', function(r) {
			if (r) {
				$.post('/line/delete', {
					id : row.id
				}, function(data) {
					if (data.code === 1) {
						$.messager.show({
							title : '系统提示',
							msg : data.msg
						});
						$('#lineDg').datagrid('reload');
					} else {
						$.messager.show({
							title : '系统错误',
							msg : data.msg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

Line.prototype.forEverDelete = function() {
	var row = $('#lineDg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('系统确认', '是否确定删除？', function(r) {
			if (r) {
				$.post('/line/forEverDelete', {
					id : row.id
				}, function(data) {
					if (data.code === 1) {
						$.messager.show({
							title : '系统提示',
							msg : data.msg
						});
						$('#lineDg').datagrid('reload');
					} else {
						$.messager.show({
							title : '系统错误',
							msg : data.msg
						});
					}
				}, 'json');
			}
		});
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

Line.prototype.query = function() {
	this.checkInput('line_nameParam', this.INPUT);
	this.checkInput('company_nameParam', this.INPUT);
	$('#lineDg').datagrid('queryReload');
};

Line.prototype.checkInput = function(paramName, formType) {
	var param;
	switch (formType) {
	case 0:
		param = $('#' + paramName).val();
		break;
	case 1:
		param = $('#' + paramName + ' option:selected').val();
		break;
	default:
		param = $('#' + paramName).val();
	}
	var requestParam = paramName.substring(0, paramName.indexOf("P"));
	if (param != "") {
		var queryParams = $('#lineDg').datagrid('options').queryParams;
		queryParams[requestParam] = param;
	} else {
		var queryParams = $('#lineDg').datagrid('options').queryParams;
		delete queryParams[requestParam];
	}
};

Line.prototype.addExportParam = function(paramKey, paramValue) {
	var param = this.exportParam;
	param[paramKey] = '';
	if (paramValue != "") {
		param[paramKey] = paramValue;
	} else {
		delete param[paramKey];
	}
};

/**
 * 发布站点
 */
Line.prototype.addStat = function() {
	var _this = this;
	var row = $('#lineDg').datagrid('getSelected');
	if (row) {
		$("#addStat").dialog("open").dialog("setTitle", "发布站点");
		$("#line_name_id").text(row.line_name);
		$("#line_id").val(row.id);
		$('#addStatFm').form('load', row);

		$("#station_name_id").val("");
		$("#x_point").val("");
		$("#y_point").val("");
		$("#next_time_id").val("");
		$("#next_km_id").val("");
		$("#prev_id").combobox('clear');

		var path = row.line_path;
		var lineStation = row.lineStation;
		initBMap(path, lineStation);
		$('#prev_id').combobox('reload');

		_this.url = '/lineStation/add';
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
};

Line.prototype.bind = function() {
	var _this = this;
	/* datagrid */
	// 查询按钮
	$("#lineDgTbar table tbody tr td a").eq(0).click(function() {
		_this.query();
	});
	$("#line_nameP").keyup(function(event) {
		if (event.keyCode == 13)
			_this.query();
	});
	// 添加按钮
	$("#lineDgTbar table tbody tr td a").eq(1).click(function() {
		_this.add();
	});
	// 修改按钮
	$("#lineDgTbar table tbody tr td a").eq(2).click(function() {
		_this.update();
	});
	// 删除按钮
	$("#lineDgTbar table tbody tr td a").eq(3).click(function() {
		_this._delete();
	});
	// 添加站点
	$("#lineDgTbar table tbody tr td a").eq(4).click(function() {
		_this.addStat();
	});

	// 添加站点
	$("#lineDgTbar table tbody tr td a").eq(5).click(function() {
		_this.addTime();
	});

	/*// 永久删除按钮
	$("#lineDgTbar table tbody tr td a").eq(6).click(function() {
		_this.forEverDelete();
	});*/

	// 查看线路详细信息
	$("#lineDgTbar table tbody tr td a").eq(6).click(function() {
		_this.select();
	});

	/* 线路dialog */
	// 确定按钮
	$("#lineDlgBtn a").eq(0).click(function() {
		$('#lineFm').form('submit', {
			url : _this.url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code === 1) {
					$('#lineDlg').dialog('close');
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
	$("#lineDlgBtn a").eq(1).click(function() {
		$('#lineDlg').dialog('close');
	});

	$("#addStatDlgBtn a").eq(0).click(function() {
		$('#addStatFm').form('submit', {
			url : _this.url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code === 1) {
					$('#addStat').dialog('close');
					$('#lineDg').datagrid('reload');
				}
				$.messager.show({
					title : '系统提示',
					msg : data.msg
				});
			}
		});
	})
	$("#addStatDlgBtn a").eq(1).click(function() {
		$('#addStat').dialog('close');
	})
};

Line.prototype.rate_Formatter = function(value, row, index) {
	var line_rate = (row.on_time_rate * 100) + "%";
	return line_rate;

};

Line.prototype.city_Formatter = function(value, row, index) {
	var city_id = row.city_id;

	$.post('/dictionary/selectByCode', {
		'code' : city_id,
		'page' : 0,
		'rows' : 100
	}, function(data) {

		var result = data.rows;
		for (var i = 0; i < result.length; i++) {
			if (car_type == result[i].code) {
				return result[i].name;
			} else {
				return 'fd';
			}
		}
	}, 'json');

};

$(function() {
	window.line = new Line();
	line.init();
});