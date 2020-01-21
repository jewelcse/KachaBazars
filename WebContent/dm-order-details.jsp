<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://code.ionicframework.com/1.0.0/css/ionic.css" />
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.ionicframework.com/1.0.0/js/ionic.bundle.js"></script>
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title>Order Details</title>
</head>
<body>
	
	<div align="center">

	<h1>Order Details</h1>
	<form action="./doperations?action=update&oid=${orderdetails.orderId}" method="post">
	<table data-role="table"  id="table-1"
			class="ui-body-a ui-responsive table-stripe" style="max-width: 80%;">
		
		<thead>
				<tr class="ui-bar-a">
					<th>Id</th>
					<th data-priority="1">${orderdetails.orderId }</th>
				</tr>
		</thead>
		<tbody>
		<tr>
			<td> orderDate </td>
			<td> ${orderdetails.orderDate } </td>
		</tr>
		
		<tr class="ui-bar-a">
			<td>productModel</td>
			<td> ${orderdetails.productModel.productName } </td>
		</tr>
		
		<tr>
			<td>careOfContact</td>
			<td> ${orderdetails.careOfContact } </td>
		</tr>
		
		<tr class="ui-bar-a">
			<td>phoneNumber</td>
			<td> ${orderdetails.phoneNumber } </td>
		</tr>
		
		<tr>
			<td>orderQuantity</td>
			<td> ${orderdetails.orderQuantity } </td>
		</tr>
		
		<tr class="ui-bar-a">
			<td>Address</td>
			<td> ${orderdetails.divisionModel.divisionBanglaName}, ${orderdetails.districtModel.districtBanglaName}, ${orderdetails.upazillaModel.upazillaBangaName}, ${orderdetails.unionModel.unionBanglaName}</td>
		</tr>
		
		<tr>
			<td>orderVillage</td>
			<td> ${orderdetails.orderVillage } </td>
		</tr>
		
		<tr class="ui-bar-a">
			<td>orderStreet</td>
			<td>${orderdetails.orderStreet }</td>
		</tr>
		
		<tr>
			<td>orderZipCode</td>
			<td>${orderdetails.orderZipCode }</td>
		</tr>
		
		<tr class="ui-bar-a">
			<td>Total amount to be collected</td>
			<td> ${amount} </td>
		</tr>
		
		<tr>
			<td>paymentStatus</td>
			<td>
				${payment}
			</td>
		</tr>
		
		<tr class="ui-bar-a">
			<td>expectedDeliveryDate</td>
			<td>${orderdetails.expectedDeliveryDate }</td>
		</tr>
		
		
		
		<tr class="ui-bar-a">
			<th>orderStatus</th>
			<th data-priority="1"> 
			<div class="ui-field-contain">
				<select name="orderStatus" id="select-1" data-theme="a">
					<option value="${orderdetails.orderStatus }">${orderdetails.orderStatus }</option>
					
					<option disabled="disabled">Allocated</option>
					<option disabled="disabled">Unallocated</option>
					<option value="processing">Processing</option>
					<option value="completed">Completed</option> 
					<option value="cancelled">Cancel</option>
					 
				</select>
				</div>
			</th>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="Update" id="button-1" style="max-width: 50%" >
			</td>
		</tr>
		
		</tbody>

		
	</table>
	</form>

</div>
</body>
</html>