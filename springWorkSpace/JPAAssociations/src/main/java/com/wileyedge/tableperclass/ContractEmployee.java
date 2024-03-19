package com.wileyedge.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "contra5")
//@DiscriminatorValue(value = "c") // for singletable
public class ContractEmployee extends Employee {
	
	private String contractorname;

	public ContractEmployee(String fname, String lname,String contractorname) {
		super(fname, lname);
		this.contractorname=contractorname;
	}

	public String getContractorname() {
		return contractorname;
	}

	public void setContractorname(String contractorname) {
		this.contractorname = contractorname;
	}
	
}
