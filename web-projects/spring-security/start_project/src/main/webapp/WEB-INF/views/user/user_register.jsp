<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>
    <h1>Add new user: ${message}</h1>
    <form action="/register" method="post">
        <p>
            <label for="fullName">Full name: </label>
            <input type="text" id="fullName" name="fullName"/>
        </p>
        <p>
            <label for="username">Username: </label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password: </label>
            <input type="password" id="password" name="password"/>
        </p>
        <button type="submit" class="btn">Register</button>
    </form>
</body>
</html>