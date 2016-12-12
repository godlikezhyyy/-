package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	public String login(){
		model=loginService.login(model);
		if(model==null){
			session.put("error", "账号密码不对");
			return "ulogin";
		}else{
			session.put("user", model);
			if(session.get("next")==null){
				return "index";
			}else{			
			    return "next";
			}
		}
	}
}
