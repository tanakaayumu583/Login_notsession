<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<container>
<div>
	<h2>会員登録画面</h2>
	<form action="../jp.co.aforce.userlogin/Register" method="post">
		<p>ユーザIDを入力してください</p>
		<p>
			<input type="text" name="user_name">
		</p>
		<p>パスワードを入力してください</p>
		<p>
			<input type="text" name="password">
		</p>
		<div class="button"><input type="submit"  value="登録"></div>
	</form>
</div>
</container>
<%@include file="../footer.html"%>