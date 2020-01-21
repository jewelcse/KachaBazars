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
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
	<title>Home</title>
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
			<a class="active" href="index.jsp">Home</a> 
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
		<h2>Delivery Persons Information</h2>
	</div>
	
	<div class="container-box">
		<form action="" method="post">
			<table align="center">
			
			<%
	
			DBData db = new DBData();
			List<DeliveryPersonModel> deliveryPersonModels = db.getAllDeliveryPersons();
			request.setAttribute("deliveries", deliveryPersonModels);
			
			%>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>	
					<th>Address</th>
					<th>Phone</th>
					<th>Image</th>
					<th>Date of Birth</th>
					<th>Zone</th>
				</tr>
					
				<c:forEach items="${deliveries}" var="delivery">
					<tr>
						<td>${delivery.deliveryPersonId}</td>
						<td>${delivery.deliveryPersonFirstName}</td>
						<td>${delivery.deliveryPersonLastName}</td>	
						<td>${delivery.deliveryPersonAddress}</td>
						<td>${delivery.deliveryPersonPhone}</td>
						<td><img alt="" src="images/delivery/${delivery.deliveryPersonImageName}" height="50px" width="90px"> </td>
						<td>${delivery.deliveryPersonDOB}</td>
						<td>${delivery.deliveryZone.areaName }</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
</body>
</html>