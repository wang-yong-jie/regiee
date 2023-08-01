package com.nitty.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.nitty.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否已经完成登录
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    /**
     * 路径匹配器，支持通配符的写法
     */
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("拦截到请求：{}", request.getRequestURI());
        /**
         * 1. 获取本次请求的URI
         * 2. 判断本次请求是否需要处理
         * 3. 如果不需要处理，则直接放行
         * 4. 判断登录状态，如果已登录，则直接放行
         * 5. 如果未登录，则返回登录结果
         */
        String requestURI = request.getRequestURI();

        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };
        boolean check = check(urls, requestURI);
        if (check) {
            log.info("本次请求{}不需要处理", requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getSession().getAttribute("employee") != null) {
            Long id = (Long) request.getSession().getAttribute("employee");
            log.info("用户已经登录，用户ID为：{}", id);
            filterChain.doFilter(request, response);
            return;
        }

        log.info("用户还没有登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    /**
     * 判断路径是否匹配
     *
     * @param urls
     * @param uri
     * @return
     */
    public boolean check(String[] urls, String uri) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, uri);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
