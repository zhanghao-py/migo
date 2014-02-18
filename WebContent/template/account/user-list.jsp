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
	<title>Detail Admin - User list</title>
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
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/user-list.css" type="text/css" media="screen" />

    <style type="text/css">
        .pagination {
          margin: 20px 0;
        }

        .pagination ul {
          display: inline-block;
          *display: inline;
          margin-bottom: 0;
          margin-left: 0;
          -webkit-border-radius: 4px;
             -moz-border-radius: 4px;
                  border-radius: 4px;
          *zoom: 1;
          -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
             -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
                  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05);
        }

        .pagination ul > li {
          display: inline;
        }

        .pagination ul > li > a,
        .pagination ul > li > span {
          float: left;
          padding: 4px 12px;
          line-height: 20px;
          text-decoration: none;
          background-color: #ffffff;
          border: 1px solid #dddddd;
          border-left-width: 0;
          cursor: pointer;
        }

        .pagination ul > li > a:hover,
        .pagination ul > li > a:focus,
        .pagination ul > .active > a,
        .pagination ul > .active > span {
          background-color: #f5f5f5;
        }

        .pagination ul > .active > a,
        .pagination ul > .active > span {
          color: #999999;
          cursor: default;
        }

        .pagination ul > .disabled > span,
        .pagination ul > .disabled > a,
        .pagination ul > .disabled > a:hover,
        .pagination ul > .disabled > a:focus {
          color: #999999;
          cursor: default;
          background-color: transparent;
        }

        .pagination ul > li:first-child > a,
        .pagination ul > li:first-child > span {
          border-left-width: 1px;
          -webkit-border-bottom-left-radius: 4px;
                  border-bottom-left-radius: 4px;
          -webkit-border-top-left-radius: 4px;
                  border-top-left-radius: 4px;
          -moz-border-radius-bottomleft: 4px;
          -moz-border-radius-topleft: 4px;
        }

        .pagination ul > li:last-child > a,
        .pagination ul > li:last-child > span {
          -webkit-border-top-right-radius: 4px;
                  border-top-right-radius: 4px;
          -webkit-border-bottom-right-radius: 4px;
                  border-bottom-right-radius: 4px;
          -moz-border-radius-topright: 4px;
          -moz-border-radius-bottomright: 4px;
        }
    </style>

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
        
        <div id="pad-wrapper" class="users-list">
            <div class="row header">
                <h3>用户列表</h3>
                <div class="col-md-10 col-sm-12 col-xs-12 pull-right">
                    <input type="text" class="col-md-5 search" placeholder="Type a user's name...">
                    
                    <!-- custom popup filter -->
                    <!-- styles are located in css/elements.css -->
                    <!-- script that enables this dropdown is located in js/theme.js -->
                    <div class="ui-dropdown">
                        <div class="head" data-toggle="tooltip" title="Click me!">
                            Filter users
                            <i class="arrow-down"></i>
                        </div>  
                        <div class="dialog">
                            <div class="pointer">
                                <div class="arrow"></div>
                                <div class="arrow_border"></div>
                            </div>
                            <div class="body">
                                <p class="title">
                                    Show users where:
                                </p>
                                <form action="account/user/search" method="POST" id="user-search-form">
                                <div class="form">
                                    <select>
                                        <option>Name</option>
                                        <option>Email</option>
                                        <option>Number of orders</option>
                                        <option>Signed up</option>
                                        <option>Last seen</option>
                                    </select>
                                    <select>
                                        <option>is equal to</option>
                                        <option>is not equal to</option>
                                        <option>is greater than</option>
                                        <option>starts with</option>
                                        <option>contains</option>
                                    </select>
                                    <input type="text" class="form-control" />
                                    <a class="btn-flat small">Add filter</a>
                                </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <a href="account/user/create" class="btn-flat success pull-right">
                        <span>&#43;</span>
                        添加新用户
                    </a>
                </div>
            </div>

            <!-- Users table -->
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="col-md-4 sortable">
                                    用户名
                                </th>
                                <th class="col-md-3 sortable">
                                    <span class="line"></span>状态
                                </th>
                                <th class="col-md-2 sortable">
                                    <span class="line"></span>用户组
                                </th>
                                <th class="col-md-3 sortable">
                                    <span class="line"></span>用户组描述
                                </th>
                            </tr>
                        </thead>
                        <tbody id="datas">
                        <!-- row -->
                        <tr id="template" class="tpl" style="display:none;">
                            <td>
                                <img src="img/contact-img.png" class="img-circle avatar hidden-phone" />
                                <a href="account/user/profile" class="name"><span id="username"></span></a>
                                <span class="subtext">Graphic Design</span>
                            </td>
                            <td>
                                <span id="status-active" class="label label-success" style="display:none;">Active</span>
                                <span id="status-passive" class="label label-info" style="display:none;">Passive</span>
                            </td>
                            <td>
                                <span id="repositoryName"></span>
                            </td>
                            <td>
                                <span id="repositoryDescription"></span>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>                
            </div>
            <div id="pager"></div>
            <!-- end users table -->
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="lib/jquery-1.10.2.min.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/theme.js"></script>
    <script src="lib/bootstrap-paginator.min.js"></script>

    <script type="text/javascript">


        function searchUsers(currentPage, pageSize) {

            var url = $("#user-search-form").attr('action');
            var method = $("#user-search-form").attr('method');

            $.ajax({
                type: method,
                url: url,
                dataType: 'json',
                data: {currentPage: currentPage, pageSize: pageSize},
                success: function(data, textStatus, jqXHR){

                    var status = data.status;
                    var statusInfo = data.statusInfo;
                    

                    if (status) {
                        alert("出错啦，" + statusInfo);
                        return;
                    }

                    var data = data.data;
                    $(".tpl:not(:first)").remove();
                    $.each(data.data, function(i, e) {
                        var row = $("#template").clone();

                        //e.id;
                        row.find("#username").text(e.username);
                        if (e.enabled) {
                            row.find("#status-active").removeAttr("style");
                        } else {
                            row.find("#status-passive").removeAttr("style");
                        }
                        row.find("#repositoryName").text(e.repositoryName);
                        row.find("#repositoryDescription").text(e.repositoryDescription);


                        row.removeAttr("style");
                        row.appendTo("#datas");

                    });

                    
                    var pageSize = data.pageSize;
                    var totalPage = data.totalPage;
                    initialPager(currentPage, pageSize, totalPage);

                } 
            });

        }

        function initialPager(currentPage, pageSize, totalPage) {
            var options = {
                currentPage: currentPage,
                numberOfPages: pageSize,
                totalPages: totalPage,
                onPageClicked: function(e, originalEvent, type, page){
                    searchUsers(page, pageSize);
                }
            }

            $('#pager').bootstrapPaginator(options);
            $('#pager').addClass("pull-right");
        }


        $(document).ready(function(){

            var pageSize = 10;
            var page = 1;
            searchUsers(page, pageSize);

        });
    </script>
</body>
</html>