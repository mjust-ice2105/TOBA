package toba.filters;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import toba.util.CookieUtil;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */


public class LoginServletRequestFilter implements Filter{
    
    
    //
    private FilterConfig filterConfig = null;
    
    //
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    
    
    
    
    
    //
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
    throws IOException, ServletException {
        
        //
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        ServletContext sc = filterConfig.getServletContext();
        
        //
        String logString = filterConfig.getFilterName() + " | ";
        logString += "Servlet path: " + httpRequest.getServletPath() + " | ";
        
        
        Cookie[] cookies = httpRequest.getCookies();
        String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
        
        logString += "Email cookie: ";
        if(emailAddress.length() !=0)
            logString += emailAddress;
        else
            logString += "Not Found";
        
        sc.log(logString);
        
        chain.doFilter(httpRequest, response);
        
    }
    
    
    //
    @Override
    public void destroy() {
        filterConfig = null;
    }
    
    
    
    
}
