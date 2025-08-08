package com.br.gov.ms.campogrande.apiemha.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "dbemhaDataSourceProperties")
    @ConfigurationProperties(prefix = "app.datasource.dbemha")
    public DataSourceProperties dbEmhaDsProps() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "dbemhaDataSource")
    public DataSource dbEmhaDs(@Qualifier("dbemhaDataSourceProperties") DataSourceProperties dsProps) {
        return dsProps.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "dbemhaJdbcClient")
    public JdbcClient dbEmhaJdbcClient(@Qualifier("dbemhaDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean(name = "dbacessosDataSourceProperties")
    @ConfigurationProperties(prefix = "app.datasource.dbacessos")
    public DataSourceProperties dbAcessosDsProps() {
        return new DataSourceProperties();
    }

    @Bean(name = "dbacessosDataSource")
    public DataSource dbAcessosDs(@Qualifier("dbacessosDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dbacessosJdbcClient")
    public JdbcClient dbAcessosJdbcClient(@Qualifier("dbacessosDataSource") DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }
}
