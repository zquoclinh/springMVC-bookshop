<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="tieuDe"/></title>
</head>
<body>
<div class='container '>
	<header>
		<tiles:insertAttribute name="dauTrang"/>
	</header>	
	
	<div class='content container'>
			<tiles:insertAttribute name="noiDung"/>
	</div>
	
	<footer>
		<tiles:insertAttribute name="cuoiTrang"/>
	</footer>
</div>

<script type="text/javascript" src='<spring:url value="/source/javascript/index.js"></spring:url>'></script>
</body>
</html>