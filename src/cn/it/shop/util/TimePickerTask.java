package cn.it.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;

@Component("timePickerTask")
public class TimePickerTask extends TimerTask {

	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductService productService;
	
	private ServletContext servletContext;
	
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}


	@Override
	public void run() {
		List<Category> categoryList=categoryService.queryListByHot(true);
		List<List<Product>> bigList=new ArrayList<List<Product>>();
		for(Category category:categoryList){
			List<Product> productList=productService.queryListByType(category.getId());
			bigList.add(productList);
		}
		servletContext.setAttribute("bigList", bigList);

	}

}
