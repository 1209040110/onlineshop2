<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<meta charset="UTF-8">
    <meta content="zh-CN" http-equiv="Content-Language" />
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0" />
    <title>网上医药馆</title>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <script src="js/jquery-1.11.0.js"></script>
    <!--<script src="js/sha1.js"></script>-->

   
    
   <script>
        function checkuname() {
            var uname=$("#uname").val();
            var $unamenotice=$("#unamenotice");
            $.ajax({
                url : "checkUname.action",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                type : "GET",
                data : {
                    'uname':uname

                },
                beforeSend: function() {
                    //请求前的处理
                },
                success : function(data, textStatus) {
                    if(data=='ok'){
                        $unamenotice.html('该用户名可用！');
                    }
                    if(data=='hasRes'){
                        $unamenotice.html('该用户名已被注册！');
                    }

                },
                complete: function() {
                    //请求完成的处理
                },
                error: function() {
                    //请求出错处理
                }
            });
        }
    </script>

</script>
	</head>


	<body>
	<h1>注册</h1>
	<form action="Register.action" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" >
                          
                          <tr>
                            <td width="13%" height="35" >用户名：&nbsp;&nbsp;</td>
                            <td height="35" colspan="2" >
                            <input type="text" name="u.u_id" id="uname" size="20" onblur="checkuname()"/><span id="unamenotice"></span>
                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35"> 密 码： &nbsp;&nbsp;</td>
                            <td height="35" colspan="2" >
                            <input type="password"  size="20" name="u.pwd"/>
                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35"> 真实姓名： &nbsp;&nbsp;</td>
                            <td height="35" colspan="2" >
                            <input type="text"  size="20" name="u.truename"/>
                            </td>
                          </tr>
                          <tr><td>性别：</td>
                          <td>	<label><input name="u.sex" type="radio" value="male" />男 </label>
            				<label><input name="u.sex" type="radio" value="female" />女 </label></td>
                          </tr>
                         
        
                           <tr>
                            <td width="13%" height="35"> 地 址： &nbsp;&nbsp;</td>
                            <td height="35" colspan="2" >
                            <input type="text"  size="20" name="u.address"/>
                            </td>
                          </tr>
                          <tr><td>
                         安全问题1:</td><td>  <select name="u.securityqu1">
  <option value ="你父亲姓名">你父亲名字</option>
  <option value ="你母亲姓名">你母亲名字</option>
  <option value="你出生地">你出生地</option>
  <option value="你高中学校名字">你高中学校名字</option>
</select></td>
                          </tr>
                           <tr>
                          <td>安全答案1：
                          </td>
                          <td><input name="u.securityans1" type="text"/>
                          </td>
                          </tr>
                  <tr>      <td> 安全问题2：</td> 
                         <td>  <select name="u.securityqu2">
  <option value ="你父亲姓名">你父亲名字</option>
  <option value ="你母亲姓名" selected="selected">你母亲名字</option>
  <option value="你出生地">你出生地</option>
  <option value="你高中学校名字">你高中学校名字</option>
</select></td>
                          </tr>
                           <tr>
                          <td>安全答案2：
                          </td>
                          <td><input name="u.securityans2" type="text"/>
                          </td>
                          </tr>
                           <tr>
                            <td width="13%" height="35"> 手机号： &nbsp;&nbsp;</td>
                            <td height="35" colspan="2" >
                            <input type="text"  size="20" name="u.phone"/>
							
                            <font style="color:red"></font>
                            
                        

                            </td>
                          </tr>
                           <tr>
                            <td width="13%" height="35"> 邮 箱： &nbsp;&nbsp;</td>
                            <td height="35" colspan="2" >
                            <input type="text"  size="20" name="u.email"/>
                            
                            <font style="color:red"></font>
                            
                           
                            </td>
                          </tr>

                         
							
                          <tr>
                            <td width="20%" height="35" >
                            <input type="submit" id="Submit" value="注册"/> </td>
                            
                            <td width="67%" >
                            <input type="reset" id="cs" value="取 消"/></td>
                          </tr>
                        </table>
                        <br />
    </form>
	</body>
</html>