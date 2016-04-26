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
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<body>
    <div class="container">
        <s:include value="commonheader.jsp"/>
        
        <div class="main">
            <div class="nav clearfix" >
                <ul>
                    <li>首页</li>
                    <li>药师咨询</li>
                    <li>网络医院</li>
                </ul>
            </div>


			
            <div class="mainmiddle clearfix">
            
                <div class="cls">
                <s:iterator value="bigclasses" var="bc">
                    <div class="bigclass"><h3 style="font-weight:bold;"><s:property value="#bc.bc_name" /></h3></div>
                    <div class="smallclass">
                    	
                        <ul>
                        <%int i=0; %>
                        <s:iterator value="#bc.smallClasses" var="sc">
                        <%i++;if((i-1)%3==0){%><li><%}%>
                        <a  style="color:black;" href="ShowAllScPro.action?sc_id=<s:property value="#sc.sc_id" />"><s:property value="#sc.sc_name" /></a>
                      	<%if(i%3==0){%></li><%}%>
                       
                        </s:iterator> 
                        </ul>
                        
                    </div>
                  </s:iterator>  
                </div>
               
                <div class="mainmiddleright">
                    <div class="ppt">幻灯片</div>
                    <div class="rank">
                        <h3>排行榜</h3>
                        <ul>
                        	<s:iterator value="phbTopn" var="phb">
                            	<li>
                                	<p><a href="ShowProDetail.action?p_id=<s:property value="#phb.p_id" />"><s:property value="#phb.p_name" /></a></p>
                                	<p>￥<s:property value="#phb.unitprice" /></p>
                               	 	<p><a href="ShowProDetail.action?p_id=<s:property value="#phb.p_id" />">
                               	 			<img  src="images/productimg/<s:property value="#phb.smallimg" />">
                               	 		</a>
                               	 	</p>
                            	</li>
                            </s:iterator>
                           
                        </ul>
                    </div>
                </div>
            </div>

            <div class="yybj">
                <h3>家庭常备</h3>
                <div class="clearfix">
                    
                    <%int i=0; %>
                     <s:iterator value="jtcbProductTen" var="jtcb">
                     <%i++; %>
                    <%if((i-1)%4==0){%><ul class="clearfix"><%}%>
                        <li>
                            <p><img src="images/productimg/<s:property value="#jtcb.smallimg"/>"></p>
                            <p><a href="ShowProDetail.action?p_id=<s:property value="#jtcb.p_id" />"><s:property value="#jtcb.p_name"/></a></p>
                            <p>￥<s:property value="#jtcb.unitprice"/></p>
                        </li>
                        
                  <%if(i%4==0){%>  </ul><%}%>
                   </s:iterator>
                </div>
            </div>
            <div class="zbys clearfix">
                <h3>中西药品</h3>
                <div class="clearfix">
                    
                    <%i=0; %>
                     <s:iterator value="zxypProductTen" var="zxyp">
                     <%i++; %>
                    <%if((i-1)%4==0){%><ul class="clearfix"><%}%>
                        <li>
                            <p><img src="images/productimg/<s:property value="#zxyp.smallimg"/>"></p>
                            <p><a href="ShowProDetail.action?p_id=<s:property value="#zxyp.p_id" />"><s:property value="#zxyp.p_name"/></a></p>
                            <p>￥<s:property value="#zxyp.unitprice"/></p>
                        </li>
                        
                  <%if(i%4==0){%>  </ul><%}%>
                   </s:iterator>
                   
                </div>
            </div>
           <s:if test="#session.onlineUser!=null">
            <div>
            	<h3>猜你喜欢</h3>
                <div class="clearfix">
                    
                  
                     
                   		
                    <s:iterator value="guessfav" var="gf">
                        <div style="float:left; border:0;">
                        	
	                            <p><img src="images/productimg/<s:property value="#gf.smallimg"/>"></p>
	                            <p><a href="ShowProDetail.action?p_id=<s:property value="#gf.p_id" />"><s:property value="#gf.p_name"/></a></p>
	                            <p>￥<s:property value="#gf.unitprice"/></p>
	                         
                        </div>
                     </s:iterator>   
                		
                 
                   
                </div>
            </div>
          </s:if>
        </div>
        <div class="bottom"></div>
    </div>
</body>
</html>