<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Welcome</title>
</head>
<body>
<header>
    <div class="row w-100" style="background: rgb(111, 111, 111)">
        <div class="col-4">
            <h2 style="color: white">TaskManager</h2>
        </div>
    </div>
</header>
<main>
    <div class="row w-100">
        <div class="col-6" style="margin-top: 20px;">
            <form:form action="addTaskInput">
                <button type="submit" class="btn btn-dark">Add task to user</button>
            </form:form>
            <br>
            <form:form action="createUserInput">
                <button type="submit" class="btn btn-dark">Create user</button>
            </form:form>
            <br>
            <form:form action="showUserTaskInput">
                <button type="submit" class="btn btn-dark">Show user tasks</button>
            </form:form>
            <br>
            <form:form action="showUsers">
                <button type="submit" class="btn btn-dark">Show users</button>
            </form:form>
            <br>
        </div>
    </div>
</main>

</body>
</html>