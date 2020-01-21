<%@page import="model.ProductModel"%>
<%@page import="model.AreaModel"%>
<%@page import="model.OrdersModel"%>
<%@page import="model.DeliveryPersonModel"%>
<%@page import="model.SellerModel"%>
<%@page import="model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="javascript/jquery.js"></script>
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">
<title>Products</title>
</head>
<body>

	<div id="navbar">
	
	<div class="logo">
		KachaBazar.com
	</div>
		<div class="search">
			<input class="search-box" placeholder="Type to search"> <input
				type="submit" class="search-button" value="Search">
		</div>
		<div class="menu-items">
			<a class="active" href="javascript:void(0)">Home</a> 
			<a href="">Profile</a> 
			<a href="">Notification</a>
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
							href="Category.jsp">View Category</a>
							<a class="options"
								href="./subcategories?action=new">Add Sub-category</a>
					</div>
				</li>
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
		<h2>All Products</h2>
	</div>

	<%
		DBData db = new DBData();
		List<ProductModel> productModels = db.getAllProducts();
		request.setAttribute("products", productModels);
	%>

	<div class="container-box big">
		<table align="center">
			<tr class="table-radius">
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>ImageName</th>
				<th>Seller's Price</th>
				<th>Government Price</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productId }</td>
					<td>${product.productName}</td>
					<td>${product.productDescription}</td>
					<td><img src="images/products/${product.productImageName}"
						alt="product image" height="80px" width="100px"></td>
					<td>${product.productPrice}</td>
					<td>${product.governmentPrice}</td>

					<td><b><a class="blue-button table-radius"
						href="./products?action=update&pid=${product.productId}&cid=${product.productCategory.categoryId}">Update</a></b></td>
					<td><b><a class="red-button"
						href="./products?action=delete&pid=${product.productId}">Delete</a></b></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>


<script>
	window.onscroll = function() {
		myFunction()
	};

	var navbar = document.getElementById("navbar");
	var sticky = navbar.offsetTop;

	function myFunction() {
		if (window.pageYOffset >= sticky) {
			navbar.classList.add("sticky")
		} else {
			navbar.classList.remove("sticky");
		}
	}
</script>

</html>