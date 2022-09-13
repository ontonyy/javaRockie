<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register Form</title>
        <link rel="stylesheet" type="text/css" href="register_form.css">
    </head>
    <body>
        <mytags:navbar/><br>
        <div>
            <div>
                <h2>Registration: </h2><br>
                <h2 style="color: darkred">${message}</h2>
                <form:form action="register" method="post" modelAttribute="request">
                    <form:label path="username">Username: </form:label>
                    <form:input path="username" value="${request.username}"/><br/>

                    <form:label path="email">E-mail:</form:label>
                    <form:input path="email" value="${request.email}" /><br/>

                    <form:label path="password">Password:</form:label>
                    <form:password path="password" value="${request.password}"/><br/>

                    <form:label path="birthday">Birthday (yyyy-mm-dd):</form:label>
                    <form:input path="birthday" value="${request.birthday}"/><br/>

                    <form:label path="profession">Profession:</form:label>
                    <form:select path="profession" items="${professionList}" /><br/>

                    <form:label path="married">Married?</form:label>
                    <form:checkbox path="married" value="${request.married}"/><br/>

                    <form:label path="note">Note:</form:label>
                    <form:textarea path="note" cols="25" rows="5" value="${request.note}"/><br/><br>

                    <form:button>Register</form:button>
                </form:form>
            </div>
        </div>
        <br><br><br>
        <mytags:footer/>
    </body>
</html>