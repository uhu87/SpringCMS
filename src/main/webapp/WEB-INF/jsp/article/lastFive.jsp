<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Last Five Added</h2>



<c:forEach items="${lastFive}" var="a">

    <strong><c:out value="Title: ${a.title}"/></strong><br>
    <c:out value="Created on: ${a.created}"/><br>
    <c:out value="Content: ${a.content}"/><br>
    <hr>

</c:forEach>
