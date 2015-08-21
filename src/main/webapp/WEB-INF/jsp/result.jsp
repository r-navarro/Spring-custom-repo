<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	 <h2>Books</h2>
	 <table border="1">
         <tr>
             <th>title</th>
             <th>Author</th>
             <th>Types</th>
         </tr>
	 <c:forEach var="book" items="${books}">
	 	<tr>
	 		<td>${book.title}</td>
	 		<td>${book.author.firstName}&nbsp;${book.author.lastName}</td>
	 		<td><c:forEach var="type" items="${book.types}">${type.type}</c:forEach></td>
	 	</tr>
	 </c:forEach>
</body>

</html>