<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>


<body>
<h1>User Registration Form</h1>
	<div class="ex"></div>
	<div class="container"></div>
<form  name="form" action="RegistrationServlet" method="post">
<section>

<table style="with: 100%">

<tr>

</tr>


<tr>
 

 
<tr><td><label for="userFullName"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="userFullName" required></td></tr>

 <tr>
 </tr>
 <tr>
 <td><label for="email"><b>Email</b></label>
      
      <input type="text" placeholder="Enter Email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
   
</tr>
 <tr>     
      <td><label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter username" name="username" required></td>
</tr>
<tr>
      <td><label for="password1"><b>Password</b></label>
      
      <input type="password" placeholder="Enter Password"  id="psw" name="password1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
  </td>   
</tr>
<tr>
      <td><label for="password2"><b>Repeat Password</b></label>
      <input type="password" placeholder="Repeat Password" name="password2" required></td>
</tr> 
 <tr>     
      <td><label>
        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
      </label></td>

 


 </tr>


</table>

<button onclick="return checkForm(this);" style="width:auto;" name="regbutton" value="Create your Account">Sign Up</button>
<p>By creating an account, you agree to Amazone's Conditions of Use and Privacy Notice.<p>

<div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Login</button>
    </div>



 
</section>
</form> 
 
 
  








<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: #474e5d;
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
    color: #f1f1f1;
}

.close:hover,
.close:focus {
    color: #f44336;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>

<script>
          function myFunction(){
              var x = document.getElementsByName("password1").value;
              var y = document.getElementsByName("password2").value;
              var ok = true;
              if(x !== y)
              {
                  alert("Passwords do not match");
              }
              return ok;
          }  
         </script>



<script type="text/javascript">

  function checkForm(form)
  {
    if(form.username.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.username.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.username.focus();
      return false;
    }

    if(form.password1.value != "" && form.password1.value == form.password2.value) {
      if(form.password1.value.length < 8) {
        alert("Error: Password must contain at least eight characters!");
        form.password1.focus();
        return false;
      }
      if(form.password1.value == form.username.value) {
        alert("Error: Password must be different from Username!");
        form.password1.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.password1.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.pwd1.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.pwd1.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.password1.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.password1.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.password1.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.password1.focus();
      return false;
    }

    alert("You entered a valid password: " + form.pwd1.value);
    return true;
  }

</script>




<script type="text/javascript">
function ValidatePassword() {
	var pass1=document.getElementById("password1").value;
	var pass2=document.getElementById("password2").value;
	if(password1 !=password2){
		alert("Passwords dont match");
		return false;
	}
	return true;
}
</script>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>