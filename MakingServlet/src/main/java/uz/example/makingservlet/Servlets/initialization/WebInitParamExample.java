package uz.example.makingservlet.Servlets.initialization;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "WebInitParam", urlPatterns = "/web", initParams = {@WebInitParam(name = "copyrightYear", value = "2019")})
public class WebInitParamExample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String copyrightYear = getServletConfig().getInitParameter("copyrightYear");
        if (copyrightYear != null){
            System.out.println("Copyright year: " + copyrightYear);
        }

    }
}
