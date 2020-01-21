<%@page import="model.OrderSellerProductModel"%>
<%@page import="dao.DeliveryDao"%>
<%@page import="model.OrdersModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="model.SellersProduct"%>
<%@page import="dao.AreaDao"%>
<%@page import="model.DistrictModel"%>
<%@page import="model.DivisionModel"%>
<%@page import="model.AreaModel"%>
<%@page import="model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://code.ionicframework.com/1.0.0/css/ionic.css" />
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.ionicframework.com/1.0.0/js/ionic.bundle.js"></script>
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home page - Delivery Man</title>



</head>
<body>
	
	
	
	
	<%
		DeliveryDao dd = new DeliveryDao();
		List<OrdersModel> ordersModel = new ArrayList<OrdersModel>();
		List<OrderSellerProductModel> orderSellerProductModels = new ArrayList<OrderSellerProductModel>();
		
		session = request.getSession();
		
		if(session.getAttribute("did") == null){
			request.getRequestDispatcher("devilery-person-login").forward(request, response);
		}
		else{
			
			int did = Integer.parseInt(session.getAttribute("did").toString());
			
			ordersModel = dd.getOrdersByDeliveryPersonId(did);			
			orderSellerProductModels = dd.getSellerOrdersByDeliveryPersonId(did);
			
			request.setAttribute("orderlist", ordersModel);
			request.setAttribute("ordersellerlist", orderSellerProductModels);
		}
		
		
	%>

	
	<div align="center">
	

	
		<ul>
					<li><a href="delivery-person-homepage.jsp" data-icon="edit">New Orders</a></li>
					<li><a href="#" data-icon="bullets">All Orders</a></li>
					<li><a href="#" data-icon="clock">Processing</a></li>
					<li><a href="#" data-icon="check">Completed</a></li>
					<li><a href="#" data-icon="delete">Cancelled</a></li>
					<li><a href="#" data-icon="minus">Logout</a></li>
				</ul>
	
	
	<h1>New Orders</h1>
	
	
	<form style="max-width: 80%">
		<input data-type="search" id="searchForTable-1" style="max-width: 80%"/>
	</form>
	<table data-role="table" id="table-2" style="max-width: 80%;" data-mode="columntoggle" data-filter="true" data-input="#searchForTable-1" class="ui-body-a ui-responsive ">
		<thead>
			<tr class="ui-bar-a">
				<th>Order Id</th>
				<th data-priority="1">Order Date</th>
				<th data-priority="2">Product</th>
				<th data-priority="3">Expected Date</th>
				<th data-priority="4">Status</th>
				<th data-priority="5">Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${orderlist }" var="order">
			<tr>
				<td>${order.orderId}</td>
			<td>${order.orderDate }</td>
			<td>${order.productModel.productName }</td>
			<td>${order.expectedDeliveryDate}</td>
			<td>${order.orderStatus}</td>
			<td><a href="./doperations?action=inventoryorderview&oid=${order.orderId}"> Details </a></td>
			</tr>
			
		</c:forEach>
		
		</tbody>
	</table>
	

	
	<hr>
	
	<h1>New Seller Orders</h1>
	
	
	
	<form style="max-width: 80%">
		<input data-type="search" id="searchForTable-2" style="max-width: 80%"/>
	</form>
	<table data-role="table" id="table-1" data-mode="columntoggle" data-filter="true" data-input="#searchForTable-2" class="ui-body-a ui-responsive" style="max-width: 80%">
		<thead>
			<tr class="ui-bar-a">
				<th>Order Id</th>
				<th data-priority="1">Order Date</th>
				<th data-priority="2">Product</th>
				<th data-priority="3">Seller</th>
				<th data-priority="4">Expected Date</th>
				<th data-priority="5">Status</th>
				<th data-priority="6">Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ordersellerlist}" var="order">
			<tr>
			<td>${order.orderId}</td>
			<td>${order.orderDate }</td>
			<td>${order.sellersProduct.productName }</td>
			<td>${order.sellerModel.sellerFirstName }</td>
			<td>${order.expectedDeliveryDate}</td>
			<td>${order.orderStatus}</td>
			<td><a href="./doperations?action=viewsellerorder&soid=${order.orderId}"> Details </a></td>
			</tr>
		
		</c:forEach>
		</tbody>
	</table>
	
	</div>
	
</body>
</html>