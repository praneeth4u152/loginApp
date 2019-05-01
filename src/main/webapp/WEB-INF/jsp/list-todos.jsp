<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
<title>First Web Application</title>
</head>

<body>
    Here are the list of your todos:
    
    <c:forEach items="${todos}" var="todo">
    ${todo.id}: ${todo.user}: ${todo.desc}: ${todo.targetDate}
	</c:forEach>
    <BR/>
    Your Name is : ${name}
</body>

</html>