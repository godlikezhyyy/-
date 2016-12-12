package cn.it.shop.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.BaseDao;
import cn.it.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	
	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Class clazz;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public BaseDaoImpl(){
		System.out.println("----------------------1---------------------"+this);
		ParameterizedType p=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class)p.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T t) {
		getSession().save(t);
		
	}

	@Override
	public void update(T t) {
		getSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		String hql="delete from "+clazz.getSimpleName()+" where id=:id";
		
		getSession().createQuery(hql)
			.setInteger("id", id)
			.executeUpdate();
		
	}


	@Override
	public T get(int id) {
		return (T)getSession().get(clazz, id);
		
	}

	@Override
	public List<T> query() {
		String hql="From "+clazz.getSimpleName();
		return getSession().createQuery(hql)
				.list();
		
	}
	
}
