/**
 * Created by hbwhypw on 2015/8/21.
 */
var indexPage = {};
indexPage.init = function () {
    $('#username').focus();
    this.bind();
};
indexPage.bind = function() {
    $('#username').on('keydown', function(e){
        if(e.keyCode == 13){
            $('#password').focus();
        }
    });

    $('#password').on('keydown', function(e){
        if(e.keyCode == 13){
            indexPage.login();
        }
    });

    $('#login').on('click',function(){
        indexPage.login();
    });

    $('#register').on('click',function(){
    
    });
};
indexPage.login = function () {
    if (indexPage.validate()){
        var data = $.param({
            username: $('#username').val(),
            password: $('#password').val()
        });
        $.post('/admins/login',data,function(data){
            if(data.code == 1){
                document.location.href = "/admin/main.jsp";
            } else {
            	$.messager.alert('警告', '用户名或密码错误！', 'warning');
            }
        },'json');
    }
};
indexPage.validate = function () {
    var valided = true;
    if ($('#username').val().trim() == ''){
    	$.messager.alert('警告', '用户名不能为空！', 'warning');
        return false;
    }
    if ($('#password').val().trim() == ''){
        $.messager.alert('警告', '密码不能为空！', 'warning');
        return false;
    }
    return valided;
};

$(function () {
    indexPage.init();
});