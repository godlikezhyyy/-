<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
  	 <%@include file="/public/head.jspf" %>
  	<script type="text/javascript">
  			$(function(){
  				//表格设置
				$('#dg').datagrid({
					url : 'product_queryPage.action',
					fitColumns:true,
					pagination:true,
					idField:'id',
					rowStyler: function(index,row){
							if (index%2!=0){
							return 'background-color:#abc886;';
						}
					},	
					toolbar: [{
						iconCls: 'icon-edit',
						text:'编辑商品',
						handler: function(){
							var rows=$("#dg").datagrid("getSelections");
							if(rows.length!=1){
								$.messager.show({
									title:'更新消息',
									msg:'只能更新一条',
									timeout:5000,
									showType:'slide'
								});		
							}else{
							parent.$('#win').window({
								iconCls: 'icon-add',
								title:'编辑商品',
								top:'100',
								width:400,    
    							height:600,  
							    content:'<iframe src="send_product_update.action" width="100%" height="100%" frameborder="0"/>' 
							}); 
							}
						}
						
					},'-',{
						iconCls: 'icon-add',
						text:'添加商品',
						handler: function(){
							parent.$('#win').window({
								iconCls: 'icon-add',
								title:'添加商品',
								top:'100',
								width:400,    
    							height:600,  
							    content:'<iframe src="send_product_save.action" width="100%" height="100%" frameborder="0"/>' 
							}); 
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除商品',
						handler: function(){
							var rows=$('#dg').datagrid("getSelections");
							if(rows==0)	{								 	
							    $.messager.show({
									title:'删除提示',
									msg:'请至少选择一个删除',
									timeout:5000,
									showType:'slide'
								});}
								else{
									$.messager.confirm('删除确认','您确认想要删除记录吗？',function(r){ 
								 	if (r){    
									    var ids="";
									    for(var i=0;i<rows.length;i++){
									    	ids+=rows[i].id+",";
									    }
									    ids=ids.substring(0, ids.lastIndexOf(","));
									    $.post("product_deleteBatch.action",{ids:ids},function(result){
									    	if(result=="true"){
									    		$('#dg').datagrid('reload');  
									    		 $('#dg').datagrid('clearChecked');
									    	}else{
									    		$.messager.show({
													title:'删除提示',
													msg:'删除失败'
												});
									    	}
									    },"text");
										
									}   
 
							    });}	
						} 
					},'-',{
						text:"<input id='ss'>"
					}],
					
					queryParams:{
						name:'',											
					},				
					frozenColumns:
					[[{field : 'xyz',checkbox :true}
					]],
					columns : [ [ 
					{field : 'id',title : '编号',width : 100},
					{field : 'name',title : '商品名称',width : 100},
					 {field : 'remark',title : '简单介绍',width : 200},
					 {field : 'xremark',hidden:true},
					 {field : 'pic',hidden:true},
					 {field : 'commend',hidden:true},
					 {field : 'open',hidden:true},
					 {field : 'pic',hidden:true},
					  {field : 'category.type',title : '商品类别',width : 100,align : 'right'	,
					  	//返回商品类别
							formatter : function(value, row, index) {
								if (row.category!=null && row.category.type) {
								return row.category.type;
								}

						}}
					  ] ]
					});
					
					$('#ss').searchbox({ 
						searcher:function(value,name){ 
							$('#dg').datagrid('load',{
									name: value
								});
						}, 
						menu:'查询', 
						prompt:'请输入要查询的商品名称' 
						}); 
					});
				
				
			</script>
  	
  </head>
  
  <body>
 		<table id="dg"></table>
 		
  </body>
</html>
