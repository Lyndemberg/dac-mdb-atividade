package edu.ifpb.dac.mdbweb.filters;

import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lyndemberg
 */
@WebFilter(filterName="filtroSessao",urlPatterns={"/home.xhtml"})
public class FiltroSessao implements Filter{

 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession sessao = req.getSession();
        if(sessao.getAttribute("cliente") != null){
            chain.doFilter(request, response);
        }else{
            res.sendRedirect("index.xhtml");
        }
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }
    
}
