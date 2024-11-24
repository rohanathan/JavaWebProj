<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register - Dog Show</title>
</head>
<body>
	<h2>Owner Registration</h2>
	<form name="f2" action="/WebProj/RegisterServlet" method="post" onsubmit="return validateForm2()">
		<label for="fname">First Name:</label> <input type="text" id="fname"
			name="fname" required><br>
		<br> <label for="mname">Middle Name:</label> <input type="text"
			id="mname" name="mname"><br>
		<br> <label for="lname">Last Name:</label> <input type="text"
			id="lname" name="lname" required><br>
		<br> <label for="username">UserName:</label> <input type="text"
			id="username" name="username" required><br>
		<br> <label for="phone">Phone:</label> <input type="text"
			id="phone" name="phone" required><br>
		<br> <label for="email">Email Address:</label> <input
			type="email" id="email" name="email" required><br>
		<br> <label for="password">Password:</label> <input
			type="password" id="password" name="password" required><br>
		<br> <small style="color: gray;">Password must contain at
			least 8 characters, including 1 number and 1 special character.</small><br>
		<br> <label for="repassword">Re-type Password:</label> <input
			type="password" id="repassword" name="repassword" required><br>
		<br>

		<button type="submit">Register</button>
	</form>
	<script>
    function validateForm2() {
    	let fname = document.f2.fname.value.trim();
    	let mname = document.f2.mname.value.trim();
    	let lname = document.f2.lname.value.trim();
    	let username = document.f2.username.value.trim();
        let email = document.f2.email.value.trim();
        let password = document.f2.password.value.trim();
        let repassword = document.f2.repassword.value.trim();
 		       
        // Regular expressions for validation
        let specialCharRegex = /[!@#$%^&*(),.?":{}|<>]/;
        let numberRegex = /[0-9]/;
        let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Simple email format validation
        let phoneRegex = /^[0-9]{10}$/;
        		
        // Validate First Name
        if (fname === "" || fname === null) {
            alert("First name should not be empty");
            return false;
        }
        
        // Validate Last Name
        if (lname === "" || lname === null) {
            alert("Last name should not be empty");
            return false;
        }
        // Validate username
        if (username === "" || username === null) {
            alert("Username should not be empty");
            return false;
        }
     // Validate phone
        if (!phoneRegex.test(phone)) {
            alert("Phone number must be 10 digits");
            return false;
        }

        // Validate email
        if (email === "" || email === null) {
            alert("Email should not be empty");
            return false;
        }
        if (!emailRegex.test(email)) {
            alert("Please enter a valid email address");
            return false;
        }

        // Validate password
        if (password === "" || password === null) {
            alert("Password should not be empty");
            return false;
        }
        if (password.length < 8) {
            alert("Password should be at least 8 characters long");
            return false;
        }
        if (!specialCharRegex.test(password) || !numberRegex.test(password)) {
            alert("Password must contain at least one special character and one number");
            return false;
        }
        // Validate re-typed password
        if (password !== repassword) {
            alert("Passwords do not match");
            return false;
        }

        return true; // Allow form submission
    }
    
    </script>
</body>
</html>
