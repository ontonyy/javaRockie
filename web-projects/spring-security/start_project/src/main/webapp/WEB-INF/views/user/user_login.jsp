<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>
    <h1>User Login: </h1>

    <c:if test="${not empty error}">
        <h3 style="color: darkred">Error: BAD Credentials.</h3>
    </c:if>

    <c:if test="${not empty logout}">
        <h3 style="color: darkgreen">Logout: Successfully logged out from site!</h3>
    </c:if>

    <form action="/user/login" method="POST">
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <button type="submit" class="btn">Log in</button>
    </form>
    <br>
    <h3><a href="/user/register">Add new user</a></h3>
</body>
</html>