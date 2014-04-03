<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<li>
    <c:choose>
        <c:when test="${not empty categoryTree.children}">
            <label class="tree-toggler nav-header">${categoryTree.category.name}</label>
            <ul class="nav nav-list tree">
                <c:forEach var="element" items="${categoryTree.children}">
                    <c:set var="categoryTree" value="${element}" scope="request"/>
                    <c:import url="../category/recursive.jsp"></c:import>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <a><span>${categoryTree.category.name}</span><input type="hidden" value="${categoryTree.category.id}"/></a>
        </c:otherwise>
    </c:choose>
</li>