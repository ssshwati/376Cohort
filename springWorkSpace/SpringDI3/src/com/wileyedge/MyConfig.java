package com.wileyedge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // replacement of entire xml
@ComponentScan(basePackages = "com.wileyedge")
public class MyConfig {
	@Bean(name = "a4")
//	@Primary
	public Address getaddr1() {
		Address a = new Address(560068, "Bangalore", "Karnataka");
		return a;
	}

	@Bean(name = "a5")
	@Primary
	public Address getaddr2() {
		Address a = new Address(140301, "Mohali", "Chandigarh");
		return a;
	}
}
