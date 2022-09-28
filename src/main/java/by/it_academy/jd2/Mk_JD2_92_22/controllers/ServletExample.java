package by.it_academy.jd2.Mk_JD2_92_22.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ServletExample", urlPatterns = "/hello_servlet_example")
public class ServletExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Enumeration<String> paramsName = req.getParameterNames();
        PrintWriter writer = resp.getWriter();

        while (paramsName.hasMoreElements()) {
            String paramName = paramsName.nextElement();

            if (paramName.toLowerCase().contains("name")) {
                writer.write("<p><span style='color: blue;'>Hello " + req.getParameter(paramName) + "</span></p>");

            }
        }

    }
}
