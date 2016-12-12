package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	public List<Category> queryJoinAccount(String type,int page,int rows);
	public Long getCount(String type);
	public void deleteByIds(String ids);
	public abstract List<Category> queryListByHot(boolean hot);
	
}
