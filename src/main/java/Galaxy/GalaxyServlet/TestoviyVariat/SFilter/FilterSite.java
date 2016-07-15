package Galaxy.GalaxyServlet.TestoviyVariat.SFilter;

import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.UserAccount.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspApplicationContext;
import java.io.IOException;

/**
 * Created by Admin on 04.02.2016.
 */
public class FilterSite extends Dispatcher implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext r=filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if(request.getSession().getAttribute("user")!=null){
    filterChain.doFilter(request,response);}


    }

    @Override
    public void destroy() {

    }
}
