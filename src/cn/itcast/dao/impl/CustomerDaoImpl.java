package cn.itcast.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.exception.DaoException;
import cn.itcast.utils.BeanHandler;
import cn.itcast.utils.BeanListHandler;
import cn.itcast.utils.IntegerHandler;
import cn.itcast.utils.JdbcUtils;

public class CustomerDaoImpl {

	public void add(Customer c){
		try{
			String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			Object params[] = {c.getId(),c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription()};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	public void update(Customer c){
		try{
		String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		Object params[] = {c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription(),c.getId()};	
		JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	public void delete(String id){
		try{
			String sql = "delete from customer where id=?";
			Object params[] ={id};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	public Customer find(String id){
		
		try{
			String sql = "select * from customer where id=?";
			Object params[] ={id};
			return (Customer) JdbcUtils.query(sql, params, new BeanHandler(Customer.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}

	
	//获取分页数据
	public List<Customer> getPageData(int startindex,int pagesize){
		try{
			String sql = "select * from customer limit ?,?";
			Object params[] = {startindex,pagesize};
			return (List<Customer>) JdbcUtils.query(sql, params, new BeanListHandler(Customer.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	//得到总记录数
	public int getTotalrecord(){
		try{
			String sql = "select count(*) from customer";
			Object params[] = {};
			long l =  (Long) JdbcUtils.query(sql,params,new IntegerHandler());
			return (int)l;
		}catch (Exception e) {
			 throw new DaoException(e);
		}	
	}
	
}
