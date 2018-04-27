<%--
  User: hbwhypw
  Date: 2015/8/20
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>嘀一巴士管理系统</title>
    <link rel="stylesheet" type="text/css" href="/dist/lib/easyui/themes/bootstrap/easyui.css" id="swicth-style">
<link rel="stylesheet" type="text/css" href="/dist/lib/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../dist/css/index.css">
</head>
<body>
    <div id="container" class="container">
        <div class="title"></div>
        <div class="white"></div>
        <div class="back">
            <div class="inputContainer">
                <table width="250px">
                    <tr>
                        <td width="70px" align="right">用&nbsp;户&nbsp;名：</td>
                        <td width="180px"><input id="username" name="username" type="text" placeholder="请输入用户名" value=""/></td>
                    </tr>
                    <tr>
                        <td width="70px"  align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                        <td width="180px"><input id="password" name="password" type="password" placeholder="请输入密   码" value=""/></td>
                    </tr>
                </table>
            </div>
            <div class="buttonContainer">
                <a id="login" class="button login">登录</a>
<!--                 <a id="register" class="button register">注册</a> -->
            </div>
        </div>
    </div>
    <script src="../dist/lib/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/dist/lib/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/dist/lib/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="../dist/js/index.js"></script>
</body>
</html>
