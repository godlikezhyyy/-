package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashSet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	
	public String addToForder(){
		Product product=productService.get(model.getProduct().getId());		
		Forder forder;
		if(session.get("forder")==null){
			forder=new Forder();
			session.put("forder", forder);
		}else{
			forder=(Forder) session.get("forder");
		}
		sorderService.addToForder(forder, product);
		forder.totalPrice();
		return "cart";	
	}
	
	
	public String reCalculate(){
		Forder forder=(Forder) session.get("forder");
		sorderService.reCalculate(forder, model);
		forder.totalPrice();
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public String delete(){
		Forder forder=(Forder) session.get("forder");
		sorderService.reMove(forder, model);
		forder.totalPrice();
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
		
	}
	
	public String clearForder(){
		Forder forder=(Forder) session.get("forder");
		sorderService.clearForder(forder);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
}
