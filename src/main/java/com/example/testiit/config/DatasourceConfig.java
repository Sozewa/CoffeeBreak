package com.example.testiit.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(System.getenv("SPRING_DATASOURCE_URL"))
                .username(System.getenv("SPRING_DATASOURCE_USERNAME"))
                .password(System.getenv("SPRING_DATASOURCE_PASSWORD"))
                .build();
    }
}
