<%@ page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>E Store - eCommerce HTML Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="eCommerce HTML Template Free Download" name="keywords">
<meta content="eCommerce HTML Template Free Download" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet">

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link href="lib/slick/slick.css" rel="stylesheet">
<link href="lib/slick/slick-theme.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<%
	User u1 = null;
	if (session.getAttribute("data") != null) {
		u1 = (User) session.getAttribute("data");
	} else {
		response.sendRedirect("login2.jsp");
	}
	%>
	<!-- Top bar Start -->
	<div class="top-bar">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-6">
					<i class="fa fa-envelope"></i> support@email.com
				</div>
				<div class="col-sm-6">
					<i class="fa fa-phone-alt"></i> +012-345-6789
				</div>
			</div>
		</div>
	</div>
	<!-- Top bar End -->

	<!-- Nav Bar Start -->
	<div class="nav">
		<div class="container-fluid">
			<nav class="navbar navbar-expand-md bg-dark navbar-dark">
				<a href="#" class="navbar-brand">MENU</a>
				<button type="button" class="navbar-toggler" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto">
						<a href="index.jsp" class="nav-item nav-link">Home</a> <a
							href="my-account.jsp" class="nav-item nav-link">My Account</a>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle active"
								data-toggle="dropdown">More Pages</a>
							<div class="dropdown-menu">
								<a href="wishlist.jsp" class="dropdown-item">Wishlist</a> <a
									href="login.jsp" class="dropdown-item active">Seller-Register</a>
								<a href="login2.jsp" class="dropdown-item">Seller-Login</a> <a
									href="contact.jsp" class="dropdown-item">Contact Us</a>
							</div>
						</div>
					</div>
					<div class="navbar-nav ml-auto">
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-toggle="dropdown"><%=u1.getFirstname()%></a>
							<div class="dropdown-menu">
								<a href="login2.jsp" class="dropdown-item">Seller-Login</a> <a
									href="login.jsp" class="dropdown-item">Seller-Register</a> <a
									href="customer-login.jsp" class="dropdown-item">Customer-Login</a>
								<a href="customer-registration.jsp" class="dropdown-item">Customer-Register</a>

							</div>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Nav Bar End -->

	<!-- Bottom Bar Start -->
	<div class="bottom-bar">
		<div class="container-fluid">
			<div class="row align-items-center">
				<div class="col-md-3">
					<div class="logo">
						<a href="index.jsp"> <img src="img/logo.png" alt="Logo">
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="search">
						<input type="text" placeholder="Search">
						<button>
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<div class="col-md-3">
					<div class="user">
						<a href="wishlist.jsp" class="btn wishlist"> <i
							class="fa fa-heart"></i> <span>(0)</span>
						</a> <a href="cart.jsp" class="btn cart"> <i
							class="fa fa-shopping-cart"></i> <span>(0)</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bottom Bar End -->

	<!-- Breadcrumb Start -->
	<div class="breadcrumb-wrap">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">Home</a></li>
				<li class="breadcrumb-item"><a href="#">Products</a></li>
				<li class="breadcrumb-item active">Login & Register</li>
			</ul>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Login Start -->
	<form action="productcontroller" method="post"
		enctype="multipart/form-data">
		<div class="login">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6">
						<div class="register-form">
							<div class="row">
								<div class="col-md-6">

									<input class="form-control" type="hidden" name="sid"
										value="<%=u1.getId()%>">
								</div>
								<div class="col-md-6">
									<label>Product Image</label> <input class="form-control"
										type="file" name="image">
								</div>
								<div class="col-md-6">
									<label>Product Name</label> <input class="form-control"
										type="text" name="pn">
								</div>
								<div class="col-md-6">
									<label>Product Price</label> <input class="form-control"
										type="text" name="pp">
								</div>
								<div class="col-md-6">
									<label>product category</label> <input class="form-control"
										type="text" name="pc">
								</div>
								<!--   <div class="col-md-6">
                                    <label>Password</label>
                                    <input class="form-control" type="text" placeholder="Password" name="password">
                                </div> -->



								<div class="col-md-12">
									<input type="submit" value="upload" name="action">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</form>

	<!-- Login End -->

	<!-- Footer Start -->

	<!-- Footer Bottom End -->

	<!-- Back to Top -->
	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>
</html>
