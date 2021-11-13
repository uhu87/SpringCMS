<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h2>Add new article</h2>
<form:form modelAttribute="article">

    Title: <form:input path="title"/><br>
    <form:errors path="title"/><br/>
    Content: <br>
    <form:textarea path="content" rows="5" cols="20"/><br>
    <form:errors path="content"/><br/>
    Author: <form:select path="author.id" items="${authors}" itemLabel="fullName" itemValue="id"/><br>  <!--FullName, dodales getter, mozna tez przez firstName i lastName-->
    Category: </br>
    <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/><br>
    <form:errors path="categories"/><br/>
    <input type="submit" value="ADD ARTICLE"><br/>

</form:form>