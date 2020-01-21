<%@page import="model.OrderSellerProductModel"%>
<%@page import="controller.OrderFromSeller"%>
<%@page import="model.AreaModel"%>
<%@page import="model.OrdersModel"%>
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
<!-- 
<script src="javascript/jquery.js"></script>
<script>
	$(document).ready(function() {
		$('#dd1').change(function() {
			fillOptions('dd2', this);
		});
		$('#dd2').change(function() {
			fillOptions('dd3', this);
		});
	});
	function fillOptions(ddId, callingElement) {
		var dd = $('#' + ddId);
		$.getJSON(
				'dropdown?dd=' + ddId + '&val=' + $(callingElement).val(),
				function(opts) {
					$('>option', dd).remove(); // Clean old options first.
					if (opts) {
						$.each(opts, function(key, value) {
							dd.append($('<option/>').val(key).text(value));
						});
					} else {
						dd.append($('<option/>').text("Please select parent"));
					}
				});
	}
</script>

 -->


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="javascript/jquery.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
<title>Admin</title>
</head>
<body>

	<%
		session = request.getSession();
		if (session.getAttribute("adminlogin") == "false" || session.getAttribute("adminlogin") == null) {
			//	request.getRequestDispatcher("admin-login.jsp");
			System.out.println(session.getAttribute("adminlogin"));
			response.sendRedirect("admin-login.jsp");

		} else {
	%>


	<div id="navbar">

		<div class="logo">
			KachaBazar.com <a href="./Homepage.jsp">View Page</a>
		</div>
		<div class="search">
			<input class="search-box" placeholder="Type to search"> <input
				type="submit" class="search-button" value="Search">
		</div>
		<div class="menu-items">
			<a class="active" href="index.jsp">Home</a> <a
				href="./admin?action=viewprofile">Profile</a> <a
				href="./admin?action=adminlogout">Logout</a>
		</div>
	</div>



	<div class="wrapper-box">
		<div class="side-bar">
			<h2>Menu</h2>
			<ul>
				<li class="options-div"><a class="options"
					href="./orders?action=view">Dashboard</a></li>
				<li class="options-div" id="product"><a class="options"
					href="#product">Products</a>
					<div class="sub-menu">
						<a href="./products?action=new">Add Products</a> <a
							href="./products?action=view">View Products</a>
					</div></li>
				<li class="options-div" id='category'><a class="options"
					href="#category">Category</a>
					<div class="sub-menu">
						<a href="./categories?action=new">Add Category</a> <a
							href="Category.jsp">View Category</a> <a class="options"
							href="./subcategories?action=new">Add Sub-category</a>
					</div></li>
				<li class="options-div" id="area"><a class="options"
					href="#area">Areas</a>
					<div class="sub-menu">
						<a href="./areas?action=new">Add Areas</a> <a
							href="./areas?action=view">View Areas</a>
					</div></li>
				<li class="options-div" id="sellers"><a class="options"
					href="#sellers">Sellers</a>
					<div class="sub-menu">
						<a href="./sellers?action=new">Add Sellers</a> <a
							href="./sellers?action=view">View Sellers</a>
					</div></li>
				<li class="options-div"><a class="options"
					href="./customers?action=view">Customers</a></li>
				<li class="options-div" id="deliverer"><a class="options"
					href="#deliverer">Delivery Persons</a>
					<div class="sub-menu">
						<a href="./deliveries?action=add">Add Deliverers</a> <a
							href="./deliveries?action=view">View Deliverers</a>
					</div></li>
				<li class="options-div"><a class="options"
					href="./demands?action=view">Explore Demands</a></li>
			</ul>
		</div>
	</div>


	<div class="header" align="center">
		<h2>Orders From Inventory</h2>
	</div>

	<%
		DBData db = new DBData();
			List<OrdersModel> ordersModels = db.getAllOrders();
			request.setAttribute("orders", ordersModels);
	%>


	<form action="./orders" method="get">
		<div class="container-box">
			<table align="center">
				<tr>
					<th>Order ID</th>
					<th>Care of</th>
					<th>Order Date</th>
					<th>Product</th>
					<th>Customer</th>
					<th>Delivery Person</th>
					<th>Order Status</th>
					<th>Order Expected Date</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td>${order.orderId }</td>
						<td>${order.careOfContact}</td>
						<td>${order.orderDate}</td>
						<td>${order.productModel.productName}</td>
						<td>${order.customerModel.customerFirstName}</td>
						<td>${order.deliveryPersonModel.deliveryPersonFirstName}</td>
						<td>${order.orderStatus}</td>
						<td>${order.expectedDeliveryDate}</td>
						<td><a
							href="./orderoperations?action=vieworder&oid=${order.orderId}">View</a>
						</td>
					</tr>
				</c:forEach>
			</table>
	</form>
	</div>
	<div align="center">
		<a href="./customers?action=login"> Customer Login</a> <a
			href="./sellers?action=login"> Seller Login</a> <a
			href="./deliveries?action=view"> Delivery view</a>
	</div>
	<hr style="size: 10px">

	<%
		List<OrderSellerProductModel> orderSellerProductModels = db.getAllOrderFromSeller();
			request.setAttribute("ordersellerproducts", orderSellerProductModels);
	%>



	<form action="./orders" method="get">
		<div class="container-box">
			<h2>Orders From Seller</h2>
			<table>
				<tr>
					<th>Order ID</th>
					<th>Care of</th>
					<th>Order Date</th>
					<th>Product</th>
					<th>Customer</th>
					<th>Delivery Person</th>
					<th>Order Status</th>
					<th>Order Expected Date</th>
					<th>Seller</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${ordersellerproducts}" var="order">
					<tr>
						<td>${order.orderId }</td>
						<td>${order.careOfContact}</td>
						<td>${order.orderDate}</td>
						<td>${order.sellersProduct.productName}</td>
						<td>${order.customerModel.customerFirstName}</td>
						<td>${order.deliveryPersonModel.deliveryPersonFirstName}</td>
						<td>${order.orderStatus}</td>
						<td>${order.expectedDeliveryDate}</td>
						<td>${order.sellerModel.sellerFirstName}</td>
						<td><a
							href="./orderoperations?action=viewsellerorder&soid=${order.orderId}">View</a>
						</td>
					</tr>
				</c:forEach>
			</table>
	</form>

	<%
		}
	%>

</body>
</html>