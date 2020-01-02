<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
<h2>Account</h2>
<table>
    <tr>
        <th>Account's summ</th>
        <th>User's id</th>
    </tr>
    <c:forEach var="account" items="${accountsList}">
        <tr>
            <td>${account.accountNumber}</td>
            <td>${account.userId}</td>
            <td>
                <c:url value="/account/${account.id}" var="accountId"/>
                <a href="${accountId}">Got to account</a>
            </td>
        </tr>
    </c:forEach>
</table>

<div>
    <form action="/user/richest" method="get">
        <input type="text" value="richest-user" name="nameStrParam">
        <input type="submit" value="get">
    </form>
</div>


<div>
    <form action="/user/sum" method="get">
        <input type="text" value="sum-accounts" name="nameStrAcParam">
        <input type="submit" value="get">
    </form>
</div>

${oneAccount.id}
${oneAccount.userId}
${oneAccount.accountNumber}
------------
${usersAc.id}
${usersAc.userId}
${usersAc.accountNumber}
------------
${summOfAccs}

<button onclick="merge()">Merge sort</button>
</body>
<script src="/res/jalgo.js"></script>
</html>
