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
    <link href="css/commodity/create.css" rel="stylesheet">

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
        
        
        <div id="pad-wrapper" class="new-commodity">
            <div class="row header">
                <div class="col-md-12">
                    <h3>创建新商品</h3>
                </div>                
            </div>

            <div class="row form-wrapper">
                <!-- left column -->
                <div class="col-md-9 with-sidebar">
                    <div class="container">
                        <form id="new-commodity-form" class="new_user_form" action="commodity" method="POST">
                            <div class="col-md-12 field-box">
                                <label>商品名称:</label>
                                <input class="form-control" name="name" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>商品摘要:</label>
                                <input class="form-control" name="description" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>所属分类:</label>
                                <div class="input-group">
                                    <input type="hidden" name="categoryId" value="0" />
                                    <input class="form-control" name="categoryName" type="text" value="请选择.." disabled />
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#categorySelector">选择</button>
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>会员价:</label>
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input type="text" name="price" class="form-control" onkeyup="value=this.value.replace(/[^0-9|.]+/g,'')" />
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>参考价:</label>
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input type="text" name="originalPrice" class="form-control" onkeyup="value=this.value.replace(/[^0-9|.]+/g,'')" />
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>上传图片:</label>
                                <div class="input-group">
                                    <span class="btn btn-success fileinput-button">
                                        <i class="glyphicon glyphicon-plus"></i>
                                        <span>Add files...</span>
                                        <input id="fileupload" type="file" name="files[]" data-url="common/upload" multiple>
                                    </span>
                                </div>
                            </div>

                            <div class="col-md-12 field-box">

                                <div id="progress" class="progress">
                                    <div class="progress-bar progress-bar-success bar"></div>
                                </div>

                                <div>
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


                            <div class="col-md-11 field-box actions">
                                <input type="button" class="btn-glow primary" id="createCommodity-btn" value="创建">
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

            <div class="modal fade" id="categorySelector" tabindex="-1" role="dialog" aria-labelledby="categoryLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="categoryLabel">请选择分类</h4>
                        </div>
                        <div class="modal-body">
                            
                            <div class="well" style="width:400px; margin: auto; padding: 0px;">

                                <div style="overflow-y: scroll; overflow-x: hidden; height: 300px;">

                                    <ul class="nav nav-list">
                                        <c:import url="../category/recursive.jsp"></c:import>
                                    </ul>


<!--
                            <ul class="nav nav-list">
                                <li>
                                    <label class="tree-toggler nav-header">Header 1</label>
                                    <ul class="nav nav-list tree">
                                        <li><a><span>Link1</span><input type="hidden" value="1"/></a></li>
                                        <li><a><span>Link2</span><input type="hidden" value="2"/></a></li>
                                        <li><label class="tree-toggler nav-header">Header 1.1</label>
                                            <ul class="nav nav-list tree">
                                                <li><a><span>Link3</span><input type="hidden" value="3"/></a></li>
                                                <li><a><span>Link4</span><input type="hidden" value="4"/></a></li>
                                                <li><label class="tree-toggler nav-header">Header 1.1.1</label>
                                                    <ul class="nav nav-list tree">
                                                        <li><a><span>Link5</span><input type="hidden" value="5"/></a></li>
                                                        <li><a><span>Link6</span><input type="hidden" value="6"/></a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><label class="tree-toggler nav-header">Header 2</label>
                                    <ul class="nav nav-list tree">
                                        <li><a><span>Link7</span><input type="hidden" value="7"/></a></li>
                                        <li><a><span>Link8</span><input type="hidden" value="8"/></a></li>
                                        <li><label class="tree-toggler nav-header">Header 2.1</label>
                                            <ul class="nav nav-list tree">
                                                <li><a><span>Link9</span><input type="hidden" value="9"/></a></li>
                                                <li><a><span>Link10</span><input type="hidden" value="10"/></a></li>
                                                <li><label class="tree-toggler nav-header">Header 2.1.1</label>
                                                    <ul class="nav nav-list tree">
                                                        <li><a><span>Link11</span><input type="hidden" value="11"/></a></li>
                                                        <li><a><span>Link12</span><input type="hidden" value="12"/></a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><label class="tree-toggler nav-header">Header 2.2</label>
                                            <ul class="nav nav-list tree">
                                                <li><a><span>Link13</span><input type="hidden" value="13"/></a></li>
                                                <li><a><span>Link14</span><input type="hidden" value="14"/></a></li>
                                                <li><label class="tree-toggler nav-header">Header 2.2.1</label>
                                                    <ul class="nav nav-list tree">
                                                        <li><a><span>Link15</span><input type="hidden" value="15"/></a></li>
                                                        <li><a><span>Link16</span><input type="hidden" value="16"/></a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
-->
                                </div>

                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="categoryConfirm-btn">Save changes</button>
                        </div>
                    </div>
                </div>
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
    <script src="lib/utils.js"></script>

    <script type="text/javascript">


        $(document).ready(function(){

            $('label.tree-toggler').click(function () {
                $(this).parent().children('ul.tree').toggle(300);
            });

            $('#categorySelector').find('ul > li > a').click(function () {
                var children = $(this);

                $('#categorySelector').find('ul > li > a > span').removeClass("badge").removeClass("badge-success");

                var span = children.find("span").first();
                span.addClass("badge").addClass("badge-success");
                
            });

            $('#categoryConfirm-btn').click(function() {
                
                var categorySelected = $('ul > li > a .badge-success');
                var categoryName = categorySelected.text();
                var categoryId = categorySelected.parent().find("input").first().val();

                $('input[name=categoryName]').val(categoryName);
                $('input[name=categoryId]').val(categoryId);

                $('#categorySelector').modal('hide');
            });

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
                                .append($('<td/>').html("<span class='preview'><img src=" + file.fileThumbUrl + "></span><input type='hidden' name='fileNames[]' value=" + file.fileThumbUrl + " />"))
                        )
                    });
                },
         
                progressall: function (e, data) {
                    var progress = parseInt(data.loaded / data.total * 100, 10);
                    $('#progress .bar').css('width', progress + '%');
                },
         
            });

            $('#createCommodity-btn').click(createCommodiySubmit);


        });


        function createCommodiySubmit() {
            var name = $("input[name=name]").val() || '';
            var description = $("input[name=description]").val() || '';
            var categoryId = $('input[name=categoryId]').val() || '';
            var price = $("input[name=price]").val() || '';
            var originalPrice = $("input[name=originalPrice]").val() || '';

            
            var fileNames = "";
            var items = $("input[name='fileNames[]']");
            items.each(function(index, element) {
                fileNames = (fileNames + element.value) + (((index + 1)== items.length) ? '':','); 

            });

            if (!isNotBlank(name) || !isNotBlank(description) || !isNotBlank(categoryId) || !isNotBlank(price) || !isNotBlank(originalPrice) || !isNotBlank(fileNames)) {
                alert("请将商品信息补充完整！");
                return;
            }

            if ( !isMoney(price) ) {
                alert("会员价格式为10.00！");
                return;
            }

            if ( !isMoney(originalPrice) ) {
                alert("参考价格式为10.00！");
                return;
            }


            var url = $("#new-commodity-form").attr('action') || '';
            var method = $("#new-commodity-form").attr('method') || '';




            $.ajax({
                type: method,
                url: url,
                dataType: 'json',
                data: {name: name, description: description, categoryId: categoryId, price: price, originalPrice: originalPrice, fileNames: fileNames},
                success: function(data, textStatus, jqXHR){
                    console.log(data.statusInfo);
                    alert(data.statusInfo);
                }
            });

        }
    </script>
</body>
</html>