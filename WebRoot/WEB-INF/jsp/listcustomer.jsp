<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/WEB-INF/itcast.tld" prefix="itcast" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有用户</title>
  </head>
  
  <body style="text-align: center;">
 
 	
    <table width="90%" frame="border">
    	<tr>
    		<td>客户姓名</td>
    		<td>性别</td>
    		<td>生日</td>
    		<td>手机号码</td>
    		<td>邮箱</td>
    		<td>爱好</td>
    		<td>类型</td>
    		<td>备注</td>
    		<td>操作</td>
    	</tr>
    	
    	<c:forEach var="c" items="${page.list}">
    		<tr>
	    		<td><c:out value="${c.name }" escapeXml="true"/></td>
	    		<td><c:out value="${c.gender }" escapeXml="true"/></td>
	    		<td><c:out value="${c.birthday }" escapeXml="true"/></td>
	    		<td><c:out value="${c.cellphone }" escapeXml="true"/></td>
	    		<td><c:out value="${c.email }" escapeXml="true"/></td>
	    		<td><c:out value="${itcast:subString(c.preference,10)}" escapeXml="true"/></td>
	    		<td><c:out value="${c.type }" escapeXml="true"/></td>
	    		<td><c:out value="${itcast:subString(c.description,10)}" escapeXml="true"/></td>
	    		
	    		<td>
	    			<a href="${pageContext.request.contextPath }/servlet/UpdateCustomerUIServlet?id=${c.id }">修改</a>
	    			<a href="javascript:dodelete('${c.id }')">删除</a>
	    			
	    			
	    		</td>
    		</tr>
    	</c:forEach>
    </table>
    <br/>
   	<%@include file="/public/page.jsp" %>
  </body>
  <script type="text/javascript">
  	function dodelete(id)
  	{
  		var b = window.confirm("您确认删除吗？？");
  		if(b){
  			window.location.href="${pageContext.request.contextPath }/servlet/DeleteCustomerServlet?id=" + id;
  		}
  	}
  </script>
  
</html>
