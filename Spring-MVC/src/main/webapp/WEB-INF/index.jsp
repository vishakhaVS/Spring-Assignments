<%--
  Created by IntelliJ IDEA.
  User: vishakha
  Date: 17/3/19
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<p>
    First JSP Page!!!!

</p>
${msz}
${heading}

<form method="post" action="/submittedData">
    Fname:<input type="text" name="fName">
    Lname:<input type="text" name="lName">
    <input type="submit" value="OK">
</form>
</body>
</html>
