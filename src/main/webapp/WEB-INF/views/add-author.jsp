<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form method="post" action="add-author">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label" >Author's name</label>
	    <input class="form-control" name="authorName">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>