package com.example.springboot_demo.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter("/user/*")
public class FilterDemo implements Filter {

    public static int i = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行init方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行doFilter方法 + " + i++);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("执行destroy方法");
    }
}
