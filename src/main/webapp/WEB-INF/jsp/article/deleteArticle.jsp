<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" %>
<h2>CONFIRM DELETING OF:</h2>

<form:form modelAttribute="article">

    <strong>${article.title} </strong><br/>
    ${article.author.fullName}<br/>

    <br>
    <button type="submit" value="delete" name="confirmed">delete</button>
    <button type="submit" value="cancel" name="confirmed">cancel</button>
    <form:hidden path="id" value="${id}" /><br/>

</form:form>