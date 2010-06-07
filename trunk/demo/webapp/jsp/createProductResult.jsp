<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<h1>Product created successfully!</h1>
	Product's ID: <b><s:text name="productID" /></b><br />
	Product's description: <b><s:text name="description" /></b><br />
	Product's status: <b><s:text name="status" /></b><br />
	Product's quantity: <b><s:text name="quantity" /></b><br />
	Product's unit price: <b><s:text name="unitPrice" /></b><br />
</body>
</html>