package by.it_academy.jd2.HomeWork1.controllers;


import by.it_academy.jd2.HomeWork1.core.entity.Product;
import by.it_academy.jd2.HomeWork1.services.ProductService;
import by.it_academy.jd2.HomeWork1.services.api.IProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")

public class ProductServlet  extends HttpServlet {
    private IProductService service = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        List<Product> data = service.get();

        for (Product item : data) {
            writer.write(item.toString());
        }
    }
}
