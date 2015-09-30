package net.anotheria.moskito.feedback.rest.resource.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author andriiskrypnyk
 */
public class CrossDomainFilter implements Filter {

    public static final String[] ALLOWED_HOSTS = new String[]{"http://sergiichuk.com", " http://moskito.org"};


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!(servletResponse instanceof HttpServletResponse))
            return;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        for (String allowedHost : ALLOWED_HOSTS) {
            if (request.getHeader("origin") != null && request.getHeader("origin").equalsIgnoreCase(allowedHost)) {
                response.setHeader("Access-Control-Allow-Origin", allowedHost);
                response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
            }
        }

        response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
