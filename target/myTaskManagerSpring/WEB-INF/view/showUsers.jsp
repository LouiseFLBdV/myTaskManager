<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<h2>All users</h2>
<table>
    <c:if test="${userCount > 0}">
        <tr>
            <th class="left-side">NR</th>
            <th>userName</th>
            <th>firstNmae</th>
            <th>lastNmae</th>
        </tr>
        <c:forEach var="user" items="${users}" varStatus="i">
            <tr>
                <td class="left-side">${index + 1}</td>
                <td>${user.userName}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
        </c:forEach>
    </c:if>
    <c:if test="${userCount == 0}">
        <tr>
            <td colspan="7" style="font-size: 150%" class="left-side right-side">
                users is empty
            </td>
        </tr>
    </c:if>

</table>
</body>
</html>