package by.it_academy.jd2.HomeWork1.controllers;

import by.it_academy.jd2.HomeWork1.services.ProductService;
import by.it_academy.jd2.HomeWork1.services.api.IProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    private IProductService productService = ProductService.getInstance();
        private List<String[]> product = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute("product",productService.get());


        req.getRequestDispatcher("/mainForProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        product.add(req.getParameterValues("product"));


        PrintWriter writer = resp.getWriter();


        writer.write("<div>");
        writer.write("<p>Продукты:</p>");
        product.forEach(p ->
                writer.write("<p>" + String.join(",", p) + "</p>")
        );
        writer.write("</div>");


}
}
