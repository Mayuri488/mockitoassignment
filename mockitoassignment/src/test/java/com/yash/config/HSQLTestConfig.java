package com.yash.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/*
 * This class is same as real PersistentConfig class in sources.
 * Only difference is that method dataSource & hibernateProperties 
 * implementations are specific to Hibernate working with H2 database.
 */

@Configuration
@ComponentScan({ "com.yash.config" })
@PropertySource(value = { "classpath:application-test.properties" })
public class HSQLTestConfig {

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource getDataSource(){
		DataSource dataSource = dataManageDataSource();
		DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
		return dataSource;
	}
	private DatabasePopulator createDatabasePopulator() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		//databasePopulator.addScript(new ClassPathResource("org.sql"));
		return databasePopulator;
	}


	public DriverManagerDataSource dataManageDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driverClassName"));
		driverManagerDataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		driverManagerDataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		driverManagerDataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));

		return driverManagerDataSource;
	}


	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}



}
