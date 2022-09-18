<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example</title>
</head>
    <body>
        <div align="center">
            <h1>Simple user main page</h1>
            <sec:authorize access="isAuthenticated()">
                <sec:authentication var="principal" property="principal"/>
                <h2>Welcome back, ${principal.username}!</h2>
            </sec:authorize>

            <form action="/user/logout" method="post">
                <button type="submit" class="btn">Sign out</button>
            </form>
        </div>
    </body>
</html>