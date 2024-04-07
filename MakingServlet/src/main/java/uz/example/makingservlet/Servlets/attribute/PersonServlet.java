package uz.example.makingservlet.Servlets.attribute;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.example.makingservlet.Servlets.model.Person;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username =req.getParameter("username");
        String password =req.getParameter("password");
        StringBuilder error = new StringBuilder();

        if(username==null)
            error.append("Username is not provided");
        else if(password==null)
            error.append("Password is not provided");

        if(error.length()>0) {
            req.setAttribute("error", error.toString());
            req.setAttribute("person", new Person());
        }
        else {
            req.setAttribute("person", new Person(username, password));
        }
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
