<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>Detail Admin - New User Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/icons.css">

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css">
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/new-user.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

    <!-- navbar -->
    <c:import url="../navbar.jsp"></c:import>
    <!-- end navbar -->

    <!-- sidebar -->
    <c:import url="../slidebar.jsp"></c:import>
    <!-- end sidebar -->


	<!-- main container -->
    <div class="content">
        
        <div id="pad-wrapper" class="new-user">
            <div class="row header">
                <div class="col-md-12">
                    <h3>创建新用户</h3>
                </div>                
            </div>

            <div class="row form-wrapper">
                <!-- left column -->
                <div class="col-md-9 with-sidebar">
                    <div class="container">
                        <form id="new-user-form" class="new_user_form" action="account/user" method="POST">
                            <div class="col-md-12 field-box">
                                <label>用户名:</label>
                                <input name="username" class="form-control" type="text" value="${username}" disabled/>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>密码:</label>
                                <input name="password" class="col-md-9 form-control" type="text" value="000000" disabled/>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>用户组:</label>
                                <div class="ui-select span5">
                                    <select name="repositoryId">
                                        <c:forEach items="${repositories}" var="repository">
                                            <option value="${repository.id}">${repository.name}</option>
                                        </c:forEach> 
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-11 field-box actions">
                                <input type="button" class="btn-glow primary" id="new-user-btn" value="创建">
                                <span>OR</span>
                                <input type="reset" value="取消" class="reset">
                            </div>
                        </form>
                    </div>
                </div>

                <!-- side right column -->
                <div class="col-md-3 form-sidebar pull-right">
                    <div class="alert alert-info hidden-tablet">
                        <i class="icon-lightbulb pull-left"></i>
                        Click above to see difference between inline and normal inputs on a form
                    </div>                        
                    <h6>Sidebar text for instructions</h6>
                    <p>Add multiple users at once</p>
                    <p>Choose one of the following file types:</p>
                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="lib/jquery-1.10.2.min.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/theme.js"></script>

    <script type="text/javascript">
        $(function () {

            $("#new-user-btn").click(function() {

                var username = $("input[name=username]").val();
                var password = $("input[name=password]").val();
                var repositoryId = $("select[name=repositoryId] option:selected").val();

                var url = $("#new-user-form").attr('action');
                var method = $("#new-user-form").attr('method');

                $.ajax({
                    type: method,
                    url: url,
                    dataType: 'json',
                    data: {username: username, password: password, repositoryId: repositoryId},
                    success: function(data, textStatus, jqXHR){
                        console.log(data.statusInfo);
                        alert(data.statusInfo);
                    } 
                });


                //console.log(username + "," + password + "," + repositoryId);

            });

            
        });
    </script>
</body>
</html>