<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/admin.css" rel="stylesheet" type="text/css">
<title></title>
</head>
<body>
<br>
<form action="" method="post"  name="" id="">
 <table width="700" border="0" align="center" cellpadding="2" cellspacing="1" class="text">
  <tr align="center" id="listTableHeader"> 
   <td width="75">Username</td>
   <td width="75">Password</td>
   <td width="75">Shipping Address</td>
   <td width="75">Billing Address</td>
   <td width="75">Rating</td>
   <td width="75">Email</td>
   <td width="70">Modify</td>
   <td width="70">Delete</td>
  </tr>
  <s:iterator value="customers">
  	<tr>
  		<td><s:property value="userName" /></td>
  		<td><s:property value="password" /></td>
  		<td><s:property value="shippingAddress" /></td>
  		<td><s:property value="billingAddress" /></td>
  		<td><s:property value="rating" /></td>
  		<td><s:property value="emailAddress" /></td>
  		<td>modify</td>
  		<td>delete</td>
  	</tr>
  </s:iterator>
  <tr><td colspan="8">&nbsp;</td></tr>
  <tr> 
   <td colspan="8" align="right"><input name="btnAddCustomer" type="button" id="btnAddCustomer" value="Add Customer" class="box"></td>
  </tr>
 </table>
 <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
<p><small>&copy; 2010 Shopping Cart Application&nbsp;</small></p>
</body>
</html>
