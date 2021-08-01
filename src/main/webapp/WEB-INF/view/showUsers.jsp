<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>ShowUsers</title>
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
    <h2>showUsers</h2>
    <tr>
        <th>userName</th>
        <th>firstNmae</th>
        <th>lastNmae</th>
    </tr>
    <c:forEach var="user" items="${UserDTOList}">
        <tr>
            <td>${user.userName}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </c:forEach>
</main>
</body>
</html>
