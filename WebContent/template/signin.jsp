<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
  <head>
  
  	<base href="<%=basePath%>">
    <title>Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/signin.css">

  </head>

  <body screen_capture_injected="true">

    <div class="container">

      <form class="form-signin" role="form" action="/j_spring_security_check" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${not empty param.error}">
          <h5 class="text-danger form-signin-heading" id="warning-area">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</h5>
        </c:if>
        <input name="j_username" type="text" class="form-control" placeholder="Username" required="" autofocus="">
        <input name="j_password" type="password" class="form-control" placeholder="Password" required="">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button type="submit" class="btn btn-lg btn-primary btn-block" id="signin-btn">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script src="/lib/jquery-1.10.2.min.js"></script>
    <script src="/lib/bootstrap.min.js"></script>
    <!--
    <script src="/js/signin.js"></script>
    -->
  

  </body>
</html>