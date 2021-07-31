<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ShowUsers</title>
</head>
<body>
<main>
  <h2>showUsers</h2>
  <tr>
    <th>userName</th>
    <th>firstNmae</th>
    <th>lastNmae</th>
  </tr>
  <c:forEach var="user" items="${UserDTOList}">
    <tr><br>
      <td>${user.userName}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
    </tr>
  </c:forEach>
</main>
</body>
</html>
