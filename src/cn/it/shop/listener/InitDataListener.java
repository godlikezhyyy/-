package cn.it.shop.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;
import cn.it.shop.util.TimePickerTask;

public class InitDataListener implements ServletContextListener {

	
	private TimePickerTask timePickerTask=null;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		timePickerTask=(TimePickerTask) applicationContext.getBean("timePickerTask");
		timePickerTask.setServletContext(sce.getServletContext());
		new Timer(true).schedule(timePickerTask, 0, 200000);
		
	}

}
