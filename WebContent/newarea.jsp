<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<link rel="stylesheet" href="./css/menubar.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
	<title>Add New Area</title>
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
			</ul>
		</div>
	</div>
	
	
	<div class="header">
		<h2>Add New Area</h2>
		</div>
	
	
	<div class="container">
		<form action="/ecommerce/areas" method="post">
			<div class="box">
				<table align="center">
					<tr>
						<th colspan="2" rowsapn="2">
							<div class="table-header">
								<h3>Insert Area Information</h3>
							</div>
						</th>
					</tr>
			
			<tr>
				<td class="name-label">Area Name</td>
				<td><input type="text" placeholder="Enter Area Name" name="areaName"  value="${area.areaName}" required="required"></td>
			</tr>
			
			<tr>
				<td class="name-label">Description</td>
				<td><input type="text" placeholder="Enter Area Description" name="areaDescription" value="${area.areaDescription}" required="required"></td>
			</tr>
			
			
			
			<tr>
				<td>
				
				<c:if test="${action=='update'}">
				<input type="hidden" value="update" name="action">	
				</c:if>
				
				<c:if test="${action=='new'}">
				<input type="hidden" value="new" name="action">
				</c:if>
				
				<input type="hidden" value="${categories.categoryId}" name="areaId">
				</td>
			</tr>
		</table>
		<div class="submit-button" align="center">
			<input type="submit" value="Submit">
		</div>
		</div>
	</form>
	</div>
</body>
</html>