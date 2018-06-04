<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Login</title>
<meta name="renderer" content="webkit">
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<link rel="stylesheet" href="/ch_DreamMarket/css/bootstrap.min.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/style.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/login.css" />
<link rel="stylesheet" href="/ch_DreamMarket/css/datetimepicker/bootstrap-datetimepicker.min.css"
	media="screen" />
<script>
	function login(){
		if(window.navigator.onLine==true) {
			var cip = returnCitySN['cip'];
			var action = "/ch_DreamMarket/market/loginAction.action?ip="+cip; 
			document.getElementById("user").action=action;
			document.getElementById("user").submit();
		}else{
			alert("You are not connected to internet.");
		}
	}	
</script>
</head>
<body>
	<!-- Top Begin -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
<!-- 		put some nav here -->
		</div>
	</div>
	<!-- Top End -->
	<!-- Body Begin -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-6" align="right">
				<img src="/ch_DreamMarket/images/Logo2.gif" width=450 height=267>
			</div>
			<div class="col-md-2" align="center"></div>
			<div class="col-md-4" align="left">
				<s:form action="/market/loginAction.action" method="post" id="user">
					<div class="panel panel-default panel-body">
						<div class="form-group text-left">
							<label>Username</label>
							<div>
								<input type="text" id="bemail" name="bemail" class="form-control" required="required" />
							</div>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" id="bpwd" name="bpwd" class="form-control" required="required" />
						</div>
						<div class="form-group">
							<button onclick="login();" class="btn btn-primary btn-block">Login</button>
							<input type="button" class="btn btn-primary btn-block" value="Sign Up"
								onclick="window.location.href='/ch_DreamMarket/market/registerPage.action'">
							<button type="reset" class="btn btn-primary btn-block">Cancel</button>
						</div>
					</div>
				</s:form>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



	<script type="text/javascript" src="/ch_DreamMarket/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/ch_DreamMarket/js/datetimepicker/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>
	<script type="text/javascript"
		src="/ch_DreamMarket/js/datetimepicker/locales/bootstrap-datetimepicker.ja.js" charset="UTF-8"></script>

</body>
</html>