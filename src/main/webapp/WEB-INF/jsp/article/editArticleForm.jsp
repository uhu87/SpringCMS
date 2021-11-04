<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Edit article</h2>
<form:form modelAttribute="article">

    <form:hidden path="id" value="${id}"/>
    Title: <form:input path="title"/><br>
    Content: <br>
    <form:textarea path="content" rows="5" cols="20"/><br>
    Author: <form:select path="author.id" items="${authors}" itemLabel="fullName" itemValue="id"/><br>  <!--FullName, dodales getter, mozna tez przez firstName i lastName-->
    Category: </br>
    <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/><br>
    <input type="submit" value="CONFIRM CHANGES"><br/>

</form:form>