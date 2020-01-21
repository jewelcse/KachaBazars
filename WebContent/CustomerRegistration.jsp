<%@page import="model.UnionModel"%>
<%@page import="model.UpazillaModel"%>
<%@page import="model.DistrictModel"%>
<%@page import="model.DivisionModel"%>
<%@page import="java.util.List"%>
<%@page import="dao.AreaDao"%>
<%@page import="model.AreaModel"%>
<%@page import="dao.DBData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="menubar.jsp" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="css/signing.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">
<title>Login</title>

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


</head>
<body>


	<div class="container">
		<div class="box-info">
			<h3>Sign Up</h3>
		</div>
		<form action="./customers?action=reg" method="post"
			enctype="multipart/form-data">

			<div class="add">
				<table class="form-table">
					<tr>
						<th colspan="2"><h3>Sign Up</h3></th>
					</tr>
					<tr>
						<td>Customer First Name</td>
						<td><input class="input-field" type="text" name="customerFirstName"
							required="required"></td>
					</tr>

					<tr>
						<td>Customer Last Name</td>
						<td><input class="input-field" type="text" name="customerLastName"
							required="required"></td>
					</tr>

					<tr>
						<td>Customer Phone Number</td>
						<td><input class="input-field" type="text" name="customerPhone"
							required="required"></td>
					</tr>

					<tr>
						<td>Customer Image</td>
						<td><input class="input-field" type="file" name="customerImage"
							required="required"></td>
					</tr>

					<%
						DBData db = new DBData();
						AreaDao ad = new AreaDao();

						List<DivisionModel> divisionModels = db.getAllDivision();
						request.setAttribute("divisions", divisionModels);
					%>

					<tr>
						<td>Customer Division</td>
						<td><select class="input-field" id="divisionsDropDown" onchange="loadDistricts(this.value)"  name="customerDivision" required="required">
								<c:forEach items="${divisions}" var="division">
									<option value="${division.divisionId }">${division.divisionBanglaName}</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td>Customer District</td>
						<td><select class="input-field" id="districtsDropDown" onchange="loadUpazillas(this.value)" name="customerDistrict" required="required">
						
						</select></td>
					</tr>


					<tr>
						<td>Customer Upazilla</td>
						<td><select class="input-field" name="customerUpazilla" id="upazillasDropDown" onchange="loadUnions(this.value)" required="required">
								
						</select></td>
					</tr>



					<tr>
						<td>Customer Union</td>
						<td><select class="input-field" id="unionsDropDown" name="customerUnion" required="required">
								
						</select></td>
					</tr>

					<tr>
						<td>Customer Village</td>
						<td><input class="input-field" type="text" name="customerVillage"
							required="required"></td>
					</tr>
					<tr>
						<td>Customer Zip Code</td>
						<td><input class="input-field" type="text" name="customerZipcode"
							required="required"></td>
					</tr>

					<tr>
						<td>Customer Street</td>
						<td><input class="input-field" type="text" name="customerStreet"
							required="required"></td>
					</tr>

					<tr>
						<td>Customer Holding Number</td>
						<td><input class="input-field" type="text" name="customerHoldingNumber"
							required="required"></td>
					</tr>

					<tr>
						<td>Customer Date of Birth</td>
						<td><input class="input-field" type="date" name="customerDOB" required="required"></td>
					</tr>



					<tr>
						<td>Customer Password</td>
						<td><input class="input-field" type="text" name="customerPassword"
							required="required"></td>
					</tr>

				</table>
			</div>
			<c:if test="${action == 'reg' }">
				<input type="hidden" value="reg" name="action">
			</c:if>

				<input class="button" type="submit" value="Submit">
				
				<p>
				<div class="misc">
				<a href="./customers?action=login">Already Have an Account?</a>
				</div>
				</p>
		</form>
	</div>

</body>
</html>