package com.bit.sts11.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.Driver;

@Configuration
public class RootConfig {

	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Driver.class.getTypeName());
		dataSource.setUrl("jdbc:mysql://localhost:3306/scott");
		dataSource.setUsername("user01");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
	}
}
