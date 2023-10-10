package com.pm05.product_web_app.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.pm05.product_web_app.models.Product;
import com.pm05.product_web_app.models.db.DBCrud;
import com.pm05.product_web_app.models.db.MySQLConnector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get code from url
        String code = req.getParameter("code");
        //connect DB
        Connection conn = MySQLConnector.getMySQLConnection();
        //getProduct by code
        Product product =DBCrud.findProductbyCode(conn, code);
        //close
        MySQLConnector.closeConnection(conn);
        //place product 
        req.setAttribute("product", product);
        RequestDispatcher request = req.getRequestDispatcher("/WEB-INF/views/EditProductView.jsp");
        request.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //get code from form ???
       String code = req.getParameter("code");
       String name = req.getParameter("name");
       String priceString = req.getParameter("price");
       double price = Double.parseDouble(priceString);
       //convent
        Product product = new Product(code, name, price);

       // Connect
        Connection conn = MySQLConnector.getMySQLConnection();
        //update
        DBCrud.updateProduct(conn, product);
        //close
        MySQLConnector.closeConnection(conn);
        //redirect /product list
        resp.sendRedirect(req.getContextPath()+"/productList");
    }
    
}
