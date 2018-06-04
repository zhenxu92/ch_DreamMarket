<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>Register</title>
<link rel="stylesheet" href="/ch_DreamMarket/css/pintuer.css">
<link rel="stylesheet" href="/ch_DreamMarket/css/admin.css">
<script src="/ch_DreamMarket/js/jquery.js"></script>
<script src="/ch_DreamMarket/js/pintuer.js"></script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<s:form action="/market/registerAction.action" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<font size=6 color="white">Register</font>
						</div>
						<div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="bemail" placeholder="Username"
										data-validate="required:please enter username" />
									<span class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="bpwd" placeholder="Password"
										data-validate="required:Please enter password" />
									<span class="icon icon-key margin-small"></span>
								</div>
							</div>
						</div>
						<div style="padding:30px;">
							<input type="submit" class="button button-block bg-main text-big input-big" value="Sign Up">
						</div>
						<div style="padding:30px;">
							<input type="reset" class="button button-block bg-main text-big input-big" value="Clear">
						</div>
						<div style="padding:30px;">
							<input type="button" class="button button-block bg-main text-big input-big"
								onclick="window.location.href='/ch_DreamMarket/market/indexPage.action'" value="Home">
						</div>
					</div>
				</s:form>
			</div>
		</div>
	</div>

</body>
</html>