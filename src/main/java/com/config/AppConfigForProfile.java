package com.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@Profile({"test"})
@PropertySource("classpath:/com/ex/db.properties")
@Configuration
public class AppConfigForProfile implements EmbeddedValueResolverAware {
    private String user;
    private String password;
    private String jdbcUrl;
    private String driverClass;

    @Profile("test")
    @Bean
    public DataSource testJdbc() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("dev")
    @Bean
    public DataSource devJdbc() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("prod")
    @Bean
    public DataSource jdbc() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        user = resolver.resolveStringValue("${jdbc.user}");
        password = resolver.resolveStringValue("${jdbc.password}");
        jdbcUrl = resolver.resolveStringValue("${jdbc.url}");
        driverClass = resolver.resolveStringValue("${jdbc.driverClass}");
    }
}
