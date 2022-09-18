<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>
    <h1>Admin Login: </h1>

    <c:if test="${not empty error}">
        <h3 style="color: darkred">Error: BAD Credentials.</h3>
    </c:if>

    <c:if test="${not empty logout}">
        <h3 style="color: darkgreen">Logout: Successfully logged out from site!</h3>
    </c:if>

    <form action="/admin/login" method="post">
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required/>
        </p>
        <button type="submit" class="btn">Log in</button>
    </form>
</body>
</html>