package uz.example.makingservlet.Servlets.Internationalization;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet( urlPatterns = "/getCurrentLocationInformation")
public class GetLocationServlet extends HttpServlet {
    public GetLocationServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale locale = req.getLocale();
//        String localeLanguage = locale.getLanguage();
//        String localeCountry = locale.getCountry();
//        String localeISO3Country =locale.getISO3Country();
//        String localeDisplayLanguage = locale.getDisplayLanguage();

        String date = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, locale).format(new Date());
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        resp.setHeader("Content-Language", "es");
       // writer.write(localeLanguage+ " " + localeCountry+" " +localeISO3Country+ " " + localeDisplayLanguage);
       writer.write(date+" ");

        // Get the current Locale information
        Locale currentLocale = req.getLocale( );
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(currentLocale);
        String formattedCurrency = numberFormat.format(100000);

        writer.write(formattedCurrency);
    }
}
