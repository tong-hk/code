﻿<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<%@include file="WEB-INF/view/include/header.jsp"%>
		<script type="text/javascript">
			$(function(){
				$("#smit").click(function(){
					$("#loginForm").submit();
				})
			})
		</script>
    </head>
    <body class="index">
		<div class="login_box">
			<form id="loginForm" action="login" method="post">
				<table>
					<tr>
						<td class="login_info">账号：</td>
						<td colspan="2"><input name="acname" type="text" class="width150" /></td>
						<td class="login_error_info"><span class="required"></span></td>
					</tr>
					<tr>
						<td class="login_info">密码：</td>
						<td colspan="2"><input name="apwd" type="password" class="width150" /></td>
						<td><span class="required"></span></td>
					</tr>
					<tr>
						<td></td>
						<td class="login_button" colspan="2"><a id="smit">
						<img src="${pageContext.request.contextPath}/assets/images/login_btn.png" /></a></td>
						<td><span class="required"></span></td>
					</tr>
					<tr>
						<td>${errorMsg}</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>