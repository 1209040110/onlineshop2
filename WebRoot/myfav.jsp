<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
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
    <style>
    </style>
    <script>
    function del(pid) {
        <%if(session.getAttribute("onlineUser")==null){%>
        	alert('请先登录!');
        <%}else{%>
        	
            $.ajax({
                url : "delfav.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'pid':pid
                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                console.log(data);
                if(data=='nologin')
                	alert('请先登录!');
                if(data=='ok'){
                   alert('删除成功!');
                   window.location.href="myfav.action";
                   }
                if(data=='fail')
					alert('删除失败!');
                },
                complete: function() {
                    //请求完成的处理
                },
                error: function() {
                    //请求出错处理
                }
            });
            <%}%>
        }
    </script>
</head>
<body >
<div class="container">
    <s:include value="commonheader.jsp"/>
    <div id="main">
        <table border="1">
            <caption>我收藏的商品</caption>
            <tr>
                <th>商品名</th>
                <th>商品图片</th>
                <th>商品价格</th>
                <th>商品销量</th>
                <th>商品人气</th>
                <th>商品评分</th>
                <th></th>
            </tr>
            <s:iterator value="favpros" var="p">
            <tr>
                <td><s:property value="#p.p_name"/></td>
                <td>
                	
                		<a href="ShowProDetail.action?p_id=<s:property value="#p.p_id"/>">
                			<img width="80" height="75" src="images/productimg/<s:property value="#p.smallimg"/>"/>
                		</a>
                </td>
                <td><s:property value="%{formatDouble(#p.unitprice)}"/></td>
                <td>
                	<s:property value="#p.salesvolume"/>
                </td>
                <td><s:property value="#p.rq"/></td>
                <td><s:property value="#p.score"/></td>
                <td><button onclick="del('<s:property value="#p.p_id"/>')">删除</button></td>
            </tr>
            </s:iterator>
        </table>






    </div>
</div>
</body>
</html>