package com.dajiao.filter;

import com.dajiao.utils.JDBCUtils;
import javax.servlet.*;
import java.io.IOException;

public class AllFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        try {
            chain.doFilter(req, resp);
            JDBCUtils.commitAndClose();
        } catch (Exception e){
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            //将异常抛给tomcat服务器，统一管理
            throw new RuntimeException(e);
        }
    }
    @Override
    public void destroy() {

    }
}
