<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
  	 <%@include file="/public/head.jspf" %>
  	<script type="text/javascript">
  			$(function(){
  				//表格设置
				$('#dg').datagrid({
					url : 'category_queryPage.action',
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
						text:'编辑按钮',
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
								title:'更新类别',
								top:'100',
								width:300,    
    							height:400,  
							    content:'<iframe src="send_category_update.action" width="100%" height="100%" frameborder="0"/>' 
							}); 
							}
						}
					},'-',{
						iconCls: 'icon-add',
						text:'添加按钮',
						handler: function(){
							parent.$('#win').window({
								iconCls: 'icon-add',
								title:'添加类别',
								top:'100',
								width:300,    
    							height:400,  
							    content:'<iframe src="send_category_save.action" width="100%" height="100%" frameborder="0"/>' 
							}); 
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除按钮',
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
									    $.post("category_deleteBatch.action",{ids:ids},function(result){
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
						type:'',											
					},				
					frozenColumns:
					[[{field : 'xyz',checkbox :true}
					]],
					columns : [ [ 
					{field : 'id',title : '编号',width : 100},
					{field : 'type',title : '商品类别',width : 100},
					 {field : 'hot',title : '热点',width : 100,align : 'right',
					 		formatter : function(value, row, index) {
								if (value) {
								return "<input type='checkbox' checked='checked' disabled>";
								}else{
								return "<input type='checkbox'  disabled>";
								}

						}},
					  {field : 'account.login',title : '管理员',width : 100,align : 'right',		
							//返回管理员
							formatter : function(value, row, index) {
								if (row.account!=null && row.account.login) {
								return row.account.login;
								}

						}} ] ]
					});
					
					$('#ss').searchbox({ 
						searcher:function(value,name){ 
							$('#dg').datagrid('load',{
									type: value
								});
						}, 
						menu:'查询', 
						prompt:'请输入要查询的商品类型' 
						}); 
					});
				
				
			</script>
  	
  </head>
  
  <body>
 		<table id="dg"></table>
 		
  </body>
</html>
