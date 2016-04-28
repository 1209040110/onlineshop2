<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
request.setCharacterEncoding("utf-8");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta content="zh-CN" http-equiv="Content-Language" />
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" />
    <title>网上医药馆</title>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="js/jquery-1.11.0.js"></script>
    <!--<script src="js/sha1.js"></script>-->
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/commonheader.css">
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
    <script>

    </script>
</head>
<body>
<div class="container">
    <div id="main">
        <h2>添加药品</h2>
        <form action="addproduct.action" enctype="multipart/form-data" method="post">
        <p>药品名：<input type="text" name="p.p_name" id=""/></p>
        <p>药品单价;<input type="text" name="p.unitprice" id=""/></p>
        <p>药品库存量<input type="text" name="p.stock" id=""/></p>
        <p>药品小类:<select name="p.sc_id" id="">
                        <s:iterator value="scList" var="sc">
                            <option value ="<s:property value="#sc.sc_id"/>"><s:property value="#sc.sc_name"/></option>
                        </s:iterator>
                    </select></p>
        <p>药品图片<input type="file" name="file" id=""/></p>
        <p>药品规格<input type="text" name="pd.size" id=""/></p>
        <p>药品适应症<input type="text" name="pd.syz" id=""/></p>
        <p>药品分类<input type="text" name="pd.ypfl" id=""/></p>
        <p>药品用法<input type="text" name="pd.yf" id=""/></p>
        <p>药品保质期<input type="text" name="pd.expire" id=""/></p>
        <p>药品批准文号<input type="text" name="pd.pzwh" id=""/></p>
        <p>药品剂型<input type="text" name="pd.cpjx" id=""/></p>
        <p>药品id<input type="text" name="pd.p_id" id=""/></p>
        <p>药品描述<textarea  name="pd.description" id=""></textarea></p>
        <p>生产商<input  name="pd.manufacturer" id=""/></p>
        <p>品牌<input  name="pd.brand" id=""/></p>
            <input  type="submit" value="Go"
                    class="button button-pill button-primary">
        </form>
    </div>
</div>
</body>
</html>