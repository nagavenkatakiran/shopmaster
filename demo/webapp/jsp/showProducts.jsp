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
<form action="CreateProduct.action" method="post"  name="listProducts" id="listProducts">
 <table width="700" border="0" align="left" cellpadding="2" cellspacing="1" class="text">
  <tr align="left" id="listTableHeader"> 
   <td width="75">Product ID</td>
   <td width="75">Description</td>
   <td width="75">Status</td>
   <td width="75">Quantity</td>
   <td width="75">Unit Price</td>
   <td width="70">Modify</td>
   <td width="70">Delete</td>
  </tr>
  <s:iterator value="products">
  <tr>
  	<td><s:property value="productID" /></td>
  	<td><s:property value="description" /></td>
  	<td><s:property value="status" /></td>
  	<td><s:property value="quantity" /></td>
  	<td><s:property value="unitPrice" /></td>
  	<td>modify</td>
  	<td>delete</td>
  </tr>
  </s:iterator>
  <tr><td colspan="7">&nbsp;</td></tr>
  <tr> 
   <td colspan="7" align="left"><input name="btnAddProduct" type="submit" id="btnAddProduct" value="Add Product" class="box"></td>
  </tr>
 </table>
 <p>&nbsp;</p>
</form><br style="clear: both;"/><br/>
<p>&nbsp;</p>
<p><small>&copy; 2011 Shopping Cart Application&nbsp;</small></p>
</body>
</html>
