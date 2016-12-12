package cn.it.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Account;
import cn.it.shop.model.FileImage;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ForderService;
import cn.it.shop.service.LoginService;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.SorderService;
import cn.it.shop.util.FileImageUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{

	protected Map<String, Object> request;
	protected Map<String,Object> session;
	protected Map<String, Object> application;
	protected T model;
	protected int page;
	protected int rows;
	protected String ids;
	protected Map<String,Object> pageMap=null;	
	protected InputStream inputStream;
	protected List<T> selectList;
	
	protected FileImage fileimage;
	
	
	

	public FileImage getFileimage() {
		return fileimage;
	}

	public void setFileimage(FileImage fileimage) {
		this.fileimage = fileimage;
	}

	public List<T> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<T> selectList) {
		this.selectList = selectList;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	@Resource
	protected AccountService accountService;
	@Resource
	protected ProductService productService;
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected FileImageUtil fileImageUtil;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected LoginService loginService;
	@Resource
	protected ForderService forderService;
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}

	@Override
	public T getModel() {
		ParameterizedType parameterizedType= (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class)parameterizedType.getActualTypeArguments()[0];
		try {
			model=(T) clazz.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return model;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public Map<String, Object> getPageMap() {
		System.out.println("getpageMap");
		return pageMap;
	}

	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}
}
