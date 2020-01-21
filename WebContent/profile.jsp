<%@page import="java.util.Iterator"%>
<%@page import="model.CartDetailsModel"%>
<%@page import="model.UnionModel"%>
<%@page import="model.UpazillaModel"%>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="navbar.jsp" />
<jsp:include page="sidenavbar.jsp" />

<%
	if (session.getAttribute("cid") != null) {
		String login = (String) session.getAttribute("message");
		String name = (String) session.getAttribute("name");

		DBData db = new DBData();

		int cid = Integer.parseInt(session.getAttribute("cid").toString());

		CustomerModel customerModel = db.getCustomerById(cid);

		request.setAttribute("customer", customerModel);
		request.setAttribute("login", login);
		request.setAttribute("name", name);
	}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" type="text/css" href="css/profile.css">
<title>Homepage - KachaBazar</title>

</head>
<body>

	<div class="page-info">
		<h2>
			<u>Profile</u>
		</h2>
	</div>


	<div class="info-holder">
		<div class="title">
			<h2>Basic Information</h2>
		</div>
		<div class="image-holder">
			<img src="images/customers/${customer.customerImageName }">
		</div>
		<div class="basic-info">
			<table class="basic-info-table">
				<tr>
					<th colspan="2">${customer.customerFirstName } ${customer.customerLastName }</th>
				</tr>

				<tr>
					<td class="address">Address :</td>
					<td>${customer.customerStreet} , ${customer.customerVillage}<br> ${customer.unionModel.unionBanglaName}, ${customer.upazillaModel.upazillaBangaName}, ${customer.districtModel.districtBanglaName}, ${customer.divisionmodel.divisionBanglaName}</td>
				</tr>

				<tr>
					<td>Phone No :</td>
					<td>+880 ${customer.customerPhone}</td>
				</tr>

				<tr>
					<td>Date Of Birth :</td>
					<td> ${customer.customerDOB}</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="purchase-info">
		<div class="title">
			<h2>Order History</h2>
		</div>
		<div class="order">
			<h3>
				<b>Orders</b>
			</h3>
		</div>
		<div class="current-order">
			<table class="purchase-info-table">
			<caption>From Kacha Bazar</caption>
				<tr>
					<th class="product-name">Product</th>
					<th class="product-quantity">Quantity</th>
					<th class="seller">Buying from</th>
					<th class="seller">Order Status</th>
					<th class="price">Price per piece</th>
				</tr>
			
			<c:forEach items="${orders }" var="order">
				<tr>
					<td>${order.productModel.productName}</td>

					<td>${order.orderQuantity} ${order.productModel.productUnit.unit}</td>

					<td>Kacha Bazar </td>
					
					<td>${order.orderStatus}</td>

					<td>${order.productModel.productPrice }/=</td>
				</tr>
			</c:forEach>
				
				</table>

				
		</div>

		

		<div class="delivered-order">
			<table class="purchase-info-table">
			<caption>From Seller</caption>
				<tr>
					<th class="product-name">Product</th>
					<th class="product-quantity">Quantity</th>
					<th class="seller">Buying from</th>
					<th class="seller">Order Status</th>
					<th class="price">Price</th>
				</tr>

				<c:forEach items="${ordersseller }" var="ordersseller">
				<tr>
					<td>${ordersseller.sellersProduct.productName}</td>

					<td>${ordersseller.orderQuantity} ${ordersseller.sellersProduct.unitModel.unit}</td>

					<td>${ordersseller.sellerModel.sellerFirstName}</td>
					
					<td>${ordersseller.orderStatus}</td>

					<td>${ordersseller.sellersProduct.productPrice }/=</td>
				</tr>
			</c:forEach>

				
				</table>
		</div>
	</div>

</body>
</html>