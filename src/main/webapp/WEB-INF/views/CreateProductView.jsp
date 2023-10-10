<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!--JSTL-->

<!DOCTYPE html>

<html>
    <head>
        <title>Create Product</title>
    </head>
    <body>
        <h2>Create Product Page</h2>
        <form action="createProduct" method="post">
            <table border="1">
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code"required></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"required></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="number" name="price"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                        <a href="productList">Cancel</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>