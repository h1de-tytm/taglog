package com.taglog.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.taglog.web")
public class WebConfig extends WebMvcConfigurerAdapter{
	  @Bean
	  public ViewResolver viewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    return resolver;
	  }
	  
	  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	  }
	  
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");
	    super.addResourceHandlers(registry);
	  } 
	    @Bean
	    public FilterRegistrationBean getFilterRegistrationBean() {
	        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
	        filterRegistrationBean.setFilter(new CharacterEncodingFilter());
	        return filterRegistrationBean;
	    }

	    /**
	     * リクエストのエンコーディングをUTF-8にします。
	     */
	    private static class CharacterEncodingFilter implements Filter {
	        protected String encoding;
	        public void init(FilterConfig filterConfig) throws ServletException {
	            encoding = "UTF-8";
	        }
	        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
	                             FilterChain filterChain) throws IOException, ServletException {

	            HttpServletRequest request = (HttpServletRequest) servletRequest;
	            request.setCharacterEncoding(encoding);
	            filterChain.doFilter(servletRequest, servletResponse);
	        }
	        public void destroy() {
	            encoding = null;
	        }
	    }

}
