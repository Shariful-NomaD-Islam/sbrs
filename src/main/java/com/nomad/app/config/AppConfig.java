package com.nomad.app.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sql.DataSource;


@Configuration
public class AppConfig {

    private final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "datasource-01")
    public DataSource datasource01() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db1.driver"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("db1.url"));
        dataSource.setUsername(environment.getRequiredProperty("db1.user"));
        dataSource.setPassword(environment.getRequiredProperty("db1.password"));
        dataSource.setAutoCommit(true);
        dataSource.setMaximumPoolSize(environment.getRequiredProperty("max.poolSize", Integer.class) * 2);
        return dataSource;
    }

    @Bean(name = "jdbc-01")
    public JdbcTemplate jdbcTemplate01(@Qualifier("datasource-01") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setFetchSize(environment.getRequiredProperty("db1.fetchSize", Integer.class));
        return jdbcTemplate;
    }

    @Bean
    public LobHandler lobHandler() {
        return new DefaultLobHandler();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
