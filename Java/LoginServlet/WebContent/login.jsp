<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<form action="/LoginServlet/login.do" method="POST">
      <label for="loginName">Name:</label>
      <input type="text" id="loginName" name="loginName" />
      <input type="submit" value="Submit" />
    </form>

</body>
</html>