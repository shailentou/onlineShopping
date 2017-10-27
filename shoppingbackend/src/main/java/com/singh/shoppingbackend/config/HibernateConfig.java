package com.singh.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.singh.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_USER = "sa";
	private final static String DATABASE_PASSWORD = "";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";

	
	//Datasource Bean will be available
	@Bean
	private DataSource getDataSource()
	{
		// Provide
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);
		return null;
	}
	
	//Datasource Bean will be available
	@Bean
	private SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		
		builder.scanPackages("com.singh.shoppingbackend.dto");
		return  null; // builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		return null;
	}
	
	//Transaction Manager Bean will be available
		@Bean
		private HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}
	
	
}
