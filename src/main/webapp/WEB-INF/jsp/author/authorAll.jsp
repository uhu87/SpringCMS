<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Authors</h2>
<a href="add">ADD NEW AUTHOR</a><br>
<hr>
<c:forEach items="${authors}" var="a">

    <strong><c:out value="${a.firstName} ${a.lastName}"/></strong><br>

    <a href="delete?idToDelete=${a.id}">DELETE</a>
    <a href="edit?idToEdit=${a.id}">EDIT</a>
    <hr>

</c:forEach>