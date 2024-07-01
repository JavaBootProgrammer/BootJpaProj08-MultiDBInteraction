package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.nt.repository.promotions",
                                                 entityManagerFactoryRef = "mysqlEMF",
                                                 transactionManagerRef = "mysqlTxMgmr")
@EnableTransactionManagement
public class MySQLDBConfig {
	
	
	
	@Bean(name="mySQLDs")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public   DataSource  createMySQLDs() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlEMF")
	public LocalContainerEntityManagerFactoryBean  createMySQLEMF(EntityManagerFactoryBuilder builder) {
		  //prepare  Oracle Hibernate Properties
		    Map<String,String>  props=new HashMap();
		    props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		    props.put("hibernate.hbm2ddl.auto","update");
		    props.put("hibernate.show_sql", "true");
		 //  create and  return LocalContainerEntityMangerFactoryBean class obj  which
		    // is  FactoryBean  giving EntityManagerFactoryBean class obj
		    
		    return  builder.dataSource(createMySQLDs())
		    		      .packages("com.nt.model.promotions")
		    		      .properties(props)
		    		      .build();
	}
	
	
	@Bean(name="mysqlTxMgmr")
	public  JpaTransactionManager  createMySQLTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory  factory) {
		return  new JpaTransactionManager(factory);
	}
	

}