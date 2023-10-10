<!-- Trong tệp HTML (signup.jsp) -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Sign Up Form</title>
    <link rel="stylesheet" type="text/css" href="path/to/styles.css">
</head>

<body>
    <h1>Sign Up</h1>

    <div id="signup-container">
        <form action="login" method="post">
            <!--  -->
            <input type="text" name="firstName" placeholder="First Name" required><br> <br>
            <input type="text" name="lastName" placeholder="Last Name" required><br> <br>
            <input type="email" id="email" name="email" placeholder="Email" required><br><br>
            <input type="password" id="password" name="password" placeholder="Password" required><br><br>

            <label>Birthday:</label>
            <select name="month">
                <!-- Options của tháng -->
            </select>

            <select name="day">
                <!-- Options của ngày -->
            </select>

            <select name="year">
                <!-- Options của năm -->
            </select>

            <br><br>
            <label>Sex:</label>
            <input type="radio" id="female" name="sex" value="female">
            <label for="female">Female</label>
            <input type="radio" id="male" name="sex" value="male">
            <label for="male">Male</label><br><br>

            <input type="submit" value="Sign Up">
        </form>
    </div>
</body>

</html>
