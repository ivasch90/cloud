package ru.gb.servlet;

import ru.gb.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "ProductHttpServlet", urlPatterns = "/product")
public class ProductHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", getProducts());
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);

    }

    private List<Product> getProducts() {
        return Arrays.asList(
                new Product(1, "Product_1", 1009),
                new Product(2, "Product_2", 1008),
                new Product(3, "Product_3", 1006),
                new Product(4, "Product_4", 1005),
                new Product(5, "Product_5", 1004),
                new Product(6, "Product_6", 1003),
                new Product(7, "Product_7", 10056),
                new Product(8, "Product_8", 1008),
                new Product(9, "Product_9", 10024),
                new Product(10, "Product_10", 100342)
        );

    }
}
