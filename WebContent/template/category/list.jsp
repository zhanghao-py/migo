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

    <style type="text/css">
        .nav-list{padding-right:15px;padding-left:15px;margin-bottom:0}
        .nav-list>li>a,.nav-list .nav-header{margin-right:-15px;margin-left:-15px;text-shadow:0 1px 0 rgba(255,255,255,0.5)}
        .nav-list>li>a{padding:3px 15px}
        .nav-list>.active>a,.nav-list>.active>a:hover,.nav-list>.active>a:focus{color:#fff;text-shadow:0 -1px 0 rgba(0,0,0,0.2);background-color:#08c}
        .nav-list [class^="icon-"],.nav-list [class*=" icon-"]{margin-right:2px}
        .nav-header{display:block;padding:3px 15px;font-size:11px;font-weight:bold;line-height:20px;color:#999;text-shadow:0 1px 0 rgba(255,255,255,0.5);text-transform:uppercase}
        .nav li+.nav-header{margin-top:9px}
        .nav-list{padding-right:15px;padding-left:15px;margin-bottom:0}

        label, a {cursor: pointer;}

    </style>

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
        <!--
        <div class="well" style="width:300px; padding: 8px 0;">
            <div style="">
                <ul class="nav nav-list">
                    <li><label class="tree-toggler nav-header">Header 1</label>
                        <ul class="nav nav-list tree">
                            <li><a><span>Link</span></a></li>
                            <li><a><span>Link</span></a></li>
                            <li><label class="tree-toggler nav-header">Header 1.1</label>
                                <ul class="nav nav-list tree">
                                    <li><a><span>Link</span></a></li>
                                    <li><a><span>Link</span></a></li>
                                    <li><label class="tree-toggler nav-header">Header 1.1.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a><span>Link</span></a></li>
                                            <li><a><span>Link</span></a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><label class="tree-toggler nav-header">Header 2</label>
                        <ul class="nav nav-list tree">
                            <li><a><span>Link</span></a></li>
                            <li><a><span>Link</span></a></li>
                            <li><label class="tree-toggler nav-header">Header 2.1</label>
                                <ul class="nav nav-list tree">
                                    <li><a><span>Link</span></a></li>
                                    <li><a><span>Link</span></a></li>
                                    <li><label class="tree-toggler nav-header">Header 2.1.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a><span>Link</span></a></li>
                                            <li><a><span>Link</span></a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><label class="tree-toggler nav-header">Header 2.2</label>
                                <ul class="nav nav-list tree">
                                    <li><a><span>Link</span></a></li>
                                    <li><a><span>Link</span></a></li>
                                    <li><label class="tree-toggler nav-header">Header 2.2.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a><span>Link</span><input type="hidden" value="58"/></a></li>
                                            <li><a><span>Link</span><input type="hidden" value="58"/></a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        -->


        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Launch demo modal</button>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">请选择分类</h4>
                    </div>
                    <div class="modal-body">
                        
                        <div class="well" style="width:400px; margin: auto; padding: 0px;">

                            <div style="overflow-y: scroll; overflow-x: hidden; height: 300px;">

                        <ul class="nav nav-list">
                            <li><label class="tree-toggler nav-header">Header 1</label>
                                <ul class="nav nav-list tree">
                                    <li><a><span>Link</span></a></li>
                                    <li><a><span>Link</span></a></li>
                                    <li><label class="tree-toggler nav-header">Header 1.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a><span>Link</span></a></li>
                                            <li><a><span>Link</span></a></li>
                                            <li><label class="tree-toggler nav-header">Header 1.1.1</label>
                                                <ul class="nav nav-list tree">
                                                    <li><a><span>Link</span></a></li>
                                                    <li><a><span>Link</span></a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li><label class="tree-toggler nav-header">Header 2</label>
                                <ul class="nav nav-list tree">
                                    <li><a><span>Link</span></a></li>
                                    <li><a><span>Link</span></a></li>
                                    <li><label class="tree-toggler nav-header">Header 2.1</label>
                                        <ul class="nav nav-list tree">
                                            <li><a><span>Link</span></a></li>
                                            <li><a><span>Link</span></a></li>
                                            <li><label class="tree-toggler nav-header">Header 2.1.1</label>
                                                <ul class="nav nav-list tree">
                                                    <li><a><span>Link</span></a></li>
                                                    <li><a><span>Link</span></a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><label class="tree-toggler nav-header">Header 2.2</label>
                                        <ul class="nav nav-list tree">
                                            <li><a><span>Link</span></a></li>
                                            <li><a><span>Link</span></a></li>
                                            <li><label class="tree-toggler nav-header">Header 2.2.1</label>
                                                <ul class="nav nav-list tree">
                                                    <li><a><span>Link</span><input type="hidden" value="58"/></a></li>
                                                    <li><a><span>Link</span><input type="hidden" value="58"/></a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>

                            </div>

                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
 
    </div>


	<!-- scripts -->
    <script src="lib/jquery-1.10.2.min.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/theme.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $('label.tree-toggler').click(function () {
                $(this).parent().children('ul.tree').toggle(300);
            });

            $('ul > li > a').click(function () {
                var children = $(this);

                $('ul > li > a > span').removeClass("badge").removeClass("badge-success");

                var span = children.find("span").first();
                span.addClass("badge").addClass("badge-success");
                
                // var input = children.find("input").first();
                // console.log(input.val());
            });

        });
    </script>
</body>
</html>