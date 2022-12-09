<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form method="post" action="edit-author">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label" >Author's id</label>
	    <input class="form-control" name="authorId" value="${author.getId()}">
	  </div>
	  
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label" >Author's name</label>
	    <input class="form-control" name="authorName" value="${author.getName()}">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>