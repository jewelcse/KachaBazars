<%@page import="dao.AreaDao"%>
<%@page import="model.DivisionModel"%>
<%@page import="model.DistrictModel"%>
<%@page import="model.UpazillaModel"%>
<%@page import="model.UnionModel"%>
<%@page import="model.DeliveryPersonModel"%>
<%@page import="model.SellerModel"%>
<%@page import="model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	%>
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

<script type="text/javascript">
	

	function loadDistricts(str) {
		var xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {

				var o = JSON.parse(this.responseText); // is a javascript object
				json = JSON.stringify(o)

				var ele = document.getElementById('districtsDropDown');
				ele.innerHTML="";
				for (x in o) {
				
					ele.innerHTML = ele.innerHTML
							+ '<option value="' + x + '">'
							+ o[x] + '</option>';
				}
				/*
				for (x in o) {
					document.getElementById("divisions").innerHTML += x + o[x]
							+ "</br>";
				}
*/
			}

		};
		xhttp.open("GET",
				"./dropdown?divisionsId=" + str + "&action=divisions", true);
		xhttp.send();
		//alert("Hello...")

	}

	function loadUpazillas(str) {
		var xhttp = new XMLHttpRequest();
		
		
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {

				var o = JSON.parse(this.responseText); // is a javascript object
				json = JSON.stringify(o)

				var ele = document.getElementById('upazillasDropDown');
				ele.innerHTML="";
				for (x in o) {
				
					ele.innerHTML = ele.innerHTML
							+ '<option value="' + x + '">'
							+ o[x] + '</option>';
				}
			}

		};
		xhttp.open("GET",
				"./dropdown?districtId="+str+"&action=districts", true);
		xhttp.send();
		//alert("Hello...")

	}

	function loadUnions(str) {
		var xhttp = new XMLHttpRequest();
		
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {

				var o = JSON.parse(this.responseText); // is a javascript object
				json = JSON.stringify(o)

				var ele = document.getElementById('unionsDropDown');
				ele.innerHTML="";
				for (x in o) {
					ele.innerHTML = ele.innerHTML
							+ '<option value="' + x + '">'
							+ o[x] + '</option>';
				}


			}

		};
		xhttp.open("GET",
				"./dropdown?upazillasId="+str+"&action=unions", true);
		xhttp.send();
		//alert("Hello...")

	}

	function loadDelivery(str) {
		var xhttp = new XMLHttpRequest();

		
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {

				var o = JSON.parse(this.responseText); // is a javascript object
				json = JSON.stringify(o)

				var ele = document.getElementById('deliverydd');
				ele.innerHTML="";
				for (x in o) {
					ele.innerHTML = ele.innerHTML
							+ '<option value="' + x + '">'
							+ o[x] + '</option>';
				}


			}

		};
		xhttp.open("GET",
				"./dropdown?unionId="+str+"&action=delivery", true);
		xhttp.send();
		//alert("Hello...")

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
		<h2>View Order</h2>
	</div>



		<div class="container">
		
		<form action="./orderoperations?oid=${order.orderId}&action=orderinventory" method="post">
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
					<td>Address</td>
					<td>${order.divisionModel.divisionBanglaName}, ${order.districtModel.districtBanglaName}, ${order.upazillaModel.upazillaBangaName}, ${order.unionModel.unionBanglaName}<br>
						${order.orderVillage}, ${order.orderStreet}, ${order.orderStreet}
					</td>
				</tr>
				
				<tr>
						<td>Phone Number</td>
						<td><input type="text" name="deliveryPhone" value="${order.phoneNumber}"></td>
					</tr>
					<tr>
						<td>Quantity</td>
						<td><input type="text" name="deliveryQuantity" value="${order.orderQuantity}"></td>
					</tr>
					
				<%
					DBData db = new DBData();
					AreaDao ad = new AreaDao();
					
					List<DivisionModel> divisionModels = db.getAllDivision();
					request.setAttribute("divisions", divisionModels);
				%>
				
				<tr>
					<td>Delivery Division</td>
					<td>
						<select name="deliveryDivision" required="required" id="divisionsDropDown" onchange="loadDistricts(this.value)">
							<c:forEach items="${divisions}" var="division">
								<option value="${division.divisionId }">${division.divisionBanglaName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				
				<tr>
					<td>Delivery District</td>
					<td>
						<select name="deliveryDistrict" id="districtsDropDown" onchange="loadUpazillas(this.value)" required="required">
								<option value="${order.districtModel.districtId}"> ${order.districtModel.districtBanglaName}</option>
							
						</select>
					</td>
				</tr>
						
								
				<tr>
					<td>Delivery Upazilla</td>
					<td>
						<select name="deliveryUpazilla" required="required" id="upazillasDropDown" onchange="loadUnions(this.value)">
						<option value="${order.upazillaModel.upazillaId}">${order.upazillaModel.upazillaBangaName}</option>
	
						</select>
					</td>
				</tr>
				

				
				<tr>
					<td>Delivery Union</td>
					<td>
						<select name="deliveryUnion" required="required" id="unionsDropDown" onchange="loadDelivery(this.value)">
							<option value="${order.unionModel.unionId}">${order.unionModel.unionBanglaName}</option>

						</select>
					</td>
				</tr>
				
				
				<tr>
					<td>Delivery Person</td>
					<td>
						<select name="deliveryPerson" required="required" id="deliverydd">
							<option value="${order.deliveryPersonModel.deliveryPersonId}">${order.deliveryPersonModel.deliveryPersonFirstName} ${order.deliveryPersonModel.deliveryPersonLastName}</option>
						</select>
					</td>
				</tr>
					
					
					<tr>
						<td>Village</td>
						<td><input type="text" name="deliveryVillage" value="${order.orderVillage}"></td>
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
					<tr>
						<td>Order Status</td>
						<td><select name="orderStatus">
							<option value="${order.orderStatus}">${order.orderStatus} </option>
							<option value="Unallocated">Unallocated</option>
							<option value="Allocated">Allocated</option>
							<option value="Processing">Processing</option>
							<option value="Delivered">Delivered</option>
							<option value="Failed">Failed</option>
						</select></td>
					</tr>
					
					<input type="hidden" name="orderDate" value="${order.orderDate}">
					<input type="hidden" name="productModel" value="${order.productModel.productId}">
					<input type="hidden" name="customerModel" value="${order.customerModel.customerId}">
					<input type="hidden" name="deliveryPersonModel" value="${order.deliveryPersonModel.deliveryPersonId}">
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