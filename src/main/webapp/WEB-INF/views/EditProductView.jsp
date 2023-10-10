
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

</head>

<body>
    <h1>Edit Product Page</h1>
    <c:if test="${not empty product}">
        <form action="editProduct" method="post">
            <input hidden name="code" value="${product.code}">
            <table border="1">
                <!-- <tr>
                    <td>Code</td>
                    <td><input type="text" name="code" value="${product.code}"></td>
                </tr> -->
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${product.name}"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="${product.price}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                        <a href="productList">Cancel</a>
                    </td>
                </tr>
            </table>

        </form>

    </c:if>
</body>

</html>