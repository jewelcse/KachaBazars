<%@page import="java.util.List"%>
<%@page import="model.AreaModel"%>
<%@page import="dao.DBData"%>
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
	<title>Add Delivery Person</title>
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
		<h2>Add New Delivery Person</h2>
		</div>
	
	
	<div class="container">
		<form enctype="multipart/form-data" action="./deliveries" method="post">
		<div class="box">
			
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="deliveryPersonFirstName" required="required"></td>
				</tr>
				
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="deliveryPersonLastName" required="required"></td>
				</tr>
				
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="deliveryPersonPhone" required="required"></td>
				</tr>
				
				<tr>
					<td>Address</td>
					<td><input type="text" name="deliveryPersonAddress" required="required"></td>
				</tr>
				
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" name="deliveryPersonDOB" required="required"></td>
				</tr>
				
				<tr>
					<td>Image</td>
					<td><input type="file" name="sellerImage" required="required"></td>
				</tr>
				
				<tr>
					<td>NID</td>
					<td><input type="text" name="deliveryPersonNID" required="required"></td>
				</tr>
				
				<tr>
					<td>Gender</td>
					<td><select name="deliveryPersonGender" required="required">
					
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
						</select></td>
				</tr>
				
				<%
					DBData db = new DBData();
					List<AreaModel> areaModels = db.getAllAreas();
					request.setAttribute("areas", areaModels);
				
				%>
				
				<tr>
					<td>Zone</td>
					<td><select name="deliveryPersonZone">
						<c:forEach items="${areas }" var="area">
						<option value="${area.areaId}">${area.areaName}</option>
						</c:forEach>
						</select></td>
				</tr>
			</table>
			<c:if test="${action=='update'}">
				<input type="hidden" value="update" name="action">	
			</c:if>
						
			<c:if test="${action=='add'}">
				<input type="hidden" value="add" name="action">
			</c:if>
			
			<div class="submit-button" align="center">
				<input type="submit" value="Submit">
			</div>
		</div>
	</form>
	</div>
</body>
</html>