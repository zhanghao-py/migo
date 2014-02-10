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
                        <form class="new_user_form">
                            <div class="col-md-12 field-box">
                                <label>Name:</label>
                                <input class="form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>State:</label>
                                <div class="ui-select span5">
                                    <select>
                                        <option value="AK">Alaska</option>
                                        <option value="HI">Hawaii</option>
                                        <option value="CA">California</option>
                                        <option value="NV">Nevada</option>
                                        <option value="OR">Oregon</option>
                                        <option value="WA">Washington</option>
                                        <option value="AZ">Arizona</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>Company:</label>
                                <input class="col-md-9 form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>Email:</label>
                                <input class="col-md-9 form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>Phone:</label>
                                <input class="col-md-9 form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>Website:</label>
                                <input class="col-md-9 form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>Address:</label>
                                <div class="address-fields">
                                    <input class="form-control" type="text" placeholder="Street address" />
                                    <input class="small form-control" type="text" placeholder="City" />
                                    <input class="small form-control" type="text" placeholder="State" />
                                    <input class="small last form-control" type="text" placeholder="Postal Code" />
                                </div>
                            </div>
                            <div class="col-md-12 field-box textarea">
                                <label>Notes:</label>
                                <textarea class="col-md-9"></textarea>
                                <span class="charactersleft">90 characters remaining. Field limited to 100 characters</span>
                            </div>
                            <div class="col-md-11 field-box actions">
                                <input type="button" class="btn-glow primary" value="Create user">
                                <span>OR</span>
                                <input type="reset" value="Cancel" class="reset">
                            </div>
                        </form>
                    </div>
                </div>

                <!-- side right column -->
                <div class="col-md-3 form-sidebar pull-right">
                    <div class="btn-group toggle-inputs hidden-tablet">
                        <button class="glow left active" data-input="normal">NORMAL INPUTS</button>
                        <button class="glow right" data-input="inline">INLINE INPUTS</button>
                    </div>
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
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/theme.js"></script>

    <script type="text/javascript">
        $(function () {

            // toggle form between inline and normal inputs
            var $buttons = $(".toggle-inputs button");
            var $form = $("form.new_user_form");

            $buttons.click(function () {
                var mode = $(this).data("input");
                $buttons.removeClass("active");
                $(this).addClass("active");

                if (mode === "inline") {
                    $form.addClass("inline-input");
                } else {
                    $form.removeClass("inline-input");
                }
            });
        });
    </script>
</body>
</html>