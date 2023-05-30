<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jp.co.aforce.bean.Product"%>
<%@include file="../header.html"%>
<%
Product p = (Product) request.getAttribute("product");
%>
<%@include file="../../logout.jsp"%>
<container>
<div>
	<h2>個別ページ1</h2>
	<p>
		ようこそあなたの個別ページ1です。
	</p>
</container>
<%@include file="../footer.html"%>