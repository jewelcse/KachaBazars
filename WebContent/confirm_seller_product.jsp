<%@page import="model.UnionModel"%>
<%@page import="model.UpazillaModel"%>
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


<jsp:include page="navbar.jsp" />
<jsp:include page="sidenavbar.jsp" />


<%
	System.out
			.println(session.getAttribute("cid") + " line 33 home " + (String) session.getAttribute("message"));
	if (session.getAttribute("cid") != null) {
		String login = (String) session.getAttribute("message");
		String name = (String) session.getAttribute("name");

		request.setAttribute("login", login);
		request.setAttribute("name", name);
	}

	DBData db = new DBData();
	int cid = Integer.parseInt(session.getAttribute("cid").toString());
	if (session.getAttribute("cid") != null) {
		String login = (String) session.getAttribute("message");
		String name = (String) session.getAttribute("name");

		request.setAttribute("login", login);
		request.setAttribute("name", name);
		CustomerModel customerModels = db.getCustomerById(cid);
		request.setAttribute("customers", customerModels);
	}

	AreaDao ad = new AreaDao();

	List<DivisionModel> divisionModels = db.getAllDivision();
	request.setAttribute("divisions", divisionModels);

	List<DistrictModel> districtModels = ad.getAllDistricts();
	request.setAttribute("districts", districtModels);

	List<UpazillaModel> upazillaModels = ad.getAllUpazillas();
	request.setAttribute("upazillas", upazillaModels);

	List<UnionModel> unionModels = ad.getAllUnions();
	request.setAttribute("unions", unionModels);
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" type="text/css" href="./css/oneclickbuy.css">
<title>KachaBazar</title>

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
</script>
<script src="javascript/jquery.js"></script>

</head>
<body>


	<div class="page-info">
		<h2>
			<u>Buy Product</u>
		</h2>
	</div>

		

	<div class="detail-container">
			<div class="current-info">
			<h3>Use your current Information to buy</h3>
			<div class="customer-image">
				<img src="images/customers/${customers.customerImageName}">
			</div>
				<form
					action="./orders?action=confirmsellerproductcurrentinfo&cid=${customers.customerId}&pid=${product.productId}&qty=${qty}"
					method="post">
					
					<p><u>Expected Date</u></p> 
					
					<p>
					<input class="input-field" type="date" name="deliveryDate"
						required="required" placeholder="Expected Date">
					</p>
						<button class="button medium red">Order</button>
				</form>
				</div>
				
				<div class="new-info">
				<h3>Or add new Information</h3>
				<form
					action="./orders?action=confirmsellerproduct&cid=${customers.customerId}&pid=${product.productId}&qty=${qty}"
					method="post">
					<h4>Shipping Information</h4>
					<p><input class="input-field" type="text" name="careOfContact" required="required"
						placeholder="Name"></p>
						
						<p> <input class="input-field" type="text"
						name="deliveryPhone" required="required" placeholder="Phone"></p>
					
					<p>
					<select class="input-field" name="deliveryDivision" required="required" id="divisionsDropDown" onchange="loadDistricts(this.value)">
						<option disabled="disabled" selected="selected">Select Division</option>
						<c:forEach items="${divisions}" var="division">
							<option value="${division.divisionId }">${division.divisionBanglaName}</option>
						</c:forEach>
					</select> 
					</p>
					<p>
					<select class="input-field" name="deliveryDistrict" required="required" id="districtsDropDown" onchange="loadUpazillas(this.value)">
						
					</select>
					</p>
					
					<p>
					 <select class="input-field" name="deliveryUpazilla" required="required" id="upazillasDropDown" onchange="loadUnions(this.value)">
						
					</select>
					</p>
					 
					<p><select class="input-field" name="deliveryUnion" required="required" id="unionsDropDown">
						
					</select></p>
					
					<p>
					 <input class="input-field" type="text" name="deliveryVillage"
						required="deliveryVillage" placeholder="Village">
						</p>
						
						<p> <input class="input-field"
						type="text" name="deliveryStreet" required="required"
						placeholder="Street">
						</p>
						
						<p>
						 <input class="input-field" type="text"
						name="deliveryZipCode" required="required" placeholder="ZipCode">
						</p>
						<p>
					<u>Expected Date</u></p>
					
					<p> <input class="input-field" type="date" name="deliveryDate"
						required="required" placeholder="Expected Date"></p>
						
						<p>
						<button class="button medium blue">Click to Order</button>
						</p>
			</div>
		</div>		
	</form>

</body>
</html>