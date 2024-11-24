<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dog Show Login</title>
</head>
<body>
    <h2>Login to Dog Show</h2>
    <form name="f1" action="/WebProj/LoginServlet" method="post" onsubmit="return validateForm()">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
       
        <button type="submit">Login</button>
    </form>
    <br>
    <a href="register.jsp">New User? Register Here</a>
    
    <script type="text/javascript">
        function validateForm() {
            let username = document.f1.username.value.trim();
            let password = document.f1.password.value.trim();
            
            // Validate username
            if (username === "" || username === null) {
                alert("Username should not be empty");
                return false;
            }

            // Validate password
            if (password === "" || password === null) {
                alert("Password should not be empty");
                return false;
            }
             return true; // Allow form submission
        }
    </script>
</body>
</html>
