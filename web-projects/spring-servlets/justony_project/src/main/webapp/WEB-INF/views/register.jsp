<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<style type="text/css">
    span {
        display: inline-block;
        text-align: center;
        width: 200px;
    }
    body {
        text-align: center;
    }
</style>
<body>
<div>
    <div>
        <h2>Registration Succeeded!</h2>
        <span>Username:</span><span>${user.username}</span><br/>
        <span>E-mail:</span><span>${user.email}</span><br/>
        <span>Password:</span><span>${user.password}</span><br/>
        <span>Birthday:</span><span>${user.birthday}</span><br/>
        <span>Profession:</span><span>${user.profession}</span><br/>
        <span>Married:</span><span>${user.married}</span><br/>
        <span>Note:</span><span>${user.note}</span><br/>
    </div>
</div>
</body>
</html>