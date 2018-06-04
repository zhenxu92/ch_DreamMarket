<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>后台登录</title>
<meta name="author" content="MmmJ" />
<link rel="stylesheet" type="text/css" href="/ch_DreamMarket/css/style6.css" />
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="/ch_DreamMarket/js/jquery.js"></script>
<script src="/ch_DreamMarket/js/verificationNumbers.js"></script>
<script src="/ch_DreamMarket/js/Particleground.js"></script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
		//验证码
		createCode();
		//测试提交，对接程序删除即可
		$(".submit_btn").click(function() {
			location.href = "index.html";
		});
	});
</script>
</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>售后管理</strong> <em>after-sale Management System</em>
		</dt>
		<dd class="user_icon">
			<input type="text" placeholder="账号" class="login_txtbx" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" placeholder="密码" class="login_txtbx" />
		</dd>
		<dd class="val_icon">
			<div class="checkcode">
				<input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
				<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
			</div>
			<input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
		</dd>
		<dd>
			<input type="button" value="立即登录" class="submit_btn" />
		</dd>
		<dd>
			<p>© ch_DreamMarket 版权所有</p>
			<p>made by MmmJ</p>
		</dd>
	</dl>
</body>
</html>
