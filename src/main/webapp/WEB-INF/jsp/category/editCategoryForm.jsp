<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Edit category</h2>
<form:form modelAttribute="category">
    <form:hidden path="id" value="${id}"/>
    Name: <form:input path="name"/>${name}<br/>
    Description: <form:textarea path="description"/>${description}<br/>
    <input type="submit" value="CONFIRM CHANGES"><br/>

</form:form>