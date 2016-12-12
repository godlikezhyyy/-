<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <%@include file="/public/head.jspf" %>
  </head>
  	<frameset border="5" rows="150,*">
  		<frame src="send_main_head.action">
  		<frameset cols="150,*">
  			<frame src="send_main_left.action">
  			<frame src="send_main_right.action">
  		</frameset>
  	</frameset>
  
</html>
