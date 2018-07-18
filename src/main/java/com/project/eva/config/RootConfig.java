package com.project.eva.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.project.eva.repository")
@ComponentScan(basePackages = "com.project.eva.model")
public class RootConfig {

    /**
     * Переводит (перехватывает) любые JPA
     * или Hibernate исключения в Spring исключения.
     *
     * @return Реализация интерфейса
     * PersistenceExceptionTranslationPostProcessor.
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * Возвращает объект класса CommonsMultipartResolver,
     * который сохраняет временные файлы
     * во временный каталог сервлет контейнера.
     *
     * @return Объект класса CommonsMultipartResolver
     * для временного сохранения файлов.
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

