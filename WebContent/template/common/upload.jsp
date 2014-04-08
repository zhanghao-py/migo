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
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet">

    <link href="css/lib/jquery.fileupload.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="css/compiled/icons.css">

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css">
    
    <!-- this page specific styles -->   

    <!--
    <style type="text/css">

        #dropzone {
            background: #ccccc;
            width: 150px;
            height: 50px;
            line-height: 50px;
            text-align: center;
            font-weight: bold;
        }
        #dropzone.in {
            width: 600px;
            height: 200px;
            line-height: 200px;
            font-size: larger;
        }
        #dropzone.hover {
            background: lawngreen;
        }
        #dropzone.fade {
            -webkit-transition: all 0.3s ease-out;
            -moz-transition: all 0.3s ease-out;
            -ms-transition: all 0.3s ease-out;
            -o-transition: all 0.3s ease-out;
            transition: all 0.3s ease-out;
            opacity: 1;
        }

    </style>
    -->

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

        <div id="pad-wrapper">


            <div class="row">

                <div style="margin-bottom:20px;">

                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Add files...</span>
                    <!-- The file input field used as target for the file upload widget -->
                    <input id="fileupload" type="file" name="files[]" data-url="common/upload" multiple>
                </span>

                </div>

            </div>
     
            <!--
            <div id="dropzone">Drop files here</div>
            -->
         
            <div class="row">
                <div id="progress" class="progress">
                    <div class="progress-bar progress-bar-success bar"></div>
                </div>
            </div>


            <div class="row">
                <table class="table table-hover" id="uploaded-files">
                    <thead>
                        <tr>
                            <th class="col-md-3">
                                File Name
                            </th>
                            <th class="col-md-3">
                                <span class="line"></span>File Size
                            </th>
                            <th class="col-md-3">
                                <span class="line"></span>File Type
                            </th>
                            <th class="col-md-3">
                                <span class="line"></span>Download
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- row -->
                    </tbody>
                </table>
            </div>

        </div>

    </div>
    <!-- end main container -->

	<!-- scripts -->
    <script src="lib/jquery-1.10.2.min.js"></script>
    <script src="lib/jquery.ui.widget.js"></script>
    <script src="lib/jquery.iframe-transport.js"></script>
    <script src="lib/jquery.fileupload.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/theme.js"></script>

    <script type="text/javascript">


        $(document).ready(function(){


            $('#fileupload').fileupload({
                dataType: 'json',
                acceptFileTypes: /(\.|\/)(gif|jpe?g|png)$/i,
                maxFileSize: 5000000, // 5 MB
         
                done: function (e, data) {
                    
                    $("tr:has(td)").remove();

                    $.each(data.result, function (index, file) {
         
                        $("#uploaded-files tbody").append(
                            $('<tr/>')
                                .append($('<td/>').text(file.fileName))
                                .append($('<td/>').text(file.fileSize))
                                .append($('<td/>').text(file.fileType))
                                .append($('<td/>').html("<span class='preview'><img src='file.thumbnailUrl'></span>"))
                        )
                    });
                },
         
                progressall: function (e, data) {
                    var progress = parseInt(data.loaded / data.total * 100, 10);
                    $('#progress .bar').css('width', progress + '%');
                },
         
            });


        });
    </script>
</body>
</html>