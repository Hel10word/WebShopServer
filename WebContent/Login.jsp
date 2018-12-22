<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
    	<link rel="stylesheet" href="css/justified-nav.css" />
    	<link rel="stylesheet" href="css/carousel.css" />
    	<link href="css/signin.css" rel="stylesheet">
</head>
<body>
<% session.setAttribute("username",""); %>
<div class="container">
      <form class="form-signin" action="LoginServlet" method="post">
        <h2 class="form-signin-heading">请登录后台页面</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" class="form-control" id="firstname" placeholder="用户名" name="username">
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>
</div>




	<script type="text/javascript" src="lib/jquery/jquery-1.9.1.js" ></script>
	<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js" ></script>
</body>
</html>