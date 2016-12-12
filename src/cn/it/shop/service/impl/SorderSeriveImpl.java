package cn.it.shop.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;

@Service("sorderService")
public class SorderSeriveImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Forder addToForder(Forder forder, Product product) {
		Sorder sorder=new Sorder();
		sorder=setSorder(sorder, product);
		boolean isHave=false;
		for(Sorder temp:forder.getSorderList()){
			if(sorder.equals((temp))){
				temp.setNumber(sorder.getNumber()+temp.getNumber());
				isHave=true;
				break;
			}
		}
		if(!isHave){
		sorder.setForder(forder);
		forder.getSorderList().add(sorder);
		}
		return forder;
	}
	
	@Override
	public Sorder setSorder(Sorder sorder, Product product){
		sorder.setName(product.getName());
		sorder.setPrice(product.getPrice());
		sorder.setNumber(1);
		sorder.setProduct(product);
		return sorder;
		
	}

	@Override
	public Forder reCalculate(Forder forder, Sorder sorder) {
		
		for(Sorder temp: forder.getSorderList()){
			if(temp.getProduct().equals(sorder.getProduct())){
				temp.setNumber(sorder.getNumber());
				break;
			}
		}
		return forder;
	}

	@Override
	public Forder reMove(Forder forder, Sorder sorder) {
		for(Sorder temp: forder.getSorderList()){
			if(temp.getProduct().equals(sorder.getProduct())){
				forder.getSorderList().remove(sorder);
				break;
			}
		}
		return forder;
	}

	@Override
	public Forder clearForder(Forder forder) {
		forder.setSorderList((new ArrayList<Sorder>()));
		forder.setName(null);
		forder.setTotal(null);
		return forder;
	}
	
	

}
