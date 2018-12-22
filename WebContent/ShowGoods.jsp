<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
    	<link rel="stylesheet" href="css/justified-nav.css" />
    	<link rel="stylesheet" href="css/carousel.css" />
    	<link href="css/signin.css" rel="stylesheet">
    	<style type="text/css">
    		.ShowGoods{
    			width: 1100px;
    			margin: 100px auto;
    			}
    	</style>
<title>Insert title here</title>
</head>
<body>
<% 
HttpSession session1 = request.getSession();
if(session1.getAttribute("username")==null){
	
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
%>
<!-- 导航开始 -->
 <div class="navbar-wrapper">
      <div class="container">
        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">小张.电子购物网站后台管理</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">小张.电子购物网站后台管理</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="#contact">当前登录的用户为:<%=session.getAttribute("username")%></a></li>

                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">商品类型 <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <c:forEach items="${types}" var="type">
                    <li><a href="${pageContext.request.contextPath}/AdminServlet?typeid=${type.id}">${type.typeName}</a></li>
                    </c:forEach>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    </div>
    <!-- 导航结束 -->
	
	<!-- 商品展示列表 -->
<div class="ShowGoods">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>商品名字</th>
				<th>商品图片</th>
				<th>操作</th>
			</tr>
		</thead>
	    <tbody>
	    <c:forEach items="${goods}"  var="good">
	    	<tr>
				<td>${good.name}</td>
				<td><img  class="img-rounded" src="${pageContext.request.contextPath}/${good.imgpath}" alt="${good.name}" width="140" height="140"></td>
				<td>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/DeleteServlet?goodid=${good.id}" role="button">删除</a>
					<a class="btn btn-warning" href="#" role="button">修改</a>
				</td>
			</tr>
		</c:forEach>
	    </tbody>
	</table>
</div>
	<!-- 商品展示列表结束 -->

  <!--分割线-->	
  <hr class="featurette-divider">
  
  
  
  <script type="text/javascript" src="lib/jquery/jquery-1.9.1.js" ></script>
	<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js" ></script>

</body>
</html>