<%@page import="model.DeliveryPersonModel"%>
<%@page import="model.SellerModel"%>
<%@page import="model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
	<div>
		<h2>List of orders</h2>
		<table border="1px solid black">
			<tr>
				<td>Order ID</td>
				<td>Customer ID</td>
				<td>Product ID</td>
				<td>Seller ID</td>
				<td>Delivery Person ID</td>
				<td>Order Area</td>
				<td>Order Status</td>
				<td>Ordering Time</td>
			</tr>
		</table>
	</div>
</body>
</html>