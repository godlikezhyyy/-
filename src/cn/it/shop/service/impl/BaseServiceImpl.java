package cn.it.shop.service.impl;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.AccountDao;
import cn.it.shop.dao.BaseDao;
import cn.it.shop.dao.CategoryDao;
import cn.it.shop.dao.ForderDao;
import cn.it.shop.dao.ProductDao;
import cn.it.shop.dao.SorderDao;
import cn.it.shop.dao.UserDao;
import cn.it.shop.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
	
	
	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Class clazz;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public BaseServiceImpl(){
		System.out.println("-------------1----------"+this);
		ParameterizedType p=(ParameterizedType)this.getClass().getGenericSuperclass();
		clazz=(Class)p.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init(){
		String field=clazz.getSimpleName().substring(0, 1).toLowerCase()+
				clazz.getSimpleName().substring(1)+"Dao";
		try {
			Field classfield=this.getClass().getSuperclass().getDeclaredField(field);			
			baseDao=(BaseDao) classfield.get(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected BaseDao baseDao;
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected SorderDao sorderDao;
	@Override
	public void save(T t) {
		baseDao.save(t);		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
		
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
		
	}


	@Override
	public T get(int id) {
		return (T) baseDao.get(id);
		
	}

	@Override
	public List<T> query() {
		return baseDao.query();
		
	}
	
}
