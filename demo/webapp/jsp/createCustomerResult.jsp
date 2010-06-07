<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<h1>Customer created successfully!</h1>
	Customer's username: <b><s:text name="userName" /></b><br />
	Customer's password: <b><s:text name="password" /></b><br />
	Customer's shipping address: <b><s:text name="shippingAddress" /></b><br />
	Customer's billing address: <b><s:text name="billingAddress" /></b><br />
	Customer's rating: <b><s:text name="rating" /></b><br />
	Customer's email address: <b><s:text name="emailAddress" /></b><br />
</body>
</html>