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
  	 		var rows=parent.$("iframe[title='类别管理']")[0].contentWindow.$('#dg').datagrid("getSelections");
  	 		$('input').validatebox({    
		   	 	required: true,
		   	 	missingMessage:'至少输入一个字'       
			}); 
			
			$('#ff').form('load',{
					type:rows[0].type,
					hot:rows[0].hot,
					'account.id':rows[0].account.id,
					id:rows[0].id
			});
			$('#cc').combobox({    
			    url:'account_getAccount.action',
			    editable:false, 
			    valueField:'id',   
			    textField:'login'         
			});  
			
			
			
			$("#btn").click(function(){
				$('#ff').form("enableValidation");				
				$('#ff').form('submit', {    
				   url: 'category_update.action',
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
     <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">更新</a>
    <input id="cc" name="account.id"> 
   
    </div>
    <input type="hidden" name="id">   
</form>  
 		
 		
  </body>
</html>
