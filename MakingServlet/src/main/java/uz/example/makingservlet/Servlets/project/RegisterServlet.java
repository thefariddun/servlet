package uz.example.makingservlet.Servlets.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer =resp.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        req.setAttribute("name", name);
        req.setAttribute("email", email);
        writer.write("email: "+email+" "+"name: "+name);

        StringBuilder error = new StringBuilder();

        if(name==null || email==null){
            error.append("Name or Email are not provided!");
        }
        if(error.length()>0){
            req.setAttribute("error",error);
            req.setAttribute("user", new User());
        }
        else {
            req.setAttribute("user", new User(name, email));
        }
        writer.write("hello"+name+" "+email);
        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
    
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
