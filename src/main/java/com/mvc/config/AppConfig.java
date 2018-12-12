package com.mvc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@ComponentScan(basePackages = {"com.mvc.dao","com.mvc.service"})
//@Configuration
public class AppConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("pass");
        dataSource.setJdbcUrl("jdbc:mysql:///ggpt");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
