<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<a href="authors/add-author" class="btn btn-primary btn-add-author">Add</a>
	
	<form method="" action="">
		<table class="table">
			<tr>
				<td><button class="btn btn-info">Delete</button> </td>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${authors }" var="o">
				<tr>
					<td>
					<input type="checkbox" value="${o.id }" name="ids">
					</td>
					
					<td>${o.id}</td>
					
					<td>${o.name}</td>
					
					<td>
						<a class="action-link" href="authors/edit-author?id=${o.id}">
							Edit
							<%-- <img src="${pageContext.request.contextPath}/images/edit.png" alt="Edit"> --%>
						</a>
					</td>
					
					<td>
						<a href="authors/delete-author?id=${o.id }">
							Delete
							<%-- <img
							src="${pageContext.request.contextPath}/images/trash.png" alt="Delete"> --%>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>
<div>
	<ul class="pagination">
	  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
	  <li class="page-item"><a class="page-link" href="authors?page=1">1</a></li>
	  <li class="page-item"><a class="page-link" href="authors?page=2">2</a></li>
	  <li class="page-item"><a class="page-link" href="#">3</a></li>
	  <li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</div>