<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>People</title>
</head>
<body>
<h2>People List</h2>
<p><a href='<c:url value="/add" />'>Create new</a></p>
<table border="1px solid black">
    <tr><th>ID</th><th>Name</th><th>Surname</th><th>Age</th><th></th></tr>
    <c:forEach var="person" items="${people}">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.surname}</td>
            <td>${person.age}</td>
            <td>
                <a href='<c:url value="/edit?id=${person.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${person.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
