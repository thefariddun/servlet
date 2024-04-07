package uz.example.makingservlet.Servlets.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/header")
public class Headers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("Display Header Request"+
                req.getMethod()+" "
        +req.getRequestURI()+" "
        +req.getProtocol()+ " "
        +" HeaderValue");

        Enumeration headerNames= req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName =(String) headerNames.nextElement();
            writer.write(headerName);
            writer.write(req.getHeader(headerName));
        }
    }
}
