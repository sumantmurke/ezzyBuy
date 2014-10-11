<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Catlog</title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>


function addCatlog(){
//	$("#reEnterPasswordInput").keyup(checkPasswordMatch());

	 alert('inside addcart');

	var companyname = $('#company-name').val();
	var productname = $('#product-name').val();
	var price = $('#price').val();
	var quantity = $('#quantity').val();
	

	 alert('company name '+companyname);

	$.ajax({
	
		url : "mob/catlog/addCatlog",
		type : "POST",
		data : "companyname=" + companyname + "&productname=" + productname + "&price=" + price
		+ "&quantity=" + quantity,
		dataType:"text", 

		success : function(data) {
			alert('success');
			alert(data);
			var obj= jQuery.parseJSON(data);	
			alert("obj is "+obj.company );
			window.location.href = "addCatlog.jsp";
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Could not process request.. ' + errorThrown);
			window.location.href = "login.jsp";
		}
	});
}


</script>





</head>
<body>
<%@include file="layout/header.jsp"%>






<div>
		<div>
			<div
				style="background-color: ghostwhite; margin-top: 100px; margin-left: 100px; margin-right: 200px; height: auto; -webkit-box-shadow: 3px 0px 5px #888888; -moz-box-shadow: 3px 0px 5px #888888; box-shadow: 3px 0px 5px #888888; padding: 30px;">

				<div id="container" style="padding-top: 40px;">
					<div class="container-fluid">
						<div class="row-fluid">
							<div id="sidebar" class="span2">
								<!--Sidebar content-->
								<ul id="sidebar-list" class="nav nav-list">
								</ul>
							</div>
							<div class="tab-content">
								<div class="tab-pane active" id="NewUserSignUp">
									<table cellpadding="5px">
										<!--Body content-->
										<tr>
											<h3>Add products here</h3>
										</tr>
										<tr>
											<td><h5>Company Name</h5></td>
											<td></td>
											<td><div class="input-group">
													<input type="text" id="company-name" class="required"
														placeholder="Name of Company">
												</div></td>
										</tr>
										<tr></tr>
										<tr>
											<td><h5>Product</h5></td>
											<td></td>
											<td><div class="input-group">
													<input type="text" id="product-name" class="required"
														placeholder="Name of Product">
												</div></td>
										</tr>
										<tr></tr>
										<tr>
											<td><h5>Price</h5></td>
											<td></td>
											<td><div class="input-group">
													<input type="email" id="price" class="required email"
														placeholder="Price">
												</div></td>
										</tr>
										<tr></tr>
										
										<tr>
											<td><h5>Quantity</h5></td>
											<td></td>
											<td><div class="input-group">
													<input type="password" id="quantity" class="required"
														placeholder="Quantity">
												</div></td>
											<td></td>
										</tr>
										<tr></tr>
										
										<tr></tr>
										<tr>
											<td></td>
											<td></td>
											<td><div class="col-sm-offset-2 col-sm-10">
													<button id="signup" class="btn btn-primary" type="button"
														onclick="addCatlog()">Add</button>
													<!--  		
									<input type="submit" class="btn btn-default" id="signup" value="Sign Up"/>
							
							
							
							-->
												</div></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>














</body>
</html>