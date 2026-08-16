<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <script>
        function validateChangePassword() {
            let newPass = document.forms["cpForm"]["newPassword"].value;
            let confirmPass = document.forms["cpForm"]["confirmPassword"].value;
            let passwordRegex = /^(?=.*[A-Z])(?=.*\d).{6,}$/;

            if (newPass.length < 6 || !passwordRegex.test(newPass)) {
                alert("New password must be at least 6 characters, contain 1 uppercase letter and 1 digit.");
                return false;
            }
            if (newPass !== confirmPass) {
                alert("New password and confirm password do not match.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Change Password</h2>
    <form name="cpForm" action="ChangePasswordServlet" method="post" onsubmit="return validateChangePassword()">
        <table>
            <tr>
                <td>Old Password:</td>
                <td><input type="password" name="oldPassword" required></td>
            </tr>
            <tr>
                <td>New Password:</td>
                <td><input type="password" name="newPassword" required></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="confirmPassword" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Change Password"></td>
            </tr>
        </table>
    </form>
</body>
</html>