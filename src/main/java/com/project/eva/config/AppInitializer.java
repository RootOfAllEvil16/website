package com.project.eva.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
                RootConfig.class,
                DatabaseConfig.class,
                SecurityConfig.class
        };
    }

   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    
    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        final Filter filter = new CharacterEncodingFilter();
        final FilterRegistration.Dynamic dynamic = servletContext.addFilter("encodingFilter", filter);
        dynamic.setInitParameter("encoding", "UTF-8");
        dynamic.setInitParameter("forceEncoding", "true");
        dynamic.addMappingForUrlPatterns(null, true, "/*");
    }

  
    @Override
    protected DispatcherServlet createDispatcherServlet(final WebApplicationContext context) {
        final DispatcherServlet dispatcherServlet =
                (DispatcherServlet) super.createDispatcherServlet(context);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }
}
