package com.wileyedge;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component(value="e3") //replacement of the entry <bean id="e3" class = "com.wileyEdge.Employee">
public class Employee implements BeanNameAware, ApplicationContextAware{//, InitializingBean{
	@Value("30")
	private int id;
	@Value("Harsh")
	private String fname;
	@Value("Kankane")
	private String lname;
	@Autowired
//	@Qualifier(value="a5")
	private Address addr;
	private ApplicationContext context;

	public Employee() {
		System.out.println("Inside default constructor of Employee");
	}
	
	public Employee(int id, String fname, String lname, Address addr) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.addr = addr;
		System.out.println("Inside param constructor of Employee");		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println(" inside setid of employee ");
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
		System.out.println(" inside setfname of employee ");
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
		System.out.println(" inside setlname of employee ");
	}

	public Address getAddr() {
		return addr;
	}

	
	public void setAddr(Address addr) {
		this.addr = addr;
		System.out.println(" inside setaddr of employee");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + " ,Address = " + addr + "]";
	}
	
	@Override
	public void setBeanName(String arg0) {
		System.out.println("inside setBeanName() of Employee" + arg0);		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		System.out.println("inside setApplicationContext() of Employee" + context);		
		this.context = context;
	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("inside afterPropertiesSet() of Employee" );		
//	}
	
	public void myinit() {
		System.out.println("inside myinit() of Employee" );		
		this.fname="Lucky";
//		this.addr = context.getBean("a2",Address.class);
	}
	
	public void mydestroy() {
		System.out.println("inside mydestroy() of Employee" );	
		this.addr=null;
	}

}