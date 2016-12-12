package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.it.shop.dao.ForderDao;
import cn.it.shop.model.Forder;
import cn.it.shop.service.ForderService;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements
		ForderDao {

}
