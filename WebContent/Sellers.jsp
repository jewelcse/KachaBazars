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
		<h2>Sellers</h2>
		</div>
		
		
		
		<div class="container-box">
		<form action="">
			<table>
			
			<%
	
			DBData db = new DBData();
			List<SellerModel> sellerModels = db.getAllSellers();
			request.setAttribute("sellers", sellerModels);
			
			%>
				<tr>
					<th>Sellers ID</td>
					<th>Sellers First Name</th>
					<th>Sellers Last Name</th>	
					<th>Sellers Division</th>
					<th>Sellers District</th>
					<th>Sellers Upazilla</th>
					<th>Sellers Union</th>
					<th>Sellers Phone</th>
					<th>Sellers Image</th>
					<th>Sellers DOB</th>
				</tr>
					
				<c:forEach items="${sellers}" var="seller">
					<tr>
						<td>${seller.sellerId}</td>
						<td>${seller.sellerFirstName}</td>
						<td>${seller.sellerLastName}</td>	
						<td>${seller.divisionmodel.divisionBanglaName}</td>
						<td>${seller.districtModel.districtBanglaName}</td>
						<td>${seller.upazillaModel.upazillaBangaName}</td>
						<td>${seller.unionModel.unionBanglaName}</td>
						<td>${seller.sellerPhone}</td>
						<td><img alt="" src="images/sellers/${seller.sellerImageName}" height="50px" width="90px"> </td>
						<td>${seller.sellerDOB}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
</body>
</html>