
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header logo: style can be found in header.less -->
<link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico">
<header class="header">
	<a href="index.jsp" class="logo"> Admin </a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>
		<div class="navbar-right">
			<ul class="nav navbar-nav">

				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="glyphicon glyphicon-user"></i> <span>Admin<i
							class="caret"></i></span>
				</a>
					<ul class="dropdown-menu">
						<!-- Menu Footer-->
						<li class="user-body"><a href="LogoutServlet"
							class="btn btn-default btn-flat">Sign out</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
</header>