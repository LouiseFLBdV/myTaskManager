<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<main>
    <div class="row w-100" style="background: rgb(111, 111, 111)">
        <div class="col-12">
            <h2 style="color: white">TaskManager</h2>
        </div>
        <div class="col-12">
            <c:if test="${inputModel.commandName=='showallusers'}">
                <h2>Show All users</h2>
            </c:if>
            <c:if test="${inputModel.commandName=='showtasks'}">
                <h2>Show user task</h2>
            </c:if>
            <c:if test="${inputModel.commandName=='createuser'}">
                <h2>Create User</h2>
            </c:if>
            <c:if test="${inputModel.commandName=='addtask'}">
                <h2>Add task</h2>
            </c:if>
        </div>
    </div>
</main>
</body>
</html>