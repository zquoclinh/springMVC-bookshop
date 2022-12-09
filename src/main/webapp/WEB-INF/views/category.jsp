<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

	<div class="product-container">
	<div class="nav col-xl-2">
		<c:forEach items="${parents }" var="p">
			<div>
			<h3>${p.categoryName }</h3>
			<ul>
				<c:forEach items="${childrens }" var="c">
					<c:if test="${p.categoryId == c.parentId }">
						<li>${c.categoryName }</li>
					</c:if>
				</c:forEach>
			</ul>
			</div>
		</c:forEach>
	</div>
	
	<div class="products col-xl-10">
		<c:forEach items="${products }" var="p">
			<div class="col-xl-3">
				<%-- <img src='<spring:url value="/source/image/${p.imageUrl }"/>' width="200" height="200"> --%>
				<%-- <img src="resources/image/${p.imageUrl }" width="200" height="200">
				<figcaption>${p.title }</figcaption> --%>
				<img alt="anh san pham" src='source/image/${p.imageUrl }' class="product-item-img">
				<h6 class="product-title">${p.title }</h6>
			</div>
		</c:forEach>
	</div>	
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