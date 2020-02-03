<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Join</title>
  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#emailChkBtn').click(function(){
		var email = $('#email').val();
		var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(!email.match(emailRule)){
			alert("▶ email형식에 맞지않습니다.");
		}else {
			alert(email);
			
			$.ajax({
				type:'post',
				url:'/join_ok.do',
				data:{email:email},
				success:function(res){
					alert("오니?");
					var count = res.trim();
					if(count > 0){
						alert("▶ 사용중인 이메일입니다.");
						$('#email').focus();
						return;
					}else if (count == 0){
						alert("▶ 사용가능한 email입니다.");
						$('#pwd').focus();
					}
				}
			});
		}
	});
	

	$('#finishJoinBtn').click(function(){
		var name = $('#name').val();
		var email = $('#email').val();
		var pwd = $('#pwd').val().trim();
		var repwd = $('#repwd').val().trim();
		var pwdRule = /[a-z]+[0-9]/; //영문소문자+숫자 조합
		
		if(name ==""){
			alert("성함 입력하세요.")
			$('#name').focus();
			return;
		}
		else if(email ==""){
			alert("email 입력하세요.")
			$('#email').focus();
			return;
		}
		else if(pwd ==""){
			alert("Password 입력하세요.")
			$('#pwd').focus();
			return;
		}
		else if(repwd ==""){
			alert("필수 입력 누락");
			$('#repwd').focus();
			return;
		}
		else if( !(pwd.length >= 6 && pwd.length <= 16 ) ){
			alert("6~16자로 입력하세요.");
			$('#pwd').focus();
			return;
		} 
		else if(!pwd.match(pwdRule)){
			alert("영문 소문자+숫자 조합으로 입력하세요.");
			$('#pwd').focus();
			return;
		} 
		else if(!pwd.match(repwd)){
			alert("동일하게 입력하세요.");
			$('#repwd').focus();
			return;
		}
		
		
 		$.ajax({
			type:'post',
			url:'/insert.do',
			data:{name:name,email:email,pwd:pwd},
			success:function(res){
				alert("회원가입완료되었습니다.");
				location.href="/main.do";
			}
		}); 
	});
	
	
});  
</script>
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
              </div>
              <form class="user">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="name" placeholder="성함을 입력해주세요. ">
                  </div>
                  <div class="col-sm-6">
                    <!-- <input type="button" class="form-control form-control-user" id="exampleLastName" value="Chk"> -->
                  </div>
                </div><div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="email" placeholder="Email을 입력해주세요. ">
                  </div>
                  <div class="col-sm-6">
                    <input type="button" class="form-control form-control-user" id="emailChkBtn" value="Chk">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <input type="password" class="form-control form-control-user" id="pwd" placeholder="Password 입력해주세요.">
                  </div>
                  <div class="col-sm-6">
                    <input type="password" class="form-control form-control-user" id="repwd" placeholder="다시 password 입력해주세요. ">
                  </div>
                </div>
                <input type=button class="btn btn-primary btn-user btn-block" id="finishJoinBtn" value="Finish JOIN ~!"/>
                
              </form>
              <hr>
                  <div class="text-center">
                    <a class="small" href="join.do">Are you Join?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="forgot-password.do">Forgot Password?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="register.html">Create an Account!</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="main.do">MainPage Let's GO!</a>
                  </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

</body>

</html>
