<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đơn hàng</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/Shared/order-detail.css">
</head>
<body>

<div class="order-container">

    <!-- ===== HEADER ===== -->
    <div class="order-header">
        <div class="shop-name">FOOD ONLINE</div>
        <div class="order-status">${order.status}</div>
    </div>

    <!-- ===== PRODUCT LIST ===== -->
    <c:forEach items="${order.items}" var="item">
        <div class="product-row">
            <img src="${item.image}" class="product-img">

            <div class="product-info">
                <h4>${item.name}</h4>
                <p>Phân loại: ${item.category}</p>
                <p>Số lượng: x${item.quantity}</p>
            </div>

            <div class="product-price">
                <fmt:formatNumber value="${item.price}" type="number"/> ₫
            </div>
        </div>
    </c:forEach>

    <!-- ===== SHIPPING ===== -->
    <div class="order-box">
        <h4>Thông tin vận chuyển</h4>
        <p>Đơn vị vận chuyển: ${order.shippingUnit}</p>
        <p>Ngày nhận dự kiến: ${order.deliveryDate}</p>
    </div>

    <!-- ===== RECEIVER ===== -->
    <div class="order-box">
        <h4>Thông tin người nhận</h4>
        <p>${order.receiverName}</p>
        <p>${order.phone}</p>
        <p>${order.address}</p>
    </div>

    <!-- ===== TOTAL ===== -->
    <div class="order-total">
        <span>Tổng tiền:</span>
        <strong>
            <fmt:formatNumber value="${order.total}" type="number"/> ₫
        </strong>
    </div>

    <!-- ===== ACTION ===== -->
    <div class="order-action">
        <button class="btn-outline">Mua lại</button>
        <button class="btn-danger">Hủy đơn</button>
    </div>

</div>

</body>
</html>
    