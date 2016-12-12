package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.ProductDao;
import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.ProductService;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements
		ProductDao {

	@Override
	public List<Product> queryJoinCategory(String name, int page, int rows) {
		return getSession().createQuery("from Product p left join fetch p.category where p.name like :name")
				.setString("name", "%"+name+"%")
				.setFirstResult((page-1)*rows)
				.setMaxResults(rows).list();
	}

	@Override
	public Long getCount(String name) {
		String hql="select count(*) from Product p where p.name like :name";
		return (Long)getSession().createQuery(hql).setString("name", "%"+name+"%")
		.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql="delete from Product where id in("+ids+")";
		getSession().createQuery(hql).executeUpdate();
	}

	
	@Override
	public List<Product> queryListByType(int id){
		String hql="From Product p join fetch p.category where p.commend=true and p.open=true and p.category.id=:id order by p.date desc";
		return getSession().createQuery(hql).setInteger("id", id)
				.setFirstResult(0).setMaxResults(4).list();
		
	}
}
