<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<html lang="en">
<head>
    <title>Home Page</title>
    <style>
        body {
            background-color: #c9ff60;
            text-align: center;
            margin: auto;
            vertical-align: middle;
        }
    </style>
</head>
    <body>
        <mytags:navbar/>
        <div>
            <div>
                <br><br><h2>Login is successful, you can enjoy the WEB-site</h2><br>
                <h3>${user.username}</h3>
                <h3>${user.email}</h3>
                <h3>${user.password}</h3>
                <h3>${user.profession}</h3>
                <h3>${user.birthday}</h3>
                <h3>${user.married}</h3>
                <h3>${user.note}</h3>
            </div>
        </div>
        <mytags:footer/>
    </body>
</html>