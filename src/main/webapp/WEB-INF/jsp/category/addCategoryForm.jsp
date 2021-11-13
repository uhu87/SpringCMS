<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Add new category</h2>
<form:form modelAttribute="category">

    Name: <form:input path="name"/><br/>
    <form:errors path="name"/><br/>

    Description: <form:textarea path="description"/><br/>
    <input type="submit" value="ADD CATEGORY"><br/>

</form:form>