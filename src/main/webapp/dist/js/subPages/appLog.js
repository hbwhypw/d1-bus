var AppLog = function(){};
AppLog.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.bind();
};
AppLog.prototype.delete = function() {
    var row = $('#appLogVoDg').datagrid('getChecked');
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
                $.post('/appLog/delete', {
                	ids: ids.toString()
                }, function(data) {
                    if (data.code === 1) {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg
                        });
                        $('#appLogVoDg').datagrid('reload');
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
};

AppLog.prototype.query = function() {
    this.checkInput('nameParam',this.INPUT);
    this.checkInput('startParam',this.INPUT);
    this.checkInput('endParam',this.INPUT);
    $('#appLogVoDg').datagrid('queryReload');
};

AppLog.prototype.checkInput = function(paramName,formType) {
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
        var queryParams = $('#appLogVoDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#appLogVoDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

AppLog.prototype.bind = function() {
    var _this = this;
    /* datagrid */
    // 查询按钮
    $("#appLogVoDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#appLogVonameParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });

    // 今天
    $("#appLogVoDgTbar table tbody tr td a").eq(1).click(function () {
    	timeMaxMin($(this));
    	_this.query();
    });
    // 昨天
    $("#appLogVoDgTbar table tbody tr td a").eq(2).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本周
    $("#appLogVoDgTbar table tbody tr td a").eq(3).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    // 本月
    $("#appLogVoDgTbar table tbody tr td a").eq(4).click(function () {
    	timeMaxMin($(this));
        _this.query();
    });
    
    // 删除按钮
    $("#appLogVoDgTbar table tbody tr td a").eq(5).click(function () {
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
	   $.messager.alert('警告','error！','warning');
	   
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

AppLog.prototype.rowStyler = function(index,row){
    if (row.is_check == 0){
        return 'background-color:rgb(183, 182, 182);color:#fff;';
    }
};

$(function(){
    window.appLog = new AppLog();
    appLog.init();
});