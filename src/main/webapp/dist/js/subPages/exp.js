var Exp = function() {
};

Exp.prototype.init = function() {
	var _this = this;
	_this.bind();
};

Exp.prototype.bind = function() {
	var _this = this;
    /* datagrid */
    // 查询按钮
    $("#expDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    $("#phoneParam").keyup(function (event) {
        if (event.keyCode == 13) _this.query();
    });
}

Exp.prototype.query = function() {
	this.checkInput('phoneParam');
	$('#expDg').datagrid('queryReload');
};

Exp.prototype.checkInput = function(paramName) {
	param = $('#' + paramName).val();
	var requestParam = paramName.substring(0, paramName.indexOf("P"));
	if (param != "") {
		var queryParams = $('#expDg').datagrid('options').queryParams;
		queryParams[requestParam] = param;
	} else {
		var queryParams = $('#expDg').datagrid('options').queryParams;
		delete queryParams[requestParam];
	}
};

$(function() {
	var exp = new Exp();
	exp.init();
});