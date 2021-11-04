<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Categories</h2>
<a href="add">ADD NEW CATEGORY</a><br>
<hr>
<c:forEach items="${categories}" var="c">

    <strong><c:out value="Title: ${c.name}"/></strong><br>
    <c:out value="Created on: ${c.description}"/><br>
    <a href="delete?idToDelete=${c.id}">DELETE</a>
    <a href="edit?idToEdit=${c.id}">EDIT</a>
    <hr>

</c:forEach>