<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="css/admin.css" rel="stylesheet" type="text/css">
</head>
<body style="text-align: left;">
<form action="CreateProductResult.action" method="post">
  <table width="800" border="0" align="center" cellpadding="5" cellspacing="1" class="entryTable">
  <tr> 
   <td width="150" class="label">Product ID</td>
   <td class="content"><input name="productID" type="text" class="box" id="productID" size="50" maxlength="100" value="" /></td>
  </tr>
  <tr> 
   <td width="150" class="label">Description</td>
   <td class="content"><textarea name="description" cols="70" rows="10" class="box" id="description"></textarea></td>
  </tr>
  <tr>
  	<td width="150" class="label">Status</td>
  	<td class="content"><input name="status" type="text" class="box" id="status" size="50" maxlength="100" value="" /></td>
  </tr>
   
  <tr> 
   <td width="150" class="label">Quantity</td>
   <td class="content"><input name="quantity" type="text" id="quantity" size="10" maxlength="10" class="box" /> </td>
  </tr>
  <tr>
   <td width="150" class="label">Unit Price</td>
   <td class="content"><input name="unitPrice" type="text" id="unitPrice" size="10" maxlength="7" class="box" value="" /> </td>
  </tr>
 </table>
 <p align="center"> 
  <input name="btnAddProduct" type="submit" id="btnAddProduct" value="Add Product" class="box" />
  &nbsp;&nbsp;
  <input name="btnCancel" type="button" id="btnCancel" value="Cancel" onClick="window.location.href='ShowProducts.action';" class="box" />  
 </p>
</form>
</body>
</html>
