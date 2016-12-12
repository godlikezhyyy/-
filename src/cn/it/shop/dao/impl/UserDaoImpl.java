package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import cn.it.shop.dao.UserDao;
import cn.it.shop.model.User;
import cn.it.shop.service.LoginService;

@Repository("loginDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements
		UserDao {

	@Override
	public User login(User user) {
		String hql="From User where login=:login and pass=:pass";
		return (User)getSession().createQuery(hql)
		.setString("login", user.getLogin())
		.setString("pass", user.getPass())
		.uniqueResult();
	}

	

}
