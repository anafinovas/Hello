<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit person</title>
</head>
<body>
<h3>Edit person</h3>
<form method="post">
    <input type="hidden" value="${person.id}" name="id" />
    <label>Name</label><br>
    <input name="name" value="${person.name}" /><br><br>
    <label>Surname</label><br>
    <input name="surname" value="${person.surname}" /><br><br>
    <label>Age</label><br>
    <input name="age" value="${person.age}" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>