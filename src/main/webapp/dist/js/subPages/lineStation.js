/**
 * 定义一个函数
 */
var LineStation = function() {
};

LineStation.prototype._delete = function() {
	var row = $('#lineStationDg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('系统确认', '是否确定删除？', function(r) {
			if (r) {
				$.post('/lineStation/delete', {
					id : row.id
				}, function(data) {
					if (data.code === 1) {
						$.messager.show({
							title : '系统提示',
							msg : data.msg
						});
						$('#lineStationDg').datagrid('reload');
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

LineStation.prototype.deleteForEver = function() {
	var row = $('#lineStationDg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('系统确认', '是否确定删除？', function(r) {
			if (r) {
				$.post('/lineStation/deleteForEver', {
					id : row.id
				}, function(data) {
					if (data.code === 1) {
						$.messager.show({
							title : '系统提示',
							msg : data.msg
						});
						$('#lineStationDg').datagrid('reload');
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

LineStation.prototype.update = function() {
	var _this = this;
	var row = $('#lineStationDg').datagrid('getSelected');
	if (row) {
		$("#lineStationDlg").dialog("open").dialog("setTitle", "修改路线");
		$('#lineStationFm').form('load', row);
		initBMap(row.line_path, row.x_point, row.y_point, row.station_name);
		$("#prev_id").combobox("reload");
		_this.url = '/lineStation/update';
	} else {
		$.messager.alert('警告', '请选择一项！', 'warning');
	}
}

LineStation.prototype.query = function() {
	this.checkInput('line_nameParam', this.INPUT);
	this.checkInput('station_nameParam', this.INPUT);
	$('#lineStationDg').datagrid('queryReload');
}

LineStation.prototype.checkInput = function(paramName, formType) {
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
		var queryParams = $('#lineStationDg').datagrid('options').queryParams;
		queryParams[requestParam] = param;
	} else {
		var queryParams = $('#lineStationDg').datagrid('options').queryParams;
		delete queryParams[requestParam];
	}
};

/**
 * 
 */
LineStation.prototype.bind = function() {
	var _this = this;
	// 查询按钮
	$("#lineStationDgTbar table tbody tr td a").eq(0).click(function() {
		_this.query();
	});
	$("#station_nameParam").keyup(function(event) {
		if (event.keyCode == 13)
			_this.query();
	});
	// 修改按钮
	$("#lineStationDgTbar table tbody tr td a").eq(1).click(function() {
		_this.update();
	});

	// 删除按钮
	$("#lineStationDgTbar table tbody tr td a").eq(2).click(function() {
		_this._delete();
	});
	/*// 永久删除按钮
	$("#lineStationDgTbar table tbody tr td a").eq(3).click(function() {
		_this.deleteForEver();
	});*/

	/* 线路dialog */
	// 确定按钮
	$("#lineStationDlgBtn a").eq(0).click(function() {
		$('#lineStationFm').form('submit', {
			url : _this.url,
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code === 1) {
					$('#lineStationDlg').dialog('close');
					$('#lineStationDg').datagrid('reload');
				}
				$.messager.show({
					title : '系统提示',
					msg : data.msg
				});
			}
		});
	});
	// 取消按钮
	$("#lineStationDlgBtn a").eq(1).click(function() {
		$('#lineStationDlg').dialog('close');
	});
};

/**
 * 初始化
 */
LineStation.prototype.init = function() {
	this.url = "";
	this.INPUT = 0;
	this.bind();
}

$(function() {
	window.lineStation = new LineStation();
	lineStation.init();

	$("#lineStationDlg").css('width', document.body.scrollWidth - 200);
	$("#lineStationDlg").css('height', document.body.scrollHeight - 100);
});

/**
 * 加载添加站点的百度地图
 * 
 * @param path
 *            线路的折线点
 * @param lineStation
 *            已经添加过的站点
 */
function initBMap(path, x_point, y_point, station_name) {
	// 加载地图和折线
	var map = BMap_create_update(path, 'l-map-station');
	var point = new BMap.Point(x_point, y_point);
	var marker = new BMap.Marker(point);
	map.addOverlay(marker);
	var label = new BMap.Label("站点" + station_name, {
		offset : new BMap.Size(20, -10)
	});
	marker.setLabel(label);

	// 添加点击地图事件，并获取坐标
	var mk = map.addEventListener("click", function(e) {
		$("#x_point").val(e.point.lng);
		$("#y_point").val(e.point.lat);
		map.removeOverlay(mk);
		point = new BMap.Point($("#x_point").val(), $("#y_point").val());
		mk = new BMap.Marker(point);
		map.addOverlay(mk);
		label = new BMap.Label("您新选择的站点", {
			offset : new BMap.Size(20, -10)
		});
		mk.setLabel(label);
	});
}

/**
 * 创建修改线路的百度地图
 */
function BMap_create_update(path, map_name) {

	path = path.substring(0, path.length - 1);
	path = path.split(":");
	var poi = path[0].split(',');
	// 百度地图API功能
	var map = new BMap.Map(map_name);
	map.centerAndZoom(new BMap.Point(parseFloat(poi[0]), parseFloat(poi[1])),
			15);
	map.enableScrollWheelZoom();
	polyPoint = [];
	for (var i = 0; i < path.length; i++) {
		var str = path[i].split(',');
		polyPoint.push(new BMap.Point(parseFloat(str[0]), parseFloat(str[1])));
	}
	polyline = new BMap.Polyline(polyPoint, {
		strokeColor : "red",
		strokeWeight : 2,
		strokeOpacity : 1
	}); // 创建折线
	map.addOverlay(polyline); // 增加折线
	return map;
}