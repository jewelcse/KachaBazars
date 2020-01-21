<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./css/oneclickbuy.css">
	<title>One Click Buy</title>
	<script src="javascript/jquery.js"></script>
		<script> 
			$(function(){
			  $("#navbar").load("navbar.html"); 
			  $("#footer").load("footer.html"); 
			});
		</script>

</head>
<body>

	<div id="navbar"></div>

	<div class="page-info">
		<h2><u>Buy Product</u></h2>
	</div>

	<div class="detail-container">
		<div class="personal-info">
			<div class="customer-image">
				<img src="images/member4.png">
			</div>
			<div class="current-info">
				<h3>Use your current Information to buy</h3>
				<button class="button-1">Order</button>
				<h3>Or add new Information</h3>
			<form>
				<h4>Shipping Information</h4>
				<input type="text" name="name" placeholder="Person Name">
				<input type="text" name="name" placeholder="House No">
				<input type="text" name="name" placeholder="Street">
				<input type="text" name="name" placeholder="Union/City">
				<input type="text" name="name" placeholder="Upazila">
				<input type="text" name="name" placeholder="District">
				<input type="text" name="name" placeholder="Division">
				<input type="date" name="name" >
			</form>
		</div>
	</div>

		<div class="product-details">
			
		</div>

		<div class="product-info">
			<div class="product-image">
				<img src="images/4.png">
			</div>
			<table class="product-table">
				<tr>
					<th class="product-name">Name</th>
					<th class="product-quantity">Quantity</th>
					<th class="seller">Buying from</th>
					<th class="rating-info">Rating</th>
					<th class="price">Price</th>
				</tr>

				<tr>
					<td>
						Beef
					</td>

					<td>
						<input type="number" step=".5" name="">
					</td>

					<td>
						Minhaz	
					</td>

					<td>
						<div class="rating">
							<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
						</div>
					</td>

					<td>
						510/=	
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="button-2">
			<button class="order-button">Click to Order</button>
		</div>

</body>
</html>