<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    

	
    <title>Product List Page</title>
    
    <spring:url value="/main/products" var="productListPageURL" />
	<spring:url value="/main/shopping-cart" var="shoppingCartPageURL" />
	
	<spring:url value="/resources/images" var="images" />
	
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet">
    <spring:url value="/resources/css/4-col-portfolio.css" var="themeCSS" />
    <link href="${themeCSS}" rel="stylesheet">
    <spring:url value="/resources/css/custom.css" var="customCSS" />
    <link href="${customCSS}" rel="stylesheet">
    <style>
    
    <spring:url value="/resources/fonts/glyphicons-halflings-regular.eot"	var="file1" />
    <spring:url value="/resources/fonts/glyphicons-halflings-regular.svg"	var="file2" />
    <spring:url value="/resources/fonts/glyphicons-halflings-regular.ttf"	var="file3" />
    <spring:url value="/resources/fonts/glyphicons-halflings-regular.woff"	var="file4" />
    <spring:url value="/resources/fonts/glyphicons-halflings-regular.woff2"	var="file5" />
    
	@font-face {
    font-family: 'Glyphicons Halflings';

    src: url('${file1}');
    src: url('${file1}?#iefix') format('embedded-opentype'), url('${file4}') format('woff'), url('${file3}') format('truetype'), url('${file2}#glyphicons_halflingsregular') format('svg');
	}
    </style>
    
	<spring:url value="/resources/js/jquery-3.1.0.min.js" var="resourceJquery" />
	<script src="${resourceJquery}"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="resourceBootstrapJs" />
	<script src="${resourceBootstrapJs}"></script>
	<script>
	$(document).ready(function() {
		$("#add-to-basket-btn").click(function() {
			var productCode = $(this).attr('data-product-code');
			var quantity = $("#quantity-input").val();
			
			if(quantity == '') {
				$("#modal-body-msg").text('Please enter a quantity');
				
				return;
			}
						
			$.ajax({
				url: 'services/addToCart',
				data: {
					'productCode' : productCode,
					'quantity': quantity
				}
			});
			
			var msg = quantity + ' items added to your cart.';
			$("#modal-body-msg").text(msg);
		});
		
		$("#ok-modal-button").click(function() {
			// refresh input
			$("#quantity-input").val('');
		});
		
	});
	
	</script>
</head>

<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Cool Shoes</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${productListPageURL}">Product List</a>
                    </li>
                    <li>
                        <a href="${shoppingCartPageURL}">Shopping Cart</a>
                    </li>
                </ul>
                
                <!-- search -->
		        <div class="col-sm-3 col-md-3 pull-right">
			        <form id="search-field-form" class="navbar-form" role="search" action="<c:url value="products" />" method="GET">
				        <div class="input-group">
				        	<input id="search-field" type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
				            <div class="input-group-btn">
			                	<button id="search-field-btn" class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
			                	</button>
				            </div>
				        </div>
			        </form>
		        </div>
		        
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Shopping Cart
                    <small>Product Details Page</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->
			
        <hr>
        
        <!-- page content  -->
		<div class="row">
			<!-- left category  -->
            <div class="col-md-6">
            	<img class="img-responsive" src="${images}/${product.getImageUrl()}" alt="">
            </div>
	        
			<!-- right category  -->
            <div class="col-md-6">
            	<div>
            		<h3>${ product.getProductName() }</h3>
            		<p>${ product.getPrice() } TL</p>
            		<div class="row">
            			<div class="col-lg-6 col-md-6">
							<div class="input-group">
								<span class="input-group-addon" >Quantity</span>
								<input id="quantity-input" type="text" class="form-control" placeholder="0" aria-describedby="quantity-input">
							</div>
            			</div>
						<div class="col-lg-3 col-md-3">
							<button id="add-to-basket-btn" data-product-code="${ product.getProductCode() }" type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#success-modal">Add To Basket</button>
						</div>
            		</div>
            		<br />
            		<div class="row">
						<table class="table">
							<thead>
								<td>Product Details</td>
							</thead>
							<tbody>
								<tr>
									<td>Size:</td>
									<td>${ product.getSize() }</td>
								</tr>
								<tr>
									<td>Color:</td>
									<td>${ product.getColor() }</td>
								</tr>
							</tbody>
						</table>
            		</div>
            	</div>
            </div>
		</div>
		
		<hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Divilioglu LTD. 2016</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->
    
<!-- Modal -->
<div class="modal fade" id="success-modal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Thank You</h4>
			</div>
			<div class="modal-body">
				<p id="modal-body-msg">items added to your cart.</p>
			</div>
			<div class="modal-footer">
				<button id="ok-modal-button" type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				<a href="products" type="button" class="btn btn-default" >Back To Products</a>
			</div>
		</div>

	</div>
</div>

</body>

</html>