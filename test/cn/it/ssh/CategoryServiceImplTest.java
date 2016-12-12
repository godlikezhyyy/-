package cn.it.ssh;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceImplTest {
	
	@Resource
	private CategoryService categoryService;
	
	
	@Test
	public void testSave() {
		categoryService.save(new Category("男士休闲4", false));
	}

	@Test
	public void testUpdate() {
		categoryService.update(new Category(4,"男士休闲4", true));
	}

	@Test
	public void testDelete() {
		categoryService.delete(4);
	}

	@Test
	public void testGet() {
		Category c=categoryService.get(4);
		System.out.println(c);
	}

	@Test
	public void testQuery() {
		for(Category c:categoryService.query()){
			System.out.println(c);
		}
	}
	
	@Test
	public void testQueryList() {
		List<Category> categoryList=categoryService.queryJoinAccount("休闲",2,2);
		for(Category temp:categoryList){
			System.out.println(temp.getAccount().getName());
		}
	}
	@Test
	public void testDeleteByIds(){
		categoryService.deleteByIds("1,2,3,4,5");
	}
}
