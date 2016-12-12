package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements
		ProductService {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int rows) {
		return productDao.queryJoinCategory(name, page, rows);
	}

	@Override
	public Long getCount(String name) {
		return productDao.getCount(name);
	}

	@Override
	public void deleteByIds(String ids) {
		productDao.deleteByIds(ids);
	}

	
	@Override
	public List<Product> queryListByType(int id){
		return productDao.queryListByType(id);
		
	}
}
