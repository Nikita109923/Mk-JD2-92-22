package by.it_academy.jd2.Mk_JD2_92_22.controllers;


import by.it_academy.jd2.Mk_JD2_92_22.services.ArtistService;
import by.it_academy.jd2.Mk_JD2_92_22.services.GenreService;
import by.it_academy.jd2.Mk_JD2_92_22.services.api.IArtistService;
import by.it_academy.jd2.Mk_JD2_92_22.services.api.IGenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VoteServlet", urlPatterns = "/www")
public class VoteServlet extends HttpServlet {

    private IArtistService artistService = ArtistService.getInstance();
    private IGenreService genreService = GenreService.getInstance();

    private List<String> artist = new ArrayList<>();
    private List<String[]> genre = new ArrayList<>();
    private List<String> about = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("artists", artistService.get());
        req.setAttribute("genres", genreService.get());

        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        artist.add(req.getParameter("artist"));
        genre.add(req.getParameterValues("genre"));
        about.add(req.getParameter("about"));


        PrintWriter writer = resp.getWriter();


        writer.write("<div>");
        writer.write("<p>Исполнители:</p>");
        artist.forEach(a ->
                writer.write("<p>" + a + "</p>")
        );
        writer.write("</div>");

        writer.write("<div>");
        writer.write("<p>Жанры:</p>");
        genre.forEach(g ->
                writer.write("<p>" + String.join(",", g) + "</p>")
        );
        writer.write("</div>");

        writer.write("<div>");
        writer.write("<p>О себе:</p>");
        about.forEach(a ->
                writer.write("<p>" + a + "</p>")
        );
        writer.write("</div>");
    }
}