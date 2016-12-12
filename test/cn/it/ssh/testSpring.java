package cn.it.ssh;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class testSpring {
	@Resource
	private ProductService productvice;
	
	
	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void testUpdate(){
		Category category=new Category(1,"女装",false);
		categoryService.update(category);
		
	}
	@Test
	public void testProductAction(){
		List<Product> productList=productvice.queryJoinCategory("圣得西服", 1, 2);
		for(Product p:productList){
			p.getCategory().getType();
		}
	}
	
}
