package com.example.demo.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试无效
 */
@Configurable
public class WebConfiguration extends WebMvcAutoConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }
    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
        filterRegistration.setFilter(new MyFilter());
        filterRegistration.addUrlPatterns("/*");
        Map map=new HashMap();
        map.put("paramName","paramValue");
        filterRegistration.setInitParameters(map);
        filterRegistration.setName("MyFilter");
        filterRegistration.setOrder(1);
        return filterRegistration;
    }
    public class MyFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpRequest httpRequest = (HttpRequest) servletRequest;
            System.out.println("this is myFilter,url:"+httpRequest.getURI());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }
}
