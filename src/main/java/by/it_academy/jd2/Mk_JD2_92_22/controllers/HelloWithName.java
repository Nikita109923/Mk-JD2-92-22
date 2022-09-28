package by.it_academy.jd2.Mk_JD2_92_22.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "HelloWithName", urlPatterns = "/hello_with_name")

public class HelloWithName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if (firstName == null && lastName == null) {
            if (req.getCookies() == null) {
                //тут нужно выбросить ошибку, так как куков нет.

            } else {
                for (Cookie value : req.getCookies()) {
                    if (value.getName().equals("firstName")) {
                        firstName = value.getValue();

                    } else if (value.getName().equals("lastName")) {
                        lastName = value.getValue();

                    }
                }
                if (firstName == null && lastName == null) {
                    //тут нужно выбросить ошибку, так как таких куков нет.
                }
            }
        } else {
            Cookie myCookie = new Cookie("firstName", firstName);
            Cookie myCookie2 = new Cookie("lastName", lastName);

            myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(myCookie);
            myCookie2.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(myCookie2);

        }

        PrintWriter writer = resp.getWriter();
        writer.write("<P> Hello " + firstName + " " + lastName + "</p>");


    }
}
