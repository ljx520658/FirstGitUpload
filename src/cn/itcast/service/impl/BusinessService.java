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
			//�����û��뿴��һҳ������
			Page page = new Page(totalrecord,1);  //�������ҳ�����Լ��û��뿴��ҳ�����ݿ��ĸ��ط���ʼȡ
			List list = dao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			return page;
		}else{
			//�����û��뿴ָ����ҳ
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
