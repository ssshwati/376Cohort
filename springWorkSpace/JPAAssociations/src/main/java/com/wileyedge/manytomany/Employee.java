package com.wileyedge.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="empl3")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "firstname")
	private String fname;
	@Column(name = "lastname")
	private String lname;
	@ManyToMany(targetEntity = TechSkill.class)
	private List<TechSkill> skills;

	public Employee() {
		super();
	}

	public Employee(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<TechSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<TechSkill> skills) {
		this.skills = skills;
	}
	
	
}
