package com.project.eva.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {
                "com.project.eva.controller",
                "com.project.eva.config"
        }
)
@PropertySource("classpath:content.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${view.type}")
    private String contentType;

    @Value("${view.name-prefix}")
    private String prefix;

    @Value("${view.name-suffix}")
    private String suffix;

    @Value("${view.expose_beans_as_attributes}")
    private boolean exposeContextBeansAsAttributes;

    @Value("${resources.url}")
    private String resourcesUrl;

    @Value("${resources.location}")
    private String resourcesLocation;

    @Value("${login.url}")
    private String loginUrl;

    @Value("${login.view}")
    private String loginView;

    /**
     * Указывает Spring'у где находятся компоненты представления, и как их отображать.
     * Вьюшкибудут лежать в директории /WEB-INF/views/ и иметь разширение *.jsp.
     *
     * @return Реализация интерфейса ViewResolver с настройками для вьюшек.
     */
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setContentType(this.contentType);
        viewResolver.setPrefix(this.prefix);
        viewResolver.setSuffix(this.suffix);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

    /**
     * Указывает где будут хранится ресурсы.
     *
     * @param resource Объект класса ResourceHandlerRegistry с настройками для ресурсов.
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry resource) {
        resource.addResourceHandler(this.resourcesUrl)
                .addResourceLocations(this.resourcesLocation);
    }

    /**
     * Настройка логин-контроллера.
     * Оказывает помощь в регистрации простого автоматизированного
     * логин-контроллера предварительно сконфигурированных с кодом
     * состояния и вьюшкой.
     *
     * @param viewController Объект класса ViewControllerRegistry.
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry viewController) {
        viewController.addViewController(this.loginUrl).setViewName(this.loginView);
        viewController.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
