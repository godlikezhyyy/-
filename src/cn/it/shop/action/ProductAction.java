package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	public String queryPage(){
		pageMap=new HashMap<String, Object>();
		//取得商品类别的
		List<Product> productList=productService.queryJoinCategory(model.getName(), page, rows);
		//取得商品总件数
		Long total=productService.getCount(model.getName());
		//将商品类别和总件数放到pageMap中
		pageMap.put("total", total);
		pageMap.put("rows", productList);
		return "jsonMap";
	}
	
	public String deleteBatch(){
		productService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
		
	}
	
	public void save(){
		String pic=fileImageUtil.fileUpload(fileimage);
		model.setPic(pic);
		productService.save(model);
	}
	
	public void update(){
		if(fileimage.getFile()!=null){
			String pic=fileImageUtil.fileUpload(fileimage);
			fileImageUtil.deleteImage(model.getPic());
			model.setPic(pic);
			
		}
		
		productService.save(model);
		
		
	}
	
	public String saveTemp(){
		inputStream=new ByteArrayInputStream(fileImageUtil.fileUpload(fileimage).getBytes());
		return "stream";
		
		
	}
	
	public String get(){
		model=productService.get(model.getId());
		request.put("product", model);
		return "detail";
	}
	
}
