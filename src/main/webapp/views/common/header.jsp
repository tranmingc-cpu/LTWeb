<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   
    <link rel="stylesheet" href="/FoodOrderWeb/views/Shared/header.css">
</head>
<body>

<!-- TOP BAR -->
<div class="top-bar">
    <div class="top-bar-left">
        <a href="#">Kênh Người Bán</a>
        <span>|</span>
        <a href="#">Kết Nối</a>
    </div>

    <div class="top-bar-right">
        <a href="#">Thông Báo</a>
        <a href="#">Hỗ Trợ</a>
        <a href="#">Đăng Nhập</a>
    </div>
</div>


<div class="header">

    <!-- LOGO -->
    <a class="logo" href="/FoodOrderWeb/home">
        <div class="food-logo spoon">
            <div class="spoon-head"></div>
            <div class="spoon-handle"></div>
        </div>
        <span>FOOD ONLINE</span>
    </a>

    <!-- SEARCH -->
    <form class="search-box" action="/FoodOrderWeb/search" method="get">
        <input type="text" name="q" placeholder="Tìm đồ ăn, đồ uống">
        <button type="submit">🔍</button>
    </form>

    <!-- RIGHT ICONS -->
    <div class="header-icons">

        <!-- CART -->
        <a href="/FoodOrderWeb/cart" class="header-cart">
            🛒
            <span class="cart-count">
                ${sessionScope.cartSize != null ? sessionScope.cartSize : 0}
            </span>
        </a>

        <!-- USER -->
        <div class="header-user">
            <img src="/FoodOrderWeb/images/user.png" alt="User">
        </div>

    </div>
</div>

</body>
</html>