package by.it_academy.jd2.Mk_JD2_92_22.controllers;

import by.it_academy.jd2.Mk_JD2_92_22.core.entity.Genre;
import by.it_academy.jd2.Mk_JD2_92_22.services.GenreService;
import by.it_academy.jd2.Mk_JD2_92_22.services.api.IGenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GenreServlet", urlPatterns = "/genres")
public class GenreServlet extends HttpServlet {
    private IGenreService service = GenreService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        List<Genre> data = service.get();

        for (Genre item : data) {
            writer.write(item.toString());
        }
    }
}