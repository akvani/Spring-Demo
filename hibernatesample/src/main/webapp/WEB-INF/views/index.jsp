<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<html>


<body>


My Data is ${data}


<h4> Purchase Book</h4>
<form method="post" action="addbook" modelAttribute="bookobj">

Enter Customerid <input type=text name="bookid"><br>
Enter customername <input type=text name="bookname"><br>


<button type=submit>Add Book</button>
</form>



<table border="2">

<tr>
<td>Bookid</td>
<td>Book Name</td>
 
</tr>

<c:forEach items="${books}" var="bookobj">
<tr>
<td>${bookobj.bookid}</td>
<td>${bookobj.bookname}</td>
 
<td><a href="deletebook?qryid=${bookobj.bookid}">Delete</a></td>
<td><a href="viewbook?qryid=${bookobj.bookid}">Modify</a> </td>
<tr>
</c:forEach>



</table>

 
<form action="updatebook" modelAttribute="bookmodi">

Enter Bookid <input type=text name="bookid" value=${bookresult.bookid}><br>
Enter bookname <input type=text name="bookname" value=${bookresult.bookname}><br>


<button type=submit>Update Book</button>
</form>

 
 
</body>
</html>
