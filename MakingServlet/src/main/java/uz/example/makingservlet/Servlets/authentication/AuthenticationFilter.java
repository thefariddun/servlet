package uz.example.makingservlet.Servlets.authentication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/filter")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        if (username.equals("John") && password.equals("John")) {
            writer.write("Successfully");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            writer.write("wrong password");
            RequestDispatcher rd
                    = servletRequest.getRequestDispatcher("index.html");
            rd.include(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
