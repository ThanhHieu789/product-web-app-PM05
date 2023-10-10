package com.pm05.product_web_app.models.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pm05.product_web_app.models.Product;

public class DBCrud {
    public static List<Product> getAllProduct(Connection conn){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //Excute query
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String code = rs.getString("code");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Product product = new Product(code, name, price);
                productList.add(product);
            }
        } catch (Exception e) {
        }finally{//Sau cùng chắc chắn sẽ thực thi đóng ps, rs lại dù try hay catch xảy ra
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
    public static void insertProduct(Connection conn,Product product){
        String sqlString = "insert into product (code,name,price) values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlString);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Product findProductbyCode(Connection conn,String code){
        Product product =null;
        String sqlQuery = "Select code,name,price FROM product WHERE code=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sqlQuery);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                product = new Product(code, name, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public static void updateProduct(Connection conn, Product product){
        String sql ="update product set name =?,price=? where code=?;";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
             ps.setDouble(2, product.getPrice());
              ps.setString(3, product.getCode());
            
              ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }


    }
    public static void deleteProduct(Connection conn, String code){
        String sql="delete from product where code=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
