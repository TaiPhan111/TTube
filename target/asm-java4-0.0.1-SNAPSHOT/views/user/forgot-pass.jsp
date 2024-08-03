<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot PassWord</title>
    <%@ include file="/common/head.jsp"%>
  	


</head>
<body>
	<%@ include file="/common/header.jsp"%>
    <div class="container-fluid tm-mt-60">
        <div class="row tm-mb-50">
            <div class="col-lg-12 col-12 mb-5">
               <center> <h2 class="tm-text-primary mb-5" >Forgot PassWord</h2></center>
                <form id="login-form" action="login" method="POST" class="tm-contact-form mx-auto">
                    <div class="form-group">
                        <input type="email" id="email" name="email" class="form-control rounded-0" placeholder="Email" required />
                    </div>
                   
                    <div class="form-group tm-text-right">
                       <center> <button type="submit" class="btn btn-primary" id="sendBtn">Send</button></center>
                    </div>
                    <h5 style="color: red" id="messageReturn"> </h5>
                </form>                
            </div>
    </div> 
 	<%@ include file="/common/footer.jsp"%>
</body>
<script>
	$('#sendBtn').click(function(){
		$('#messageReturn').text('');
		var email = $('#email').val();
		var formData= {'email': email};
		$.ajax({
			url:'forgotPass',
			type: 'POST',
			data: formData
		}).then(function(data){
			$('#messageReturn').text('Password has been reset, please check your email');
			setTimeout(function(){
				window.location.href = 'http://localhost:8080/asm-java4/index';
			},5*1000);
		}).fail(function(error){
			$('#messageReturn').text('Your information is not corect, tuy again');
		});
	});
</script>
</html>