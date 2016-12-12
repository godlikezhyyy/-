package cn.it.shop.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.CategoryDao;
import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	public List<Category> queryJoinAccount(String type,int page,int count) {
		
		return getSession().createQuery("from Category c left join fetch c.account where c.type like :type")
				.setString("type", "%"+type+"%")
				.setFirstResult((page-1)*count)
				.setMaxResults(count).list();
	}
	
	public Long getCount(String type){
		String hql="select count(*) from Category c  where c.type like :type";
		return (Long)getSession().createQuery(hql).setString("type", "%"+type+"%")
		.uniqueResult();
		
	}

	@Override
	public void deleteByIds(String ids) {
		String hql="delete from Category where id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
		
	}
	
	@Override
	public List<Category> queryListByHot(boolean hot){
		String hql="from Category where hot=:hot";
		return getSession().createQuery(hql).setBoolean("hot", hot).list();
		
		
	}
}
