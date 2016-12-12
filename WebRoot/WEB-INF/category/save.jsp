<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
  	 <%@include file="/public/head.jspf" %>
  	 <style type="text/css">
  	 	form div{
  	 		margin-top:5px;
  	 	
  	 	}
  	 
  	 </style>
  	 
  	 <script type="text/javascript">
  	 	$(document).ready(function(){
  	 		$('input').validatebox({    
		   	 	required: true,
		   	 	missingMessage:'至少输入一个字'       
			}); 
			$("#btn").click(function(){
				$('#ff').form("enableValidation");				
				$('#ff').form('submit', {    
				   url: 'category_save.action',
				   onSubmit: function(){
						var isValid = $(this).form('validate');
						return isValid;	

					},
					success:function(data){    
				      	parent.$('#win').window("close");
				      	parent.$("iframe[title='类别管理']")[0].contentWindow.$('#dg').datagrid('reload');
				    }  
				});
			});
			
			$('#ff').form("disableValidation");
			});
  	 
  	 
  	 
  	 </script>
  </head>
  
  <body>
 		<form id="ff" method="post">   
    <div>   
        <label for="type">商品类别:</label>   
        <input type="text" name="type" data-options="required:true" />   
    </div>   
    <div>   
        <label for="hot">是否热点:</label>   
       	热点:<input type="radio" value="true" name="hot">
       	非热点:<input type="radio" value="false" name="hot" checked="checked">
    </div> 
    <div>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    </div>   
</form>  
 		
 		
  </body>
</html>
