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
	<title>Detail Admin - 首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/icons.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="css/common/pagination.css" type="text/css" />


    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- lato font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

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

        <div id="pad-wrapper">

            <!-- table sample -->
            <!-- the script for the toggle all checkboxes from header is located in js/theme.js -->
            <div class="table-products">
                <div class="row head ">
                    <div class="col-md-12">
                        <h4>用户组列表</h4>
                    </div>
                </div>

                <div class="row filter-block">
                    <div class="col-md-8 col-md-offset-5">
                        <form action="account/repository/search" method="POST" id="repository-search-form">
                        <div class="ui-select">
                            <select>
                              <option>Filter users</option>
                              <option>Signed last 30 days</option>
                              <option>Active users</option>
                            </select>
                        </div>
                        <input type="text" class="search">
                        <a class="btn-flat new-product" href="commodity/create">确定</a>
                        </form>
                    </div>
                </div>

                <div class="row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="col-md-3">
                                    <input type="checkbox">
                                    名称
                                </th>
                                <th class="col-md-3">
                                    <span class="line"></span>描述
                                </th>
                                <th class="col-md-3">
                                    <span class="line"></span>状态
                                </th>
                            </tr>
                        </thead>
                        <tbody id="datas">
                            <!-- row -->
                            <tr id="template" class="tpl" style="display:none;">
                                <td>
                                    <input type="checkbox" id="id">
                                    <span id="name"></span>
                                </td>
                                <td class="description">
                                    <span id="description"></span>
                                </td>
                                <td>
                                    <span class="label label-success">Active</span>
                                    <ul class="actions">
                                        <li><i class="table-edit"></i></span></li>
                                        <li><i class="table-settings"></i></li>
                                        <li class="last"><i class="table-delete"></i></li>
                                    </ul>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="pager"></div>
            </div>
            <!-- end table sample -->
        </div>
    </div>


	<!-- scripts -->
    <script src="lib/jquery-1.10.2.min.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/theme.js"></script>
    <script src="lib/bootstrap-paginator.min.js"></script>

    <script type="text/javascript">

        function searchRepositories(currentPage, pageSize) {

            var url = $("#repository-search-form").attr('action');
            var method = $("#repository-search-form").attr('method');

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

                        row.find("#id").val(e.id);
                        row.find("#name").text(e.name);
                        row.find("#description").text(e.description);


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
                    searchRepositories(page, pageSize);
                }
            }

            $('#pager').bootstrapPaginator(options);
        }

        $(document).ready(function(){

            var pageSize = 10;
            var page = 1;
            searchRepositories(page, pageSize);

        });
    </script>
</body>
</html>