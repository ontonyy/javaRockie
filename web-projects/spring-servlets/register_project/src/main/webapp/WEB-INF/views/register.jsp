<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
    <title>Register Success!</title>
    <link rel="stylesheet" type="text/css" href="register.css">
</head>
<body>
    <mytags:navbar/><br>
    <div>
        <div class="register">
            <br><h2>Registration Succeeded!</h2><br>
            <table>
                <tr>
                    <td><b>Username:</b></td><td>${user.username}</td>
                </tr>
                <tr>
                    <td><b>E-mail:</b></td><td>${user.email}</td>
                </tr>
                <tr>
                    <td><b>Password:</b></td><td>${user.password}</td>
                </tr>
                <tr>
                    <td><b>Birthday:</b></td><td>${user.birthday}</td>
                </tr>
                <tr>
                    <td><b>Profession:</b></td><td>${user.profession}</td>
                </tr>
                <tr>
                    <td><b>Married:</b></td><td>${user.married}</td>
                </tr>
                <tr>
                    <td><b>Note:</b></td><td>${user.note}</td>
                </tr>
            </table>
        </div>
    </div>
    <br>
    <mytags:footer/>
</body>
</html>