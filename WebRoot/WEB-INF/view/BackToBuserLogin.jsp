<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<script>
			function getout(url) {
				if(confirm('You are not logged in, login now?')){
					window.location.href=url;
				}else{
					window.location.href="/ch_DreamMarket/market/homepage.action";
				}
			}
		</script>
	</head>
	<body onload="getout('/ch_DreamMarket/market/loginPage.action');">
	</body>
</html>