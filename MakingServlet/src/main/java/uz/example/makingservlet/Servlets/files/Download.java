package uz.example.makingservlet.Servlets.files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "Download", urlPatterns = "/download")
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        String fileName = "test.txt";
        String filePath="C:\\Users\\thefa\\OneDrive\\Documents";
        resp.setHeader("Content-Disposition", "attachment; filename=\""
                +fileName+"\"");
        FileInputStream inputStream = new FileInputStream(filePath+fileName);
        int in;
        while ((in=inputStream.read())!=-1){
            writer.write(in);
        }
        inputStream.close();
        writer.close();
        req.getRequestDispatcher("download.jsp").forward(req, resp);
    }
}
