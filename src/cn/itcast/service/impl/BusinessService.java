package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Page;

public class BusinessService {

	CustomerDaoImpl dao = new CustomerDaoImpl();
	
	public void addCustomer(Customer customer){
		dao.add(customer);
	}
	
	
	
	public Page getPageData(String pagenum,String url){
		
		int totalrecord = dao.getTotalrecord();
		
		if(pagenum==null){
			//代表用户想看第一页的数据
			Page page = new Page(totalrecord,1);  //算出了总页数，以及用户想看的页从数据库哪个地方开始取
			List list = dao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//代表用户想看指定的页
			Page page = new Page(totalrecord,Integer.parseInt(pagenum)); 
			List list = dao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}
	}

	public Customer findCustomer(String id) {
		return dao.find(id);
		
	}

	public void updateCustomer(Customer c) {
		dao.update(c);
	}

	public void deleteCustomer(String id) {
		dao.delete(id);
		
	}
	
}
