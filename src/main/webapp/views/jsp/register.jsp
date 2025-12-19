<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="/FoodOrderWeb/views/Shared/register.css">
</head>
<body>
<div class ="header-titel">
<h1> FOOD ORDER ONLINE </h1>
 </div>
	<div class="register-container">
		<h2>Đăng ký tài khoản</h2>
		<c:if test="${not empty error}">
			<p class="error">${eror}</p>
		</c:if>
		<c:if test="${not empty success }">
			<p class="success">${success}</p>
		</c:if>
		<form action="register" method="post">
			<input type="text" name="username" placeholder="Tên đăng nhập"
				value="${param.username}" required> <input type="email"
				name="email" placeholder="Email" value="${param.email}" required>

			<input type="password" name="password" placeholder="Mật khẩu"
				required> <input type="number" name="number"
				placeholder="Số điện thoại" value="${param.number}" required>

			<input type="text" name="address" placeholder="Địa chỉ"
				value="${param.address}">

			<button type="submit">Đăng ký</button>
		</form>

		<p>
			Đã có tài khoản? <a href="login.jsp">Đăng nhập</a>
		</p>

	</div>
</body>
</html>