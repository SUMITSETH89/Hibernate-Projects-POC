 <%@ page isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <html lang="en-in">
 
   <head>
     <title>Product Report</title>
   </head>
   <body>
     <!--Product Data-->
     <table border="1" align="center" bgcolor="cyan">
       <caption>Production Details</caption>
       <thead>
         <tr>
           <td>SR.No</td>
           <td>PID</td>
           <td>PNAME</td>
           <td>PRICE</td>
           <td>QUANTITY</td>
         </tr>
       </thead>
       <tbody>
         <c:choose>
           <c:when test="${not empty prodList}">
           <c:forEach items="${prodList}" var="prod" varStatus="counter">
            <tr>
              <td>${counter.count}</td>
              <td>${prod.pid}</td>
              <td>${prod.pname}</td>
              <td>${prod.price}</td>
              <td>${prod.qty}</td>
            </tr>
           </c:forEach>
         </c:when>
         <c:otherwise>
           <tr>
             <td colspan="5">Data Not Found</td>
           </tr>
         </c:otherwise>
         </c:choose>
       </tbody>
       <tfoot>
          <c:if test="${not empty pgCount}">
           <c:forEach var="tab" begin="1" end="${pgCount}" step="1">
              <a href="./prodDetails?pgNo=${tab}&link=s1">[${tab}]</a>
           </c:forEach>
          </c:if>
       </tfoot>
     </table>
   </body>
 
 </html>
 
 
 