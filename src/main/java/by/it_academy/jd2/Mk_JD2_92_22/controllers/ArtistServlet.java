package by.it_academy.jd2.Mk_JD2_92_22.controllers;

import by.it_academy.jd2.Mk_JD2_92_22.core.entity.Artist;
import by.it_academy.jd2.Mk_JD2_92_22.services.ArtistService;
import by.it_academy.jd2.Mk_JD2_92_22.services.api.IArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artists")
public class ArtistServlet extends HttpServlet {
    private IArtistService service = ArtistService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        List<Artist> data = service.get();

        for (Artist item : data) {
            writer.write(item.toString());
        }
    }
}