<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<table>
    <c:if test="${out.commandName == 'createuser'}">
        <h2>Create User</h2>
        <h4>${outputModel.user.userName} created</h4>
    </c:if>
    <c:if test="${outputModel.commandName == 'addtask'}">
        <h2>Add task</h2>
        <h4>Task "${outputModel.task.taskTitle}" for user "${outputModel.task.users.get(0)}" created</h4>
    </c:if>
    <c:if test="${outputModel.commandName == 'showusers'}">
        <h2>Show users</h2>
        <tr>
            <th>userName</th>
            <th>firstNmae</th>
            <th>lastNmae</th>
        </tr>
        <c:forEach var="user" items="${outputModel.users}">
            <tr>
                <td>${user.userName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
            <tr>
        </c:forEach>
    </c:if>
    <c:if test="${outputModel.commandName == 'showusertask'}">
        <h2>Show user task</h2>
        <h4>User ${outputModel.user.userName}</h4>
        <tr>
            <th>taskTittle</th>
            <th>taskDesc</th>
        </tr>
        <c:forEach var="task" items="${outputModel.user.tasks}">
            <tr>
                <td>${task.taskTitle}</td>
                <td>${task.description}</td>
            <tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>