package cn.it.shop.service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder>{
	
	public Forder addToForder(Forder forder, Product product);

	public Sorder setSorder(Sorder sorder, Product product);
	
	public Forder reCalculate(Forder forder,Sorder sorder);
	
	public Forder reMove(Forder forder,Sorder sorder);
	
	public Forder clearForder(Forder forder);
}	
