var Scan = function(){};
Scan.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.bind();
};

Scan.prototype.query = function() {
    this.checkInput('userNameParam',this.INPUT);
    this.checkInput('stationNameParam',this.INPUT);
    this.checkInput('startParam',this.INPUT);
    this.checkInput('endParam',this.INPUT);
    $('#scanVoDg').datagrid('queryReload');
};
Scan.prototype.recover = function(){
	var row = $('#scanVoDg').datagrid('getChecked');
	if (row) {
		var ids = [];
    	if ($.isArray(row)){
            for(var i = 0; i < row.length; i++){
                ids.push(row[i].id);
            }
        } else {
            ids = ids.push(row.id);
        }
		$.post('/scan/updateRecover', {
			ids: ids.toString()
		}, function(data) {
			$.messager.show({
                title: '系统提示',
                msg: data.msg
            });
			$('#scanVoDg').datagrid('reload');
		}, 'json');
	} else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}
Scan.prototype.delete = function() {
    var row = $('#scanVoDg').datagrid('getChecked');
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
                $.post('/scan/delete', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#scanVoDg').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: '系统错误',
                            msg: data.msg
                        });
                    }
                    $('#scanVoDg').datagrid('reload');
                }, 'json');
            }
        });
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
}

Scan.prototype.export = function() {
	var row = $('#scanVoDg').datagrid('getChecked');
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
    document.location.href = "/scan/export/?" + param;
    } else {
        $.messager.alert('警告','请选择一项！','warning');
    }
};

Scan.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#scanVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#scanVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Scan.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#scanVoDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#scanVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
    $("#export").click(function () {
        _this.export();
    });
    
    // 今天
    $("#scanVoDgTbar table tbody tr td a").eq(1).click(function () {
    	timeMaxMin($(this));
    	_this.query();
    });
    // 昨天
    $("#scanVoDgTbar table tbody tr td a").eq(2).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本周
    $("#scanVoDgTbar table tbody tr td a").eq(3).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本月
    $("#scanVoDgTbar table tbody tr td a").eq(4).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 恢复
    $("#scanVoDgTbar table tbody tr td a").eq(5).click(function () {
    	_this.recover();
    });
    // 删除
    $("#scanVoDgTbar table tbody tr td a").eq(6).click(function () {
        _this.delete();
    });
    
};

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

Scan.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};

$(function(){
    window.scan = new Scan();
    scan.init();
});