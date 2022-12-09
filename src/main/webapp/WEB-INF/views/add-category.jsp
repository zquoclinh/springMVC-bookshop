<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
<h2>Add category</h2> 
<form:form method="post" action="add-category" modelAttribute="category">
	  <div class="mb-3">
	    <form:label  class="form-label"  path="categoryName">Author's name</form:label>
	    <form:input class="form-control"  path="categoryName"/>
	  </div>
	  <div class="mb-3">
	    <form:label  class="form-label"  path="parentId">Parent:</form:label>
	    <form:select class="form-control" path="parentId">
	    	<form:options items="${parents }" itemLabel="categoryName" itemValue="categoryId"/>
	    </form:select>
	  </div>
	  <form:button type="submit" class="btn btn-primary">Submit</form:button>
</form:form>