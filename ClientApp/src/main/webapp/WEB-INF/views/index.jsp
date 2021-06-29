<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<html>


<body>

<h4> Client Registration Form</h4>
<form method="post" action="addclient" modelAttribute="clientobj">

Enter Customerid <input type=text name="clientid"><br>
Enter customername <input type=text name="clientname"><br>
Enter Location <input type=text name="location"><br>

<button type=submit>Add Client</button>
</form>



<table border="2">

<tr>
<td>Clientid</td>
<td>Client Name</td>
<td>Location</td>
</tr>

<c:forEach items="${clientarr}" var="bookobj">
<tr>
<td>${bookobj.clientid}</td>
<td>${bookobj.clientname}</td>
<td>${bookobj.location}</td>
<td><a href="deleteclient?qryid=${bookobj.clientid}">Delete</a></td>
<td><a href="viewclient?qryid=${bookobj.clientid}">Modify</a> </td>
<tr>
</c:forEach>



</table>


<form action="update" modelAttribute="clientmodi">

Enter Customerid <input type=text name="clientid" value=${clientfound.clientid}><br>
Enter customername <input type=text name="clientname" value=${clientfound.clientname}><br>
Enter Location <input type=text name="location" value=${clientfound.location}><br>

<button type=submit>Modify Client</button>
</form>

</body>
</html>
