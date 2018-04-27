/**
 * Created by hbwhypw on 2015/8/24.
 */
var Userstatistic = function(){};
Userstatistic.prototype.init = function() {
    this.url = "";
    this.INPUT = 0;
    this.SELCET = 1;
    this.exportParam = {};
    this.bind();
};

Userstatistic.prototype.query = function() {
    this.checkInput('real_nameParam',this.INPUT);
    this.checkInput('phoneParam',this.INPUT);
    this.checkInput('line_nameParam',this.INPUT);
    this.checkInput('genderParam',this.SELCET);
    this.checkInput('start_dateParam',this.INPUT);
    this.checkInput('end_dateParam',this.INPUT);
    $('#userstatisticDg').datagrid('queryReload');
};

/**
 *
 * @param paramName
 * @param formType
 */
Userstatistic.prototype.checkInput = function(paramName,formType) {
    var param;
    debugger;
    switch (formType){
        case 0:
            param = $('#' + paramName).val();
            break;
        case 1:
            param = $('#' + paramName + ' option:selected').val();
            break;
        default :
            param = $('#' + paramName).val();
    }
    var requestParam = paramName.substring(0, paramName.indexOf("P"));
    if (param != "") {
        var queryParams = $('#userstatisticDg').datagrid('options').queryParams;
        queryParams[requestParam] = param;
    } else {
        var queryParams = $('#userstatisticDg').datagrid('options').queryParams;
        delete queryParams[requestParam];
    }
};

Userstatistic.prototype.addExportParam = function(paramKey,paramValue){
    var param = this.exportParam;
    param[paramKey] = '';
    if(paramValue != ""){
        param[paramKey] = paramValue;
    } else {
        delete param[paramKey];
    }
};
Userstatistic.prototype.export = function() {
    this.addExportParam("phone", $('#phoneParam').val());
    this.addExportParam("real_name", $('#real_nameParam').val());
    this.addExportParam("line_name", $('#line_nameParam').val());
    this.addExportParam("start_date", $('#start_dateParam').val());
    this.addExportParam("end_date", $('#end_dateParam').val());
    this.addExportParam("gender", $('#genderParam').find('option:selected').val());
    var param = $.param(this.exportParam);
    var win = window.open("/statistic/userexport?"+param,"_blank_");
};

Userstatistic.prototype.bind = function() {
    var _this = this;
    /*  datagrid */
    //	查询按钮
    $("#userstatisticDgTbar table tbody tr td a").eq(0).click(function () {
        _this.query();
    });
    // 导出按钮
    $("#userstatisticDgTbar table tbody tr td a").eq(1).click(function () {
        _this.export();
    });
};

Userstatistic.prototype.genderFormatter = function(value,row,index){
    var gender = row.gender;
    switch (gender) {
        case 1:
            return '男';
        case 2:
            return '女';
        case 3:
            return '保密';
        default :
            return '';
    }
};

Userstatistic.prototype.phoneFormatter = function(value,row,index){
    var phone = row.phone;
    if (phone)
        phone = phone.substr(0,3) + "*****" + phone.substr(8, phone.length);
    return phone;
};

$(function(){
    window.userstatistic = new Userstatistic();
    userstatistic.init();
});