<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>Welcome to College web Project</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-panels.min.js"></script>
<script src="js/init.js"></script>
<script type="text/javascript">
function loadimage() {
	document.getElementById("randImage").src = "<%=path%>/image.jsp?"
				+ Math.random();
	}
</script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
	<link rel="stylesheet" href="css/style-noscript.css" />
</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
</head>
<body class="homepage">
	<div id="header">
		<!-- Inner -->
		<div class="inner">
			<header>
				<h1>
					<a href="#" id="logo">College web Project</a>
				</h1>
				<hr />
				<span class="byline">Welcome to Online Library</span>
			</header>
			<footer>
				<a href="#banner" class="button circled scrolly">Start</a>
			</footer>
		</div>
		<nav id="nav">
			<ul>
				<li>Home</li>
				<li><span>One</span>
					<ul>
						<li>Where footsteps cannot reach, vision can reach; where vision cannot reach, spirit can fly.</li>
					</ul></li>
				<li>Bg_Pictuer
					<ul>
						<li>College University Libraries</li>
						<li>One of the most beautiful libraries in the world, located at My College</li>
					</ul>
				</li>
				<li>About
					<ul>
						<li>Manager：Holiday</li>
						<li>Developer：Singlelines</li>
						<li>Web art：Manax</li>
						<li>Designer：Christal</li>
						<li>Designer：Smallfish</li>
					</ul>
				</li>
				<li>Contact
					<ul>
					<li>Holiday Software Studio.&nbsp;&nbsp;&nbsp;holiday@msn.com</li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
	<FORM action="LoginServlet" method="post">
		<div id="banner">
			<h3>
				<strong>User Id:</strong> <input type="text" name="userid" id="userid"
					size="20">
			</h3>
			<br>
			<h3>
				<strong>Password: </strong> <input type="password"
					name="password" id="password" size="21">
			</h3>
			<br>
			<h3>
				<strong>Verification code : </strong> <input type="text" name="rand" id="rand"
					size="10"> <a href="javascript:loadimage();"> <img
					alt="Verification code" name="randImage" id="randImage" src="<%=path%>/image.jsp"
					width="80" height="30" border="1" align="absmiddle">
				</a>
			</h3>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
			<h5>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="type" type="radio" value="1">
				Student&nbsp;&nbsp;&nbsp; <input name="type" type="radio" value="2">
				Administrator
			</h5>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="register.jsp">Register here! </a> <input name="LOG IN"
				type="submit"
				style="width:100px;background-color:#FF6666;
                  font-size:18px;color:white;font-weight: bold"
				value="LOG IN">
		</div>
	</FORM>
	<div class="copyrights">Copyright &copy; 2022 My Software
		Studio. All rights reserved.</div>
</body>
</html>