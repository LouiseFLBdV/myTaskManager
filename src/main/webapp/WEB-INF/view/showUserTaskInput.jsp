<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>ShowUserTaskInput</title>
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
    <form:form action="showUserTask" modelAttribute="inputModel">
        <div class="row">
            <div class="col-4">
                <h5 class="col-4">userName</h5>
                <div class="col-8"><form:input path="userName"/></div>
                <br>

                <div class="col-4">
                    <button type="submit" class="btn btn-dark">Show Tasks</button>
                </div>
                <div class="col-8"></div>
            </div>
        </div>
    </form:form>
</main>
</body>
</html>
