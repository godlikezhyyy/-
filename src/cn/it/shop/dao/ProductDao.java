package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;

public interface ProductDao extends BaseDao<Product> {
	public List<Product> queryJoinCategory(String name,int page,int rows);

	public Long getCount(String name);
	
	public void deleteByIds(String ids);

	public abstract List<Product> queryListByType(int id);
}
