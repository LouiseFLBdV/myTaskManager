<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>CreateUserInput</title>
</head>
<body>
<header>
    <div class="row w-100" style="background: rgb(111, 111, 111)">
        <div class="col-4">
            <h2 style="color: white">TaskManager</h2>
        </div>
    </div>
</header>
<form:form action="createUser" modelAttribute="inputModel">
    <div class="row">
        <div class="col-4">
            <h5 class="col-4">userName</h5>
            <div class="col-8"><form:input path="userName"/></div>
            <br>

            <h5 class="col-4">firstName</h5>
            <div class="col-8"><form:input path="firstName"/></div>
            <br>

            <h5 class="col-4">lastName</h5>
            <div class="col-8"><form:input path="lastName"/></div>
            <br>

            <div class="col-4">
                <button type="submit" class="btn btn-dark">Create User</button>
            </div>
            <div class="col-8"></div>
        </div>
    </div>
</form:form>
</body>
</html>
