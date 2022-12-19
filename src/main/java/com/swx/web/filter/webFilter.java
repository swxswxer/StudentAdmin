package com.swx.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class webFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //判断访问资源路径是否跟登陆组册相关
        String[] urls = {"/static", "/stu-admin"};
        //获取当前访问的资源路径
        String url = req.getRequestURL().toString();
        System.out.printf("filter url: %s\n", url);
        for (String u : urls) {
            if (url.contains(u)) {
                //放行
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        //没有登陆 跳转到登陆页面
        req.getRequestDispatcher("/").forward(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}
