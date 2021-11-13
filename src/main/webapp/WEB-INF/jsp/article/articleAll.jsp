<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
Articles <a href="/author/all">Authors</a> <a href="/category/all">Categories</a><br>
<a href="add">ADD NEW ARTICLE</a><br>
<hr>
<c:forEach items="${articles}" var="a">

    <strong><c:out value="${a.title}"/></strong><br>
    <strong><c:out value="${a.author.firstName} ${a.author.lastName}"/></strong><br>
    Categories:
    <c:forEach items="${a.categories}" var="c">
        ${c.name},
    </c:forEach>
    <br>
    <a href="delete?idToDelete=${a.id}">DELETE</a>
    <a href="edit?idToEdit=${a.id}">EDIT</a>
    <hr>

</c:forEach>