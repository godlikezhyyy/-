package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

	public void update(){
		categoryService.update(model);		
	}
	public String query(){
		request.put("categoryList", categoryService.query());
		return "index";
	}
	public String aindex(){
		System.out.println(1);
		return "aindex";
	}
	public String index(){
		System.out.println(1);
		return "easyui";
	}
	
	public String queryPage(){
		pageMap=new HashMap<String, Object>();
		//取得商品类别的
		List<Category> categoryList=categoryService.queryJoinAccount(model.getType(), page, rows);
		//取得商品总件数
		Long total=categoryService.getCount(model.getType());
		//将商品类别和总件数放到pageMap中
		pageMap.put("total", total);
		pageMap.put("rows", categoryList);
		return "jsonMap";
	}
	
	public String deleteBatch(){
		categoryService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		categoryService.save(model);
	}
	public String queryCategory(){
		selectList=categoryService.query();
		return "categoryList";		
	}
}
