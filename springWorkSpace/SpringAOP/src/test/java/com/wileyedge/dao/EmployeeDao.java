package com.wileyedge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.wileyedge.model.Employee;

@Component(value = "dao")
public class EmployeeDao implements IDao {
	@Autowired
	private JdbcTemplate template;
	public void saveEmployee(Employee e) {
//		System.out.println("inside DAO(data) layer");
		String sql = "insert into Employee (id,fname,lname) values(?,?,?)";
		template.update(sql, e.getId(),e.getFname(),e.getLname());
	}

	public void modifyEmployee(Employee e) {
		
	}

	public List<Employee> getAllEmployees() {
		String sql="select * from Employee";
		return template.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));	
	}

	public Employee getEmployeeById(int empid) {
		String sql="select * from Employee where id=?";
		return template.queryForObject(sql, new Object[]{empid},new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public String getEmployeeNameById(int empid) {
		String sql="select fname from Employee where id=?";
		return template.queryForObject(sql, String.class, empid);
	}

	public int getEmployeeCount() {
		String sql="select count(*) from Employee";
		return template.queryForObject(sql, Integer.class);
	}

}
