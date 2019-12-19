<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>NWPU校园招聘</title>
</head>

<body>
list：
<h4>${pb.totalCount}</h4>
<c:forEach var="item" items="${pb.list}">
    <li>${item.name}</li>
    tag:
    <c:forEach var="tag" items="${item.tag}">
        <li>${tag.tagName}: ${tag.tagUrl}</li>
    </c:forEach>


</c:forEach>
</body>
</html>