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
                <h2>Registration: </h2>
                <form:form action="register" method="post" modelAttribute="request">
                    <form:label path="username">Username: </form:label>
                    <form:input path="username"/><br/>

                    <form:label path="email">E-mail:</form:label>
                    <form:input path="email"/><br/>

                    <form:label path="password">Password:</form:label>
                    <form:password path="password"/><br/>

                    <form:label path="birthday">Birthday (yyyy-mm-dd):</form:label>
                    <form:input path="birthday"/><br/>

                    <form:label path="profession">Profession:</form:label>
                    <form:select path="profession" items="${professionList}" /><br/>

                    <form:label path="married">Married?</form:label>
                    <form:checkbox path="married"/><br/>

                    <form:label path="note">Note:</form:label>
                    <form:textarea path="note" cols="25" rows="5"/><br/><br>

                    <form:button>Register</form:button>
                </form:form>
            </div>
        </div>
    </body>
</html>