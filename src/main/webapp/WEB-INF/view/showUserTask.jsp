<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>showUserTask</title>
</head>
<body>
<main>
    <h2>Show user task</h2>
    <h4>User ${outputModel.user.userName}</h4>
    <tr>
        <th>taskTittle</th>
        <th>taskDesc</th>
    </tr>
    <c:forEach var="task" items="${outputModel.user.tasks}">
        <tr><br>
            <td>${task.taskTitle}</td>
            <td>${task.description}</td>
        </tr>
    </c:forEach>
</main>
</body>
</html>
