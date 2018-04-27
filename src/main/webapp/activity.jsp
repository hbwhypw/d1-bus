<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name='viewport'
	content='width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no' />
<title>活动</title>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}

.form-control {
	display: block;
	width: 100%;
	height: 36px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.438571429;
	color: #555555;
	vertical-align: middle;
	border: 1px solid #cccccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	-webkit-transition: border-color ease-in-out 0.15s, box-shadow
		ease-in-out 0.15s;
	transition: border-color ease-in-out 0.15s, box-shadow ease-in-out 0.15s;
}

.btn {
	display: inline-block;
	height: 36px;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.438571429;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	cursor: pointer;
	border: 1px solid transparent;
	border-radius: 4px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	-o-user-select: none;
	user-select: none;
}

.btn-warning {
	color: #ffffff;
	background-color: #ff7200;
	border-color: #ff7200;
}

.btn-block {
	display: block;
	width: 100%;
	padding-right: 0;
	padding-left: 0;
}

.img-responsive {
	display: block;
	height: auto;
	max-width: 100%;
}

.back {
	background-size: cover;
	background-position: center center;
	margin: auto 0;
	padding-left: 10%;
	padding-right: 10%;
}
</style>
<script type="text/javascript" src="/dist/lib/jquery/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#a4").click(function() {
			var reg = /^1[3-8]\d{9}$/;
			var phone = $("#a2").val();
			if (reg.test(phone)) {
				var param = $.param({
					"id" : $("#id").val(),
					"phone" : $("#a2").val()
				});
				$.post("/card/addExp", param, function(data) {
					console.log(data.msg);
					alert(data.msg);
				}, "json");
			} else {
				alert('手机号错误！');
			}
		});
	});
</script>
</head>
<body>
	<input type="hidden" id="id" value="<%=request.getParameter("id")%>">
	<img class="img-responsive" alt="" src="/images/activity/a1.png">
	<input id="a2" type="text" class="back form-control"
		placeholder="输入手机号领取积分" required="required" />
	<img class="img-responsive" alt="" src="/images/activity/a3.png">
	<button id="a4" type="button" class="back btn btn-warning btn-block">领取积分</button>
	<img class="img-responsive" alt="" src="/images/activity/a5.png">
</body>
</html>