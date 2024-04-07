package uz.example.makingservlet.Servlets.initialization;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContextServlet", urlPatterns = "/context")
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = getServletContext().getInitParameter("authorizationToken");
        PrintWriter writer = resp.getWriter();
        if(token!=null)
            System.out.println("The token is "+ token);
        writer.write("The token is "+token);
    }
}
