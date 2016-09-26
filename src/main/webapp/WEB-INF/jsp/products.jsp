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
                <a class="navbar-brand" href="${productListPageURL}">Cool Shoes</a>
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
                <h1 class="page-header">Shoes
                    <small>Select categories or search using search box</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->
		
        <div class="row">
			<div class="row">
				<!-- left category  -->
	            <div class="col-md-3">
	                <p class="lead">Top Categories</p>
	                <div id="category-options" class="list-group">
						<c:if test="${not empty categoryList}">
							<c:forEach var="listValue" items="${categoryList}">
								<a href="<c:url value='products-by-category-${listValue}' />" class="list-group-item category-select-option" data-category-name="${listValue}">${listValue}</a>
							</c:forEach>
						</c:if>
	                </div>
	            </div>
				
				<div class="col-md-9">
					<c:if test="${not empty productList}">
						<c:set var="divCount" scope="page" value="0"/>
						<div class="row">
						<c:forEach var="listValue" items="${productList}">
				            <div class="col-md-3 col-sm-12 col-xs-12 portfolio-item">
				                <a href="<c:url value='product-details-${listValue.getProductCode()}' />">
				                    <img class="img-responsive" src="${images}/${listValue.getImageUrl()}" alt="">
				                </a>
    							<p >${listValue.getProductName()}</p>
				            </div>
				            <c:set var="divCount" value="${divCount + 1}" />
				            <c:if test="${divCount % 3 == 0}">
		            	</div>
		            	<div class="row">
				            </c:if>
						</c:forEach>
						</div>
					</c:if>
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

</body>

</html>