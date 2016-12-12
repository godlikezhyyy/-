package cn.it.shop.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	
	
	public String getAccount(){
		selectList=accountService.query();
		return "accountList";
		
	}
	
	
}
