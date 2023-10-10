package com.pm05.product_web_app.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.pm05.product_web_app.models.Product;
import com.pm05.product_web_app.models.db.DBCrud;
import com.pm05.product_web_app.models.db.MySQLConnector;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/productList")
public class ProductListServletController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        List<Product> productList = null;
        //ket noi csdl
        conn = MySQLConnector.getMySQLConnection();
        //lay danh sach san pham
        productList = DBCrud.getAllProduct(conn);
        //close connection
        MySQLConnector.closeConnection(conn);
        //dat danh sach sp vao request
        req.setAttribute("plist", productList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/ProductListView.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}
