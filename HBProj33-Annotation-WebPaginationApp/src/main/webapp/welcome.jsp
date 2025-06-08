<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<body>
<h1 style="text-align:center; color:red;">Welcome To Boom.com</h1>
<form action="./prodDetails" method="POST">
 <table align="center" border="1" bgcolor="cyan">
   <tbody>
     <tr>
       <th>Enter Page Size</th>
       <td><input type="text" name="pageSize"></td>
     </tr>
     <tr>
       <td colspan="2"><input type="submit" name="s1" value="Generate Report"/></td>
     </tr>
   </tbody>
 </table>
</form>
</body>