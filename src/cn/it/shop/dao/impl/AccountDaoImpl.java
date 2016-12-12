package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.AccountDao;
import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements
		AccountDao {
	
	
}
