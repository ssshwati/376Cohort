package com.wileyedge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.model.Employee;


@Repository(value="dao")
public class EmployeeDao implements IDao {

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveEmployee(Employee e) {
//		System.out.println("Inside Dao layer");
		String sql = "insert into employee (id,fname,lname) values(?,?,?)";
		template.update(sql, e.getEid(), e.getFname(), e.getLname() );
	}
	
	

	public void modifyEmployee(Employee e) {
		
	}



	public List<Employee> getAllEmployees() {
		String sql = "select * from employee";
		List<Employee> res = template.query(sql, 
//				new BeanPropertyRowMapper<Employee>(Employee.class));
				new EmployeeRowMapper());
		return res;
	}



	public Employee getEmployeeById(int empid) {
		String sql = "select * from employee where id = ?";
		Employee res = template.queryForObject(sql, new Object[] {empid},
//				new BeanPropertyRowMapper<Employee>(Employee.class));
				new EmployeeRowMapper());
		return res;
	}



	public String getEmployeeNameById(int empid) {
		String sql = "select fname from employee where id = ?";
		String res = template.queryForObject(sql, String.class,empid);
		return res;
	}



	public int getEmployeeCount() {
		String sql = "select count(*) from employee";
		int res = template.queryForObject(sql, Integer.class);
		return res;
	}

}
