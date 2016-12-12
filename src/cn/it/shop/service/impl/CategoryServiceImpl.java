package cn.it.shop.service.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	public List<Category> queryJoinAccount(String type,int page,int count) {
		
		return categoryDao.queryJoinAccount(type, page, count);
	}
	
	public Long getCount(String type){
		return categoryDao.getCount(type);
		
	}

	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
		
	}
	
	@Override
	public List<Category> queryListByHot(boolean hot){
		return categoryDao.queryListByHot(hot);
		
		
	}
}
