package com.br.gov.ms.campogrande.apiemha.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.br.gov.ms.campogrande.apiemha.repository.emha",
        entityManagerFactoryRef = "dbemhaEntityManagerFactory",
        transactionManagerRef = "dbemhaTransactionManager"
)
public class DbEmhaJpaConfig {

    @Primary
    @Bean(name = "dbemhaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbEmhaEntityManagerFactory(
            @Qualifier("dbemhaDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.br.gov.ms.campogrande.apiemha.model.emha")
                .persistenceUnit("dbemha")
                .build();
    }

    @Primary
    @Bean(name = "dbemhaTransactionManager")
    public PlatformTransactionManager dbEmhaTransactionManager(
            @Qualifier("dbemhaEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
