<%@page import="model.OrdersModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demands</title>

<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">

<script type="text/javascript">
function searchdemand()
{
	var test=document.getElementById("dates").value;
	//alert(test);
	document.location.href = "./demands?date="+test+"&action=demand";
}
</script>
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
			<h2>Demands</h2>
		</div>
	
	
	<div class="container-box">
		Please Select Date   <input class="calender" type="date" id="dates"> <input type="button"
			name="dateSearch" onclick="searchdemand()" value="Search">

		<table>
			<tr>
				<th><h4>Expected Date</h4></th>
				<th><h4>Image</h4></th>
				<th><h4>Product</h4></th>
				<th><h4>Quantity/<h4></th>
				<th><h4>Action</h4></th>
			</tr>

			<c:forEach items="${products}" var="product">
				<tr>
					<td><h4>${date}</h4></td>
					<td><img alt="" src="images/products/${product.productImageName }" width="100px" height="120px"></td>
					<td><h4>${product.productName}</h4></td>
					<td><h4>${product.productQuantity}</h4></td>
					<td><a class="confirm-button small" href="./bids?pid=${product.productId}&quantity=${product.productQuantity}&date=${date}&action=bid">
							Bid Now</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>