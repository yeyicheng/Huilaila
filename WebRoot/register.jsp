<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
</HEAD>
<BODY>
	<s:form action="register.action" method="post">
		<s:textfield name="user.userName" label="用户名" value="demo"></s:textfield>
		<s:password name="user.password" label="密码" value="123456"></s:password>
		<s:submit value="注册"></s:submit>
	</s:form>
</BODY>
</HTML>
