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
    <link rel="stylesheet" type="text/css" href="css/font.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/button.css">
    <link rel="stylesheet" type="text/css" href="css/adminManage.css">
    <style>

    </style>
    <script>
        function del(oid) {
        <%if(session.getAttribute("onlineAdmin")==null){%>
        	alert('请先登录!');
        <%}else{%>
        
            $.ajax({
                url : "delorder.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'oid':oid
                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                if(data=='nologin')
                	alert('请先登录!');
                if(data=='ok'){
                   alert('删除成功!');
                   window.location.href="showAllOrders.action";
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
  
    <div id="main">
    	<h2>后台管理</h2>
        <table border="1">
            <caption>用户订单管理</caption>
            <tr>
                <th>订单号</th>
                <th>下单用户</th>
                <th>商品信息</th>
                <th>实付款</th>
                <th>订单信息</th>
                <th>下单时间</th>
                <th>订单状态</th>
                <th></th>
            </tr>
            <s:iterator value="uoList" var="order">
            <tr>
                <td><s:property value="#order.o_id"/></td>
                 <td><s:property value="#order.u_id"/></td>
                <td>
                	
                	<s:iterator value="pmap[#order.o_id]" var="p">
                		<a href="ShowProDetail.action?p_id=<s:property value="#p.p_id"/>">
                			<img width="80" height="75" src="images/productimg/<s:property value="#p.smallimg"/>"/>
                		</a>
                	</s:iterator>
                </td>
                <td>¥<s:property value="#order.totalprice"/></td>
                <td>
                	<s:if test="#order.paymentmode=='onlinepay'">在线支付</s:if>  
                	<s:if test="#order.paymentmode=='cash'">现金</s:if>  
                	<p><s:property value="cneeMap[#order.o_id]"/></p>
                </td>
                <td><s:property value="#order.o_time"/></td>
                <td><s:if test="#order.o_status==1">等待付款</s:if>
                	<s:if test="#order.o_status==2">等待收货</s:if>
                	<s:if test="#order.o_status==3">订单已完成</s:if>
                	<s:if test="#order.o_status==4">订单已取消</s:if>
                </td>
                <td><button onclick="del(<s:property value="#order.o_id"/>)">删除</button></td>
            </tr>
            </s:iterator>
        </table>






    </div>
</div>
</body>
</html>