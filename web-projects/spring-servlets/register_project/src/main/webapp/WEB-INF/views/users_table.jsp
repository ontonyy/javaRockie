<!DOCTYPE html>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Users Page</title>
    <link rel="stylesheet" type="text/css" href="users_table.css">
</head>
    <body>
        <mytags:navbar/>
        <div>
            <div>
                <br><h1>-V- USERS -V-</h1>
                <h3>
                    <form:form method="POST" action="users" modelAttribute="profession">
                        <form:label path="name">Profession:</form:label>
                        <form:select path="name">
                            <form:option value="${defaultProfession}"/>
                            <form:options items="${professionList}"/>
                        </form:select>

                        <form:button>SORT</form:button>
                    </form:form>
                </h3>
            </div>
            <br>
            <table>
                <tr>
                    <td><b>username</b></td>
                    <td><b>email</b></td>
                    <td><b>password</b></td>
                    <td><b>profession</b></td>
                    <td><b>birthday</b></td>
                    <td><b>married</b></td>
                    <td><b>note</b></td>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.profession}</td>
                        <td>${user.birthday}</td>
                        <td>${user.married}</td>
                        <td>${user.note}</td>
                    </tr>
                </c:forEach>
            </table><br><br>
            <form:form method="delete" action="/delete-users">
                <input type="submit" value="DELETE USERS"/>
            </form:form>

        </div>
        <mytags:footer/>
    </body>
</html>