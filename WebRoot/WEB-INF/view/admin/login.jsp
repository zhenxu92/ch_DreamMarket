<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>

<html>

<head>

<meta charset="UTF-8">

<title>中国好商城</title>



<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet" href="/ch_DreamMarket/css/reset.css">
<link rel="stylesheet" href="/ch_DreamMarket/css/supersized.css">
<link rel="stylesheet" href="/ch_DreamMarket/css/style2.css">

</head>
<body>

	<div class="page-container">
		<h1>登录管理员账户！</h1>
		<s:form action="/admin/loginAction.action" method="post">
			<s:textfield name="aname" id="aname" cssClass="username" placeholder="请输入您的用户名！" />
			<s:password name="apwd" id="apwd" cssClass="password" placeholder="请输入您的用户密码！" />
			<button type="submit" class="submit_button">登录</button>
			<button type="reset" class="submit_button"
				onclick="javascrtpt:window.location.href='register.html'">注册</button>
			<button type="reset" class="submit_button">重置</button>
			<div class="error">
				<span>+</span>
			</div>
		</s:form>
	</div>

	<!-- Javascript -->
	<script src="/ch_DreamMarket/js/jquery-1.8.2.min.js"></script>
	<script src="/ch_DreamMarket/js/supersized.3.2.7.min.js"></script>
	<script src="/ch_DreamMarket/js/supersized-init.js"></script>
	<script src="/ch_DreamMarket/js/scripts.js"></script>

</body>
<div style="text-align:center;"></div>
</html>

