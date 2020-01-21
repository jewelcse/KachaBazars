<%@page import="model.CartModel"%>
<%@page import="model.CartDetailsModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.ProductModel"%>
<%@page import="model.SubcategoryModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="navbar.jsp" />
<jsp:include page="sidenavbar.jsp" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/cart.css">
<title>Your Cart</title>
<script src="javascript/jquery.js"></script>

</head>
<body>
	<%
		DBData db = new DBData();

		if (session.getAttribute("cid") != null) {
			String login = (String) session.getAttribute("message");
			String name = (String) session.getAttribute("name");
			int cid = Integer.parseInt(session.getAttribute("cid").toString());

			CartModel cartModel = new CartModel();
			cartModel = db.getCartByCustomerId(cid);

			int cartId = cartModel.getCartId();

			List<CartDetailsModel> cartDetailsModels = db.getCartDetailsByCartId(cartId);
			request.setAttribute("cartId", cartId);
			request.setAttribute("cart", cartDetailsModels);
			request.setAttribute("cid", cid);

			request.setAttribute("login", login);
			request.setAttribute("name", name);
		}
	%>


	<div class="page-info">
		<h2>
			<u>Cart Details</u>
		</h2>
	</div>


	<div class="cart-holder">
		<table class="cart-table">
			<tr>
				<th class="subtotal-header"> No.</th>
				<th class="name-header" colspan="2">Product</th>
				<th class="quantity-header">Quantity</th>
				<th class="subtotal-header">Subtotal</th>
				
			</tr>


			<c:set var="count" value="${0}" scope="page" />
			<c:set var="subTotal" value="${0}" scope="page" />
			<c:set var="Total" value="${0}" scope="page" />
			<c:forEach items="${cart}" var="option">

				<tr>
				<c:set var="count" value="${count+1}" scope="page" />
					<c:set var="subTotal"
						value="${option.cartProductQuantity * option.productModel.productPrice}"
						scope="page" />
					<c:set var="Total"
						value="${(Total + option.cartProductQuantity * option.productModel.productPrice)}"
						scope="page" />
					
					<td>${count }</td>
						
					<td class="name">${option.productModel.productName}</td>
					<td class="image"><img src="images/products/${option.productModel.productImageName}" alt="Image"></td>
					<td class="quantity">${option.cartProductQuantity}</td>
					<td class="subtotal">${subTotal}/=</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="3" class="total">Total</td>
				<td colspan="2" class="total-amount">${Total} /=</td>
			</tr>
			<tr>
				<td colspan="3" class="name"><br></td>
				<td colspan="2" class="name"><br></td>
			</tr>
			<tr>
			
			<c:if test="${count == 0}">
			
				<td colspan="5">
				No product in your cart. Lets buy some from the 
				<a  href="Homepage.jsp"> SHOP </a></td>
				
			</c:if>
			
			<c:if test="${count != 0 }">
			
			<td colspan="5"><a href="./confirmation?action=checkout&cartId=${cartId}&cid=${cid}"> Checkout </a></td>
			
			</c:if>
			</tr>
		</table>
	</div>

</body>
</html>