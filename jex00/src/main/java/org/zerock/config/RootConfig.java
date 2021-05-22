package org.zerock.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 해당 클래스의 인스턴스를 이용해서 설정 파일을 대신함
@Configuration
@ComponentScan(basePackages= {"org.zerock.sample"})
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=UTC");
		hikariConfig.setUsername("book_ex");
		hikariConfig.setPassword("1q2w3e4r!");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource;
	}
}
