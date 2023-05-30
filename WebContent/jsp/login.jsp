<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 //送信されたデータを取得する
 String login_status = "initial";
 String fail = "fail";
 String regist_success = "regist_success";
try{
	if(!(request.getParameter("status")==null)){
	login_status = request.getParameter("status");
	}
}catch(Exception e){}


if(login_status.equals(logout)){
	//セッション削除の動作を記述
	//session.getAttribute("authentication_key");
	//session.getAttribute("password");
	
	//jsp上でのセッション削除のやり方がわからなかったのでセッション削除はできていないです。
}
%>
<%@include file="../../authentication.jsp"%>
<%@include file="../header.html"%>
	<container>
	<h2>ログイン画面</h2>
		<%if(login_status.equals(fail)){ %>
	<p style="color:red;">ログインIDまたはパスワードが間違っています。</p>
	<%}else if(login_status.equals(regist_success)) {%>
	<p style="color:green;">登録が完了しました。<br>登録したパスワードでログインしてください</p>
	<%} %>

	<form action="../jp.co.aforce.userlogin/Login" method="post">
		<p>
			<input type="text" name="user_name" placeholder="メールアドレス"
			<%if(request.getParameter("login_id") != null){%>
			value="<%=request.getParameter("login_id") %>"
			<% }else if(session_username != null){%>
			value="<%=session_username %>"
			<%} %>
			>
		</p>
		<p>
			<input type="password" name="password" placeholder="パスワード"
			<% if(session_password != null){%>
			value="<%=session_password %>"
			<%} %>
			>
		</p>
		<div class="button"><input id="resist"  type="submit" value="ログイン"></div>
		<p><a href="register.jsp">会員登録が済んでいない人はこちら</a></p>
	</form>
	</container>
<%@include file="../footer.html"%>

