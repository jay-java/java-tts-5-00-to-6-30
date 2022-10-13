<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Registartion Form</h1>
<form action="Servlet" method="post">
<table>
<tr>
<td>Name</td>
<td><input type="text" name="name" placeholder="enter your name" required="">
</td>
</tr>

<tr>
<td>Contact</td>
<td><input type="text" name="contact" required=""></td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" required=""></td>
</tr>

<tr>
<td>Email</td>
<td><input type="email" name="email" required=""></td>
</tr>

<tr>
<td>Password</td>
<td><input type="Password" name="password" required=""></td>
</tr>

<tr>
<td>Gender</td>
<td>Male<input type="radio" name="gender" required="">
    Female<input type="radio" name="gender" required=""></td>
</tr>

<tr>
<td>Hobbies</td>
<td>Reading<input type="checkbox" name="hobby" required="">
 Swimming<input type="checkbox" name="hobby" required="">
 Writing<input type="checkbox" name="hobby" required="">
 Learning a linguistics<input type="checkbox" name="hobby" required="">
</td>
</tr>

<tr>
<td><input type="submit" value="register"name="action"></td>
</tr>

</table>



</form>
</div>
</body>
</html>