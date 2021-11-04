<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Edit author</h2>
<form:form modelAttribute="author">
    <form:hidden path="id" value="${id}"/>
    First Name: <form:input path="firstName"/>${firstName}<br/>
    Last Name: <form:input path="lastName"/>${lastName}<br/>
    <input type="submit" value="CONFIRM CHANGES"><br/>

</form:form>