package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	
	
	@Override
	public Forder getModel() {
		model=(Forder) session.get("forder");
		return model;
	}

	public String saveForder(){
		
		User user=(User)session.get("user");
		model.setUser(user);
		model.setStatus(new Status(1));
		forderService.save(model);
		session.put("oldForder", model);
		session.put("forder", new Forder());
		return "success";
	}
}
