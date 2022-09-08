<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Login Form</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap');

        body {
            text-align: center;
            font-family: "Montserrat", sans-serif;
        }

        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }

        input[type=text], input[type=password], select {
            width: 200px;
        }

        h1 {
            margin: 0 0 20px;
            font-weight: 400;
            color: #1c87c9;
        }

        p {
            margin: 0 0 5px;
        }

        form {
            padding: 25px;
            margin: 25px;
            box-shadow: 0 2px 5px #f5f5f5;
            background: #f5f5f5;
        }

        input {
            width: 200px;
            padding: 8px;
            margin-bottom: 20px;
            border: 1px solid #1c87c9;
            outline: none;
        }

        input::placeholder {
            color: #666;
        }

        button {
            width: 200px;
            padding: 10px;
            border: none;
            background: #1c87c9;
            font-size: 16px;
            font-weight: 400;
            color: #fff;
        }

        button:hover {
            background: #2371a0;
        }
    </style>
</head>
    <body>
    <mytags:navbar/>
        <div>
            <div>
                <br><h2>Login:</h2><br>
                <h2 style="color: darkred">${message}</h2>
                <form:form action="login" method="post" modelAttribute="request">
                    <form:label path="usernameOrEmail">Username or E-mail: </form:label>
                    <form:input path="usernameOrEmail" value="${request.usernameOrEmail}"/><br/>

                    <form:label path="password">Password:</form:label>
                    <form:password path="password" value="${request.password}"/><br/>

                    <form:button>Login</form:button>
                </form:form>
            </div>
        </div>
    <mytags:footer/>
    </body>
</html>