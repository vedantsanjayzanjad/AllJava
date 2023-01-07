<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@include file="./base.jsp" %>
</head>
<body>

<div class="container mt-3">
	 <div class="row">
	 	<div class="col-md-6 offset-md-3">
	 		<h2 class="text-center mb-3"> Fill the product details</h2>
	 		<div class="card">
	 		<div class="card-body">
	 		
	 		<form action="handle-product" method="post">
	 			<div class="form-group">
	 			<label for="name">Product Name</label>
	 			<input type="text" class="form-control" 
	 			name="name" id="name" placeholder="Enter the product name here">
	 			</div>
	 			
	 			<div class="form-group">
	 			<label for="desc">Product Description</label>
	 			<textarea row="5" class="form-control" 
	 			name="description" id="description" placeholder="Enter the product Description here"></textarea>
	 			</div>
	 			
	 			<div class="form-group">
	 			<label for="price">Product Price</label>
	 			<input type="text" class="form-control" 
	 			name="price" id="price" placeholder="Enter the product price here">
	 			</div>
	 			
	 			
	 			<div class="container text-center">
	 			<a href="${pageContext.request.contextPath }/"
	 			class="btn btn-outline-danger">Back</a>
	 			<button class="btn btn-outline-success">Add</button>
	 			</div>
	 		</form>
	 		</div>
	 	  </div>	
	 	</div>
	 	
	 </div>


</div>

</body>
</html>