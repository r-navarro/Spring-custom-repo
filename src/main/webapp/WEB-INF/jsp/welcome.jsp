<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	 <h2>Book search</h2>
     <form:form method="POST" action="/result" commandName="criteria">
        <table>
         <tr>
             <td><form:label path="authorLastName">Author last name</form:label></td>
             <td><form:input path="authorLastName" /></td>
         </tr>
         <tr>
             <td><form:label path="type">Type</form:label></td>
             <td><form:input path="type" /></td>
         </tr>
         <tr>
             <td>
                 <input type="submit" value="Submit"/>
             </td>
         </tr>
     </table>
     </form:form>
</body>

</html>