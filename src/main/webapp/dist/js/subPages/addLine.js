//var map = new BMap.Map("l-map-add");
//map.centerAndZoom("北京", 12);
//var local = new BMap.LocalSearch(map, { renderOptions : { map : map } });

var polyline;
var overlays = [];

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
	// var local = new BMap.LocalSearch(map, {
	// renderOptions : {
	// map : map
	// }
	// });

	return map;
}

/**
 * 创建添加线路的百度地图
 */
function BMap_create_add() {
	// 百度地图API功能
	var map = new BMap.Map('l-map');
	var poi = new BMap.Point(116.307852, 40.057031);
	map.centerAndZoom(poi, 16);
	map.enableScrollWheelZoom();

	var overlaycomplete = function(e) {
		overlays.push(e.overlay);
	};
	var styleOptions = {
		strokeColor : "red", // 边线颜色。
		fillColor : "red", // 填充颜色。当参数为空时，圆形将没有填充效果。
		strokeWeight : 3, // 边线的宽度，以像素为单位。
		strokeOpacity : 0.8, // 边线透明度，取值范围0 - 1。
		fillOpacity : 0.6, // 填充的透明度，取值范围0 - 1。
		strokeStyle : 'solid' // 边线的样式，solid或dashed。
	}
	// 实例化鼠标绘制工具
	var drawingManager = new BMapLib.DrawingManager(map, {
		isOpen : false, // 是否开启绘制模式
		enableDrawingTool : true, // 是否显示工具栏
		drawingToolOptions : {
			anchor : BMAP_ANCHOR_TOP_RIGHT, // 位置
			offset : new BMap.Size(5, 5)
		// 偏离值
		},
		polylineOptions : styleOptions, // 线的样式
	});
	drawingManager.addEventListener('overlaycomplete', overlaycomplete);
	return map;
}

/**
 * 添加画好的路线
 */
function clearAll_add() {
	$("#lineTrail").val("");
	for (var i = 0; i < overlays.length; i++) {
		if (overlays[i] == '[object Marker]'
				|| overlays[i] == '[object Circle]'
				|| overlays[i] == '[object Polygon]') {
			continue;
		}
		var temp = overlays[i].getPath();
		for (var j = 0; j < temp.length; j++) {
			document.getElementById("lineTrail").value += temp[j].lng + ","
					+ temp[j].lat + ":";
		}
	}
	overlays.length = 0
	close_map();
}

/**
 * 添加修改好的路线
 */
function clearAll() {
	$("#lineTrail").val("");
	var temp = polyline.getPath();
	for (var j = 0; j < temp.length; j++) {
		document.getElementById("lineTrail").value += temp[j].lng + ","
				+ temp[j].lat + ":";
	}
	close_map();
}

/**
 * 搜索地址
 */
function searchAddress(sign) {

	var map = BMap_create_add();
	var local = new BMap.LocalSearch(map, {
		renderOptions : {
			map : map
		}
	});
	var address = $("#siteName" + sign).val();
	if (address == null || address == '') {
		$.messager.alert('提示', '请输入地址!');
	} else {
		local.search(address);
	}
}

/**
 * 加载地图
 */
function go_map() {
	open_map();
	var path = $("#lineTrail").val();
	if (null == path || "" == path) {
		BMap_create_add();
	} else {
		BMap_create_update(path, 'l-map');
	}
}

/**
 * 显示地图
 */
function open_map() {
	document.getElementById("nomap").style.display = "none";
	document.getElementById("l-map").style.display = "block";
	document.getElementById("r-result").style.display = "block";
}

/**
 * 隐藏地图
 */
function close_map() {
	document.getElementById("nomap").style.display = "block";
	document.getElementById("l-map").style.display = "none";
	document.getElementById("r-result").style.display = "none";
}

$(function() {
	$("#lineDlg").css('width', document.body.scrollWidth - 200);
	$("#lineDlg").css('height', document.body.scrollHeight - 100);
	$("#addStat").css('width', document.body.scrollWidth - 200);
	$("#addStat").css('height', document.body.scrollHeight - 100);
});
