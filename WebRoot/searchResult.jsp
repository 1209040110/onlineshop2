<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<base href="<%=basePath%>">
    	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>后台登录</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<style type="text/css">
img{
	width:100px;
	height:100px;
}
</style>

</head>

<body>
<h2>搜索结果：</h2>
<table border="1" >
<s:iterator value="products" var="p">
	<tr>
	<td><s:property value="#p.p_name"/></td><td><s:property value="#p.p_image" escape="false" /></td><td>￥<s:property value="#p.p_price"/></td>
	<td><s:property value="#p.p_description"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>
