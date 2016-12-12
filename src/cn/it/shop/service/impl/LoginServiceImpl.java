package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.User;
import cn.it.shop.service.LoginService;

@Service("loginService")
public class LoginServiceImpl extends BaseServiceImpl<User> implements
		LoginService {

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	

}
