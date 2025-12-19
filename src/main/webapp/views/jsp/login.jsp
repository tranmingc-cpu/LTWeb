<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="vi">
<head>
<meta charset="UTF-8">
<title>Đăng Nhập</title>
 <link rel="stylesheet" href="/FoodOrderWeb/views/Shared/login.css">
</head>
<body>
<div class="page">
<div class ="header-titel">
<h1> FOOD ORDER ONLINE </h1>
 </div>
<div class="login-box">
    <h2>Đăng nhập</h2>

    <form action="login" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required>
        <input type="password" name="password" placeholder="Mật khẩu" required>

        <button type="submit">Đăng nhập</button>
    </form>
</div>
</div>
</body>
</html>