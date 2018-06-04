<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>

<title>用户个人信息</title>

<!-- Meta-Tags -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //Meta-Tags -->

<!-- Style -->
<link rel="stylesheet" href="/ch_DreamMarket/css/style3.css" type="text/css" media="all">

<script type="text/javascript">
	function confirmdelete() {
		var se = confirm("确认删除信息吗？");
		if (se == true) {
			alert("信息已删除");
		}
	}
</script>
<link href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">


</head>
<!-- //Head -->

<!-- Body -->
<body>

	<h1>您的管理账户信息信息</h1>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>个人信息</h2>
			<form action="#" method="post">
				<div>
					<input id="username" name="username" value="用户名：maoji140450734" type="text" / readonly>
				</div>

				<div>
					<input id="pass" name="password" value="密码： maoji123456" type="password" / readonly>
				</div>
				<div>
					<input id="email" name="email" value="邮箱：myemail@163.com" type="text" / readonly>
				</div>
				<div>
					<input name="date" value="出生年月：02/24/1995" class="datepicker" data-ideal="date" type="text"
						placeholder="月/日/年" / readonly>
				</div>
				<div>
					<input type="text" name="phone" value="电话：182-7087-0609" readonly />
				</div>
				<div>
					<input name="website" value="个人主页：mydream@163.com" type="text" / readonly>
				</div>
				<div>
					<input name="country" value="国籍：中国" type="text" / readonly>
				</div>
			</form>

			<div class="send-button w3layouts agileits">
				<form method="post" action="/ch_DreamMarket/admin/managePage.action">
					<input type="submit" value="进入后台管理页面">
				</form>

			</div>
			<div class="send-button w3layouts agileits">
				<form method="post" action="index.html">
					<input type="submit" onclick="confirmdelete()" value="注销账户">

				</form>
			</div>
			<a href="#">忘记密码？</a>
			<div class="social-icons w3layouts agileits">
				<p>- 用以下账号登录 -</p>
				<ul>
					<li><a href="#">
							<span class="icons w3layouts agileits"></span><span class="text w3layouts agileits">微信</span>
						</a></li>
					<li class="twt w3ls"><a href="#">
							<span class="icons w3layouts"></span><span class="text w3layouts agileits">腾讯qq</span>
						</a></li>
					<li class="ggp aits"><a href="#">
							<span class="icons agileits"></span><span class="text w3layouts agileits">新浪微博</span>
						</a></li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="clear"></div>
		</div>

		<div class="register w3layouts agileits">
			<h2>个人头像</h2>
			<form action="#" method="post">
				<div>
					<img src="/ch_DreamMarket/images/my.jpg" width="300" height="400">
				</div>
			</form>

			<div class="clear"></div>
		</div>

		<div class="clear"></div>

	</div>

	<div class="footer w3layouts agileits">
		<p>©2018 DreamMarket, All Right reserved</p>
	</div>

</body>

<!-- //Body -->

</html>