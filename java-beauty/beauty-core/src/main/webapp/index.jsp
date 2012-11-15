<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/frame/tags.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="1.js"></script>
</head>
<body>

<form id="loginForm" name="loginForm" action="system/user_login.action" method="post">
	用户:<input type="text" name="username"/><br/>
	密码:<input type="password" name="password"/><br/>
	<a href="#" onclick="submit();">点击登录</a>
</form>

</body>
</html>
