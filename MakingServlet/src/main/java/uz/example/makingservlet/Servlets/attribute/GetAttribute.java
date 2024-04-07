package uz.example.makingservlet.Servlets.attribute;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GetAttribute",urlPatterns = "/get")
public class GetAttribute extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getAttribute("error")==null) {
            String username = (String) req.getAttribute("username");
            String password = (String) req.getAttribute("password");
            System.out.println(username + " " + password);
        }
    }
}
