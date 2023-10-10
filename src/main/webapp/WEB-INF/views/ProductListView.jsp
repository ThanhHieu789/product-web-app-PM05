<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>

    <html>

    <head>
        <title>
            Porduct List Page
        </title>
    </head>

    <body>

        <!--header-->
        <jsp:include page="Header.jsp"></jsp:include>
        <!--menu-->
        <jsp:include page="Menu.jsp"></jsp:include>
        <h3>Prodcut List Page</h3>

        <table border="1" cellpadding = "5" cellspacing = "1">
            <!--title-->
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <!--body-->
            <c:forEach items = "${plist}" var="product">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <!--dung the a goi servlet thi se den doGet-->
                    <td><a href="editProduct?code=${product.code}">Edit</a></td> 
                    <td><a href="deleteProduct?code=${product.code}" onclick="return confirm('Ban co chac muon xoa san pham nay khong ?')">Delete</a></td>
                  
                </tr>

            </c:forEach>
            

        </table>
        <a href="createProduct">Create a Product</a>

        <!--footer-->
        <jsp:include page="Footer.jsp"></jsp:include>

    </body>

    </html>