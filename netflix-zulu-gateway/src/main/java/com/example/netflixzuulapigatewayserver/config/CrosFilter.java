//package com.example.netflixzuulapigatewayserver.config;//package com.tgrajkowski.authortization.config;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class CrosFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        final HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
////        response.
//        response.setStatus(HttpServletResponse.SC_OK);
//
////        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) servletRequest).getMethod())) {
////        } else {
////            filterChain.doFilter(servletRequest, servletResponse);
////        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
