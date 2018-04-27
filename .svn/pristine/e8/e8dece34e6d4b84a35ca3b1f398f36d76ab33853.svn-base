/**
 * 加载添加站点的百度地图
 * @param path 线路的折线点
 * @param lineStation 已经添加过的站点
 */
function initBMap(path,lineStation){
	// 加载地图和折线
	var map = BMap_create_update(path,'l-map-station');
	
	lineStation = lineStation.split("|");
	if( 0 != lineStation[0].length ){
		for(var i = 0;i < lineStation.length;i++) {
			var str = lineStation[i].split(':');
			var point1 = str[1].split(",");
			var point = new BMap.Point(parseFloat(point1[0]), parseFloat(point1[1]));
			var marker = new BMap.Marker(point);
			map.addOverlay(marker);  
			var label = new BMap.Label("站点" + str[0], { offset : new BMap.Size(20, -10) });
			marker.setLabel(label);
		}
	}
	
	// 添加点击地图事件，并获取坐标
	var mk = map.addEventListener("click",function(e) {
		$("#x_point").val(e.point.lng);
		$("#y_point").val(e.point.lat);
		map.removeOverlay(mk);
		point =new BMap.Point($("#x_point").val(),$("#y_point").val());
	    mk = new BMap.Marker(point);
		map.addOverlay(mk);  
	    label = new BMap.Label("选择的站点",{offset:new BMap.Size(20,-10)});
	    mk.setLabel(label);
	});
}