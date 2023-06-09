<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jp.co.aforce.bean.Product"%>
<%-- 画面遷移先のURLを入力 --%>
<%-- String url_name = "http://localhost:8080/Login/jsp/individual_page.jsp"; --%>
<% String url_name = "/Login/jsp/individual1.jsp"; %>
<% Product p = (Product) request.getAttribute("product");%>
<%@include file="../../authentication.jsp"%>
<%@include file="../../header.html"%>
<%@include file="../../logout.jsp"%>

<container>
<div>
	<h2>TOP PAGE</h2>
	<p>
		ようこそ<%=session_username%>さん！
	</p>
	<p>↓あなたのセッション情報↓</p>
	<p>名前：<%=session_username%></p>
	<p>パスワード：<%=session_password %></p>

	<p><a href=<%=url_name %>>個別ページ1</a></p>
	<p><a href="#">個別ページ2</a></p>
	<p><a href="#">個別ページ3</a></p>
</div>
</container>
<%@include file="../footer.html"%>