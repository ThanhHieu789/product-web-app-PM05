package com.pm05.product_web_app.controllers;

import java.io.IOException;
import java.sql.Connection;


import com.pm05.product_web_app.models.db.DBCrud;
import com.pm05.product_web_app.models.db.MySQLConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //get code from jsp
        String code = req.getParameter("code");
        //pass code vao db
        Connection conn = MySQLConnector.getMySQLConnection();

        //delete
        DBCrud.deleteProduct(conn, code);
        //redirect
        resp.sendRedirect(req.getContextPath()+"/productList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}
