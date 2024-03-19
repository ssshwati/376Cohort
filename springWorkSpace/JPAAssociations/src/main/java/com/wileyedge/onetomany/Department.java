 package com.wileyedge.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="dept2")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "dname")
	private String name;
	
    //The mappedBy attribute of @OneToMany annotation behaves the same as inverse = true
	//So "employees" is the relationship_owner and not the Department
	/*
	The annotation @JoinColumn indicates that this entity is the owner of the relationship (that is: the corresponding table has a column with a foreign key to the referenced table), 
	whereas the attribute mappedBy indicates that the entity in this side is the inverse of the relationship, and the owner resides in the "other" entity. 
	This also means that you can access the other table from the class which you've annotated with "mappedBy" (fully bidirectional relationship).
	*/
//	@OneToMany(targetEntity = Employee.class,mappedBy = "department")
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL)
	@JoinColumn(name="dept_id")
	private List<Employee> employees;	
	
	public Department(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
