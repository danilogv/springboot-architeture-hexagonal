package com.danilo.springbootarchiteturehexagonal.configuration;

import com.danilo.springbootarchiteturehexagonal.domain.utility.Functions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
            .create()
            .url(Functions.decodedBase64(this.url))
            .username(Functions.decodedBase64(this.username))
            .password(Functions.decodedBase64(this.password))
            .build()
        ;
    }

}
