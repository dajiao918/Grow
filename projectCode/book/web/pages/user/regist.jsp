<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>

	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	<script type="text/javascript">
		let testFun = function (string){
			let patt = /^\w{5,12}$/;
			if(patt.test(string)){
				return true;
			} else {
				return false;
			}
		}
		$(function (){
			$("#username").change(function (){
				$.getJSON("http://localhost:8080/book/userServlet","action=ajax&" + $("#username").serialize(),function (data){
					if (!data.existUser) {
						$(".errorMsg").text("用户名已存在");
					} else {
						$(".errorMsg").text("");
					}
				})
			})

			$("#sub_btn").click(function (){
				//验证用户名
				let patt = /^\w{5,12}$/;
				let usernameVal = $(":input:first").val();
				if(!testFun(usernameVal)){
					$(".errorMsg").text("用户名不合法");
					return false;
				}
				//验证密码
				let passwordVal = $("#password").val();
				if(!testFun(passwordVal)){
					$(".errorMsg").text("密码不合法");
					return false;
				}
				//重复密码
				let repwdVal = $("#repwd").val();
				if(!(repwdVal == passwordVal)){
					$(".errorMsg").text("密码不一致");
					return false;
				}
				//邮箱
				let emailVal = $("#email").val();
				let emailpatt = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if(!emailpatt.test(emailVal)){
					$(".errorMsg").text("邮箱不合法");
					return false;
				}
				//验证验证码
				let codeVal = $("#code").val();
				codeVal = $.trim(codeVal);
				if(codeVal == null || codeVal==""){
					$(".errorMsg").text("验证码为空");
					return false;
				}

				$(".errorMsg").text("");
			});

			$("#img_c1").click(function (){

				//JavaScript单击事件中会有一个this对象，这个对象是正在响应当前事件的dom对象，也就是代表了标签
				//this.src代表了此标签的路径，d=new Date()是为了让每次请求的参数都不一样，防止服务器缓存，每次都调用同一张图片
				this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			})

		});


	</script>
</head>
<body>
<div id="login_header">
	<img class="logo_img" alt="" src="static/img/logo.gif" >
</div>

<div class="login_banner">

	<div id="l_content">
		<span class="login_word">欢迎注册</span>
	</div>

	<div id="content">
		<div class="login_form">
			<div class="login_box">
				<div class="tit">
					<h1>注册尚硅谷会员</h1>
					<span class="errorMsg">
						${ requestScope.msg==null?"":requestScope.msg }
					</span>
				</div>
				<div class="form">
					<form action="userServlet" method="post">
						<input type="hidden" name="action" value="regist" />
						<label>用户名称：</label>
						<input class="itxt" type="text" placeholder="请输入用户名"
							   autocomplete="off" tabindex="1" name="username" id="username"
							   value="${ requestScope.username==null?"":requestScope.username }"/>
						<br />
						<br />
						<label>用户密码：</label>
						<input class="itxt" type="password" placeholder="请输入密码"
							   autocomplete="off" tabindex="1" name="password" id="password" />
						<br />
						<br />
						<label>确认密码：</label>
						<input class="itxt" type="password" placeholder="确认密码"
							   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
						<br />
						<br />
						<label>电子邮件：</label>
						<input class="itxt" type="text" placeholder="请输入邮箱地址"
							   autocomplete="off" tabindex="1" name="email" id="email"
							   value="${ requestScope.email==null?"":requestScope.email }"/>
						<br />
						<br />
						<label>验证码：</label>
						<input class="itxt" type="text" style="width: 100px;" name="code" id="code"/>
						<img alt="" id="img_c1" src="kaptcha.jpg" style="float: right; margin-right: 30px; width: 120px; height: 50px">
						<br />
						<br />
						<input type="submit" value="注册" id="sub_btn" />

					</form>
				</div>

			</div>
		</div>
	</div>
</div>

</body>
</html>