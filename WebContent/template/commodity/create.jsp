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

    <link href="lib/google-code-prettify/prettify.css" rel="stylesheet">
	
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
                        <form class="new_user_form">
                            <div class="col-md-12 field-box">
                                <label>商品名称:</label>
                                <input class="form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>商品摘要:</label>
                                <input class="form-control" type="text" />
                            </div>
                            <div class="col-md-12 field-box">
                                <label>所属分类:</label>
                                <div class="input-group">
                                    <input type="hidden" name="categoryId" value="0" />
                                    <input class="form-control" name="categoryName" type="text" value="请选择.." disabled>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#categorySelector">选择</button>
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>会员价:</label>
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>参考价:</label>
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="col-md-12 field-box textarea">
                                <label>详细信息:</label>
                                <div class="input-group">
                                    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
                                        <div class="btn-group">
                                            <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
                                            <ul class="dropdown-menu">
                                            </ul>
                                        </div>

                                        <div class="btn-group">
                                            <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
                                            <ul class="dropdown-menu">
                                                <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
                                                <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
                                                <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
                                            </ul>
                                        </div>

                                        <div class="btn-group">
                                            <a class="btn btn-default" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
                                            <a class="btn btn-default" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
                                            <a class="btn btn-default" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
                                            <a class="btn btn-default" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
                                        </div>

                                        <div class="btn-group">
                                            <a class="btn btn-default" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
                                            <a class="btn btn-default" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
                                            <a class="btn btn-default" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
                                            <a class="btn btn-default" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
                                        </div>


                                        <!--
                                        <div class="btn-group">
                                            <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="icon-link"></i></a>
                                            <div class="dropdown-menu input-append">
                                                <input class="span2" placeholder="URL" type="text" data-edit="createLink"/>
                                                <button class="btn btn-default" type="button">Add</button>
                                            </div>
                                            <a class="btn btn-default" data-edit="unlink" title="Remove Hyperlink"><i class="icon-cut"></i></a>
                                        </div>
                                        -->
                                                      
                                        <div class="btn-group">
                                            <a class="btn btn-default" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="icon-picture"></i></a>
                                            <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
                                        </div>

                                    </div>

                                    <div id="editor">
                                        Go ahead&hellip;
                                    </div>
                                    <span class="charactersleft">90 characters remaining. Field limited to 100 characters</span>
                                </div>
                                <!--
                                <textarea class="col-md-9"></textarea>
                                <span class="charactersleft">90 characters remaining. Field limited to 100 characters</span>
                                -->
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
                                <li><label class="tree-toggler nav-header">Header 1</label>
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
    <script src="lib/jquery.hotkeys.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/google-code-prettify/prettify.js"></script>
    <script src="lib/bootstrap-wysiwyg.js"></script>
    <script src="lib/theme.js"></script>

    <script type="text/javascript">
        function initToolbarBootstrapBindings() {
          var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
                'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                'Times New Roman', 'Verdana'],
                fontTarget = $('[title=Font]').siblings('.dropdown-menu');
          $.each(fonts, function (idx, fontName) {
              fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
          });
          $('a[title]').tooltip({container:'body'});
            $('.dropdown-menu input').click(function() {return false;})
                .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
            .keydown('esc', function () {this.value='';$(this).change();});

          $('[data-role=magic-overlay]').each(function () { 
            var overlay = $(this), target = $(overlay.data('target')); 
            overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
          });
        };

        function showErrorAlert (reason, detail) {
            var msg='';
            if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
            else {
                console.log("error uploading file", reason, detail);
            }
            $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
             '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
        };

        $(document).ready(function(){

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

            initToolbarBootstrapBindings();

            $('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
            window.prettyPrint && prettyPrint();

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

            $("#categoryConfirm-btn").click(function() {
                
                var categorySelected = $('ul > li > a .badge-success');
                var categoryName = categorySelected.text();
                var categoryId = categorySelected.parent().find("input").first().val();
                
                console.log(categoryName + "," + categoryId);

                $('input[name=categoryName]').val(categoryName);
                $('input[name=categoryId]').val(categoryId);

                $('#categorySelector').modal('hide');
            });
        });
    </script>
</body>
</html>