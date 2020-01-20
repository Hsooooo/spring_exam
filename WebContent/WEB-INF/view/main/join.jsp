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
	// 회원가입완료 버튼을 눌렀을 때 
	$('#finishJoinBtn').click(function(){
		var name = $('#name').val();
		var email = $('#email').val();
		var pwd = $('#pwd').val();
		var repwd = $('#repwd').val();
		if(name.trim()==""){
			alert("성함 입력하세요.")
			$('#name').focus();
		}
		else if(email.trim()==""){
			alert("email 입력하세요.")
			$('#email').focus();
		}
		else if(pwd.trim()==""){
			alert("Password 입력하세요.")
			$('#pwd').focus();
		}
		else if(repwd.trim()==""){
			alert("Password 중복체크 확인하세요.")
			$('#repwd').focus();
		}
		// email 중복체크 
		$.ajax({
			type:'post',
			url:'../main/join_ok.do',
			date:{email:email},
			success:function(res){
				
			}
		});
		
	});
	
});  
</script>
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Join!</h1>
                  </div>
                  <form class="user">
                  	<div class="form-group">
                      <input type="name" class="form-control form-control-user" id="name" name=name placeholder="성함을 입력해주세요. ">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" id="email"  aria-describedby="emailHelp" placeholder="귀하의 email 입력하세요.">
                      <font size="1px" id="pwdCondition"></font>
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" id="pwd" placeholder="사용 하실 Password 입력하세요.">
                      <font size="1px" id="pwdCondition"></font>
                    </div><div class="form-group">
                      <input type="password" class="form-control form-control-user" id="repwd" placeholder="다시 Password 입력하세요.">
                      <font size="1px" id="pwdCondition"></font>
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