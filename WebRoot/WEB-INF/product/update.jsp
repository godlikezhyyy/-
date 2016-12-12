<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
  	 <%@include file="/public/head.jspf" %>
  	 
  	 <style type="text/css">
  	 	form div{
  	 		margin-top:5px;
  	 	
  	 	}
  	 	img{
  	 		width:120px;
  	 		height:120px;
  	 		float:right;
  	 	}
  	 </style>
  	 
  	 <script type="text/javascript">
	  	 	$(document).ready(function(){
	  	 		var rows=parent.$("iframe[title='商品管理']")[0].contentWindow.$('#dg').datagrid("getSelections");
			  	 $('#ff').form('load',{
					name:rows[0].name,
					price:rows[0].price,
					pic:rows[0].pic,
					commend:rows[0].commend,
					open:rows[0].open,
					remark:rows[0].remark,
					xremark:rows[0].xremark,
					id:rows[0].id,
					'category.id':rows[0].category.id
					
				});
				$("img").attr("src","${shop}/images/"+rows[0].pic);
  	 		$.extend($.fn.validatebox.defaults.rules, {    
			    format: {    
			        validator: function(value, param){    
			        	var ext=value.substring(value.lastIndexOf("."));
			        	var params=param[0].split(',');
			        	
			        	for(var para in params){

			        		if(params[para]==ext){
			        			return true;
			        		}
			        	}
			            return false;    
			        },    
			       message: '文件格式为{0}'   
			    }    
			}); 
  	 		$('input[name="name"]').validatebox({    
		   	 	required: true,
		   	 	missingMessage:'请输入商品名称'       
			});
			$('textarea[name="remark"]').validatebox({    
		   	 	required: true,
		   	 	missingMessage:'请输入简单描述'       
			});
			$('textarea[name="xremark"]').validatebox({    
		   	 	required: true,
		   	 	missingMessage:'请输入详细描述'       
			});
			$('input[name="fileimage.upload"]').validatebox({ 
				validType: 'format[".jpg,.png,.gif"]'  
			
			});
			
			$('input[name="fileimage.upload"]').change(function(){
				var formData=new FormData();
				formData.append("fileimage.upload",$('input[name="fileimage.upload"]')[0].files[0]);
				formData.append("pic",rows[0].pic);
				$.ajax({
					url:"product_saveTemp.action",
					type:"POST",
					data:formData,
					processData: false,
					contentType: false,
					dataType:'text',
				    success : function(data) {				    	
				        window.setTimeout(function(){$("img").attr("src","${shop}/images/"+data);},10000);
				    }
				
				});
			
			});
			$('input[name="price"]').numberbox({    
				required: true,
				missingMessage:'请输入金额',     
			    min:0,    
			    precision:2,
			    prefix:'$'    
			});
			$('#cc').combobox({    
			    url:'category_queryCategory.action',    
			    valueField:'id',    
			    textField:'type',
			    panelHeight:'auto',
			    required: true
			}); 
			  
			$("#btn").click(function(){
				$('#ff').form("enableValidation");				
				$('#ff').form('submit', {    
				   url: 'product_update.action',
				   onSubmit: function(){
						var isValid = $(this).form('validate');
						return isValid;	

					},
					success:function(data){    
				      	parent.$('#win').window("close");
				      	parent.$("iframe[title='商品管理']")[0].contentWindow.$('#dg').datagrid('reload');
				    }  
				});
			});
			
			$('#ff').form("disableValidation");
			});
  	 
  	 
  	 
  	 </script>
  </head>
  
  <body>
 	<form id="ff" method="post" enctype="multipart/form-data">  
 	<img src="C:\fakepath\Folder.jpg"/> 
 	
 	
    <div>   
        <label for="name">商品名称:</label>   
        <input type="text" name="name" data-options="required:true" />   
    </div>
    <div>   
        <label for="price">商品价格:</label>   
        <input type="text" name="price" data-options="required:true" />   
    </div>
    <div>   
        <label for="pic">如果需要修改图片请上传:</label>  
        <input type="file" name="fileimage.upload" />  
        <input type="hidden" name="pic" /> 
    </div>
    <div>   
        <label for="commend">是否推荐:</label>  
       推荐: <input type="radio" name="commend" value="true" checked="checked"/> 
   不推荐: <input type="radio" name="commend" value="false"/>    
    </div>
    <div>   
        <label for="open">是否有效:</label>  
       有效: <input type="radio" name="open" value="true" checked="checked"/> 
   无效:  <input type="radio" name="open" value="false"/>    
    </div>   
    <div>   
        <label for="remark">简单描述:</label>  
        <textarea name="remark" data-options="required:true"></textarea>   
    </div>
    <div>   
        <label for="xremark">详细描述:</label>  
        <textarea name="xremark" data-options="required:true" style="height:100px;"></textarea>  
    </div>
    <div>
    	<label for="type">商品类别</label>
    	<input id="cc" name="category.id">  
    </div>
    <div>
    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">更新</a>
    </div> 
    <input type="hidden" name="id">  
</form>  
 		
 		
  </body>
</html>
