<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {display:none;}
</style>



 <style>
* {
    box-sizing: border-box;
}

body {
    font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
    background-color: #666;
    padding: 30px;
    text-align: center;
    font-size: 35px;
    color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
    float: left;
    width: 30%;
    height: 300px; /* only for demonstration, should be removed */
    background: #ccc;
    padding: 20px;
}

/* Style the list inside the menu */
nav ul {
    list-style-type: none;
    padding: 0;
}

article {
    float: left;
    padding: 20px;
    width: 70%;
    background-color: #f1f1f1;
    height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
    content: "";
    display: table;
    clear: both;
}

/* Style the footer */
footer {
    background-color: #777;
    padding: 10px;
    text-align: center;
    color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
    nav, article {
        width: 100%;
        height: auto;
    }
    .form__element {
    margin: 0 0 1em 0;
}

.form__label {
    font-size: 1.2em;
    display: block;
    margin: 0 0 0.4em 0;
}

.form__input {
    width: 100%;
    padding: 0.6em;
    font-size: 1.3em;
}

.form__required {
    float: right;
    font-size: 0.8em;
    background: #ddd;
    padding: 0.3em;
}

.form__hint {
    margin: 0;
    font-size: 1.1em;
}

.form__hint:before {
    content: "\1F6C8";
    font-size: 1.2em;
    margin: 0 0.2em 0 0;
}

.form__submit {
    background: #326f10;
    color: #fff;
    border: none;
    padding: 0.6em;
    font-size: 1.4em;
    float: right;
}
}








</style>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	
<link rel="stylesheet" href="bootstrap/fontawesome/css/all.min.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<!--Custom styles-->
	<link href= "bootstrap/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
 

<h2 class="w3-center"><b>AMAZON</b></h2>
</header>

<div class="w3-content w3-display-container">

  <img class="mySlides" src="images/1.jpg" style="width:100%">
  <img class="mySlides" src="images/2.jpg" style="width:100%">
  <img class="mySlides" src="images/3.jpg" style="width:100%">
  <img class="mySlides" src="images/4.jpg" style="width:100%">
  <img class="mySlides" src="images/5.jpg" style="width:100%">
  <img class="mySlides" src="images/6.jpg" style="width:100%">
   <img class="mySlides" src="images/8.jpg" style="width:100%">

     <img class="mySlides" src="images/10.jpg" style="width:100%">
   
  

  <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
</div>


<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}


</script>





<form action="LoginServlet" method="post" onSubmit="return validate()">
<section>





    






<body background="images/loginImage.jpg">
 <div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h4>AMAZON Customer Login Page</h4>
				<p style="color: red; font-size: 15px"><%
   					 if(null!=request.getAttribute("error"))
    					{
        						out.println(request.getAttribute("error"));
   						 }
				%></p>
			</div>
			<div class="card-body" >
			
				
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="User Name" name="username" required>
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password" name="password" id="mypwd" aria-describedby="passwordHint"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
					       
					</div>
					
					
					<div><p class="form__hint" id="passwordHint">The password must be at least 8 characters long.</p></div>
					<div id="error-nwl"></div>

                     
					
					
           
           
        
					<div class="row align-items-center remember">
						
						<input type="checkbox" onclick="myShowPasswordFunction()">Show Password
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn float-right login_btn">
					</div>
					
				
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="register.jsp" class="a-links">Sign Up</a>
				</div>
				
				
			</div>
		</div>
	</div>
</div>


<article>
   
  
<div class="div2" style="background-color:aqua; color:white;padding:120px;" >
<h1><b>New to Amazon? <br>Sign up for best experiences</b></h1>
   
<input type= "button" value ="SignUp" name= "button1" onclick="window.location.href='register.jsp'">

</div>

</article>
</section>
<div>
<footer>
<img src = "images/admin.jpg" alt = "Administrator" style = "width:100px;">
<input type= "button" value ="Administrator" name= "button2" onclick="window.location.href='adminlogin.jsp'">
</footer>
</div>
</form>




<script type ="text/javascript" src="bootstrap/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type ="text/javascript" src="bootstrap/js/jquery.validate.min.js"></script>
<script>
function validate() {
	
if (document.forms[0].name.value=="") {
alert("Please Enter your  Username and Password !");
return false;
}
return true;
}

function myShowPasswordFunction() {
    var x = document.getElementById("mypwd");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
 </script>

</body>
</html>