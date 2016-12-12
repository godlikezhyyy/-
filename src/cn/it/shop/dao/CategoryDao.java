package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Category;

public interface CategoryDao extends BaseDao<Category>{
	public List<Category> queryJoinAccount(String type,int page,int rows);
	public Long getCount(String type);
	public void deleteByIds(String ids);
	public abstract List<Category> queryListByHot(boolean hot);
	
}
