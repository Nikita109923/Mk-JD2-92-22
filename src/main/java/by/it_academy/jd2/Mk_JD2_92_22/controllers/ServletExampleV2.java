package by.it_academy.jd2.Mk_JD2_92_22.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ServletExampleV2", urlPatterns = "/hello_servlet_example_v2")
public class ServletExampleV2 extends HttpServlet {

    private final String NAME_PARAMETER_HEADER = "ARRAY_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        Enumeration<String> paramsName  = req.getParameterNames();
        PrintWriter writer = resp.getWriter();

        String contains = req.getHeader(NAME_PARAMETER_HEADER);

        while (paramsName.hasMoreElements()){
            String paramName = paramsName.nextElement();

            if(paramName.toLowerCase().contains(contains)){
                writer.write("<p><span style='color: blue;'>Hello " + req.getParameter(paramName) + "</span></p>");

            }
        }

    }
}
