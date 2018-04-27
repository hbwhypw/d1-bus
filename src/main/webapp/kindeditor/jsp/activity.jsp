<%@page import="com.tmtc.utils.VerificationUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="../themes/default/default.css" />
	<link rel="stylesheet" href="../plugins/code/prettify.css" />
	<script charset="utf-8" src="../kindeditor.js"></script>
	<script charset="utf-8" src="../lang/zh_CN.js"></script>
	<script charset="utf-8" src="../plugins/code/prettify.js"></script>
	<script type="text/javascript" src="/dist/lib/jquery/jquery-1.8.3.min.js"></script>
	<script src="/dist/lib/jquery/jquery.cookie.js"></script>
	<script>
		
		var editor1;
		KindEditor.ready(function(K) {
			editor1 = K.create('textarea[name="content1"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
			
		});
		
		function contents(){
			var content1 = $('#content1').val();
			return content1;
		}
		
	</script>
</head>
<body>
	<input type="hidden" id="num" value='<%=htmlData%>'>
	<label id="test"></label>
	<form name="example" method="post" action="activity.jsp">	
		<textarea id="content1" name="content1" cols="100" rows="8" style="width:810px;height:450px;visibility:hidden;"></textarea>
	</form>
</body>
</html>
