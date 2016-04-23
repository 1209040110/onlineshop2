<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="top">
        <s:if test="#session.onlineUser==null"><a href="login.jsp" style="color:black;">登录</a>
        &nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp" style="color:black;">注册</a></s:if>
        <s:else>您好，<s:property value="#session.onlineUser.u_id"/>
        	<a href="logout.action">&nbsp;&nbsp;&nbsp;&nbsp;注销</a>
        	<a href="ShowMyShopCartsAction.action">我的购物车</a>
        </s:else>
        
</div>
<div class="banner" style="width:1270px;height:482px;">
            <div class="logo"><img src="images/logo.jpg"  width="1270px;"></img></div>
        </div>