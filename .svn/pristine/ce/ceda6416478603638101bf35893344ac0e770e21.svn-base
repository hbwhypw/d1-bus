/**
 * Created by hbwhypw on 2015/8/31.
 */

var Password = function(){};
Password.prototype.init = function(){
    this.bind();
    this.setDefaults();
};
Password.prototype.setDefaults = function(){
    $.extend($.fn.validatebox.defaults.rules, {
        equals: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: '新密码与确认密码不匹配！'
        }
    });
};
Password.prototype.bind = function(){
    /* dialog */
    // 确定按钮
    $("#updatePasswordDlgBtn a").eq(0).click(function () {
        debugger;
        $('#updatePasswordFm').form('submit', {
            url: './../admin/updatepwd',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                var data = eval('(' + data + ')');
                if (data.code === 1) {
                    document.location.href = '/admin/logout';
                }
                $.messager.show({
                    title: '系统提示',
                    msg: data.msg
                });

            }
        });
    });
};

$(function(){
    window.password = new Password();
    password.init();
});