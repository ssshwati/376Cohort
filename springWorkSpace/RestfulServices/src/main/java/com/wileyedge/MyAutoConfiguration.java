package com.wileyedge;

import java.util.Properties;
import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:mysql.properties")
public class MyAutoConfiguration {
	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	@ConditionalOnMissingBean
	public DataSource getDataSource() {
		System.out.println("Inside getDataSource() of MyAutoConfiguration");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/customdb?createDatabaseIfNotExist=true");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean(name = "entityManagerFactory")
	@ConditionalOnBean(name = "dataSource") // include entityManagerFactory bean only if a dataSource bean is present.
											// sequence matters.define dataSource bean prior. @ConditionalOnMissingBean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		System.out.println("Inside LocalContainerEntityManagerFactoryBean() of MyAutoConfiguration");
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("com.wileyedge");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(additionalProperties());
		return emf;
	}

	@Bean
	@ConditionalOnResource(resources = "classpath:mysql.properties")
	public Properties additionalProperties() {
		System.out.println("Inside additionalProperties() of Myautoconfiguration class");
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("mysql-hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("mysql-hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("mysql-hibernate.show_sql"));
		return hibernateProperties;
	}
}