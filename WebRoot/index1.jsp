<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <%@include file="/public/head.jspf" %>
	<style type="text/css">
		#menu {
			width:200px;		
		}
		#menu ul {
			list-style: none;
			padding:0px;
			margin:0px;
		}
		#menu ul li{
			border-bottom: 1px solid #fff;

		}
		#menu ul li a{
			display:block;
			text-decoration: none;
			background-color:#008792;
			color:#fff;
			padding:5px;
		}
		#menu ul li a:HOVER{
			background-color:#00a6ac;
		}
	</style>
  </head>
  
  <body>
    <a href="${shop}/category_update.action?id=2&type=abc&hot=false">updateTest</a>
    <a href="category_query.action">updateTest</a>
    <c:forEach items="${categoryList}" var="category">
    	${category.id}||${category.type}||${category.hot}
    
    </c:forEach>
    <a href="category_aindex.action">frameset</a>
    <a href="category_index.action">easyUI</a>
    <div id="menu">
     <ul>
     	<li><a href="#">商品类别</a></li>
     	<li><a href="#">项目选择</a></li>
    </ul>
    </div>
  </body>
</html>
