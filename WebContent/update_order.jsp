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
					</div></li>
					
				<li class="options-div" id='subcategory'><a class="options"
					href="#subcategory">Subcategory</a>
					<div class="sub-menu">
						<a href="./subcategories?action=new">Add Subcategory</a> <a
							href="./subcategories?action=view">View Subcategory</a>
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
		<h2>Update Order</h2>
	</div>



		<div class="container">
		
		<form action="./orders?oid=${order.orderId}&action=edit" method="post">
			<div class="box">
			<table>
				<tr>
					<th colspan="2" rowsapn="2">
					<div class="table-header">
						<h3>Insert Order Information</h3>
						</div>
					</th>
				</tr>
				<tr>
					<td>care of Contact</td>
					<td><input type="text" name="careOfContact" value="${order.careOfContact}"></td>
				</tr>
				
				<tr>
						<td>Phone Number</td>
						<td><input type="text" name="deliveryPhone" value="${order.phoneNumber}"></td>
					</tr>
					<tr>
						<td>Quantity</td>
						<td><input type="text" name="deliveryQuantity" value="${order.orderQuantity}"></td>
					</tr>
					<tr>
						<td>Village</td>
						<td><input type="text" name="deliveryVillage" value="${order.orderVillage}"></td>
					</tr>
					<tr>
						<td>Upazilla</td>
						<td><input type="text" name="deliveryUpazilla" value="${order.orderUpazilla}"></td>
					</tr>
					<tr>
						<td>District</td>
						<td><input type="text" name="deliveryDistrict" value="${order.orderDistrict}"></td>
					</tr>
					<tr>
						<td>Street</td>
						<td><input type="text" name="deliveryStreet" value="${order.orderStreet}"></td>
					</tr>
					<tr>
						<td>Zip Code</td>
						<td><input type="text" name="deliveryZipCode" value="${order.orderZipCode}"></td>
					</tr>
					<tr>
						<td>Expected Delivery Date</td>
						<td><input type="date" name="deliveryDate" value="${order.expectedDeliveryDate}"></td>
					</tr>
					
					<input type="hidden" name="orderDate" value="${order.orderDate}">
					<input type="hidden" name="productModel" value="${order.productModel.productId}">
					<input type="hidden" name="customerModel" value="${order.customerModel.customerId}">
					<input type="hidden" name="deliveryPersonModel" value="${order.deliveryPersonModel.deliveryPersonId}">
					<input type="hidden" name="sellerModel" value="${order.sellerModel.sellerId}">
					<input type="hidden" name="orderStatus" value="${order.orderStatus}">
					<input type="hidden" name="areaModel" value="${order.areaModel.areaId}">

				<tr>
					<td>
						 <div class="submit-button">
							<input type="submit" value="update">
						</div>
					</td>
				</tr>
			</table>
			</div>

		</form>

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