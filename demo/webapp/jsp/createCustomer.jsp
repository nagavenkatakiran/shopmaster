<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<s:form action="CreateCustomerResult.action" method="post" theme="simple">
	Customer's username: <s:textfield name="userName" /><br />
	Customer's password: <s:password name="password" /><br />
	Customer's shipping address: <s:textfield name="shippingAddress" /><br />
	Customer's billing address: <s:textfield name="billingAddress" /><br />
	Customer's rating: <s:textfield name="rating" /><br />
	Customer's email address: <s:textfield name="emailAddress" /><br />
	<s:submit name="createCustomer" /><br />
</s:form>
</body>
</html>