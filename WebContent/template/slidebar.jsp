<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

    <!-- sidebar -->
    <div id="sidebar-nav">
        <ul id="dashboard-menu">
            <li>
                <!--
                <div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
                -->
                <a href="index">
                    <i class="icon-home"></i>
                    <span>首页</span>
                </a>
            </li>            
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-group"></i>
                    <span>用户管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="account/user/list">用户列表</a></li>
                    <li><a href="account/user/create">添加用户</a></li>
                    <li><a href="account/shop/list">商铺列表</a></li>
                    <li><a href="account/shop/create">添加商铺</a></li>
                    <li><a href="account/market/list">商场列表</a></li>
                    <li><a href="account/market/create">添加商场</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-edit"></i>
                    <span>商品管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="commodity/create">添加商品</a></li>
                    <li><a href="commodity/list">商品列表</a></li>
                </ul>
            </li>
            <!--
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-th-large"></i>
                    <span>分类管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="category/list">分类列表</a></li>
                </ul>
            </li>
            -->
        </ul>
    </div>
    <!-- end sidebar -->