<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h2>Users</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>
                <c:url value="/user/${user.id}" var="userid"/>
                <a href="${userid}">Got to user</a>
            </td>
        </tr>
    </c:forEach>
</table>


${oneUser.id}
${oneUser.name}
${oneUser.surname}

<h2>Accounts</h2>
<c:url value="/account" var="account"/>
<a href="${account}">Go to accs</a>
</body>
</html>