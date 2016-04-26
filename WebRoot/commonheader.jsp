<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="top">
        <s:if test="#session.onlineUser==null"><a href="login.jsp" style="color:black;">登录</a>
        &nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp" style="color:black;">注册</a></s:if>
        <s:else>您好，<s:property value="#session.onlineUser.u_id"/>
        	&nbsp;&nbsp;&nbsp;&nbsp; <a href="logout.action">&nbsp;&nbsp;&nbsp;&nbsp;注销</a>
        	&nbsp;&nbsp;&nbsp;&nbsp; <a href="ShowMyShopCartsAction.action">我的购物车</a>
        	&nbsp;&nbsp;&nbsp;&nbsp; <a href="showMyOrders.action">我的订单</a>
        </s:else>
       &nbsp;&nbsp;&nbsp;&nbsp; <a href="index.action">首页</a>
</div>
<div class="banner" >
            <div class="logo"><img src="images/logo.jpg"  style="width:940px;"></img></div>
        </div>