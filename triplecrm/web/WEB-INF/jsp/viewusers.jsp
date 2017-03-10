<%-- 
    Document   : viewusers
    Created on : Jan 11, 2017, 7:45:10 PM
    Author     : xulix
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 

   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

   <%@ include file="theme/header.jsp" %> 
 
 <html>
  <title>Triplecrm</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Users</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">
    
  <c:if test="${not empty message}">
    <c:choose>
      <c:when test="${message.type eq 'INFO'}">
        <div class="w3-panel w3-border w3-pale-yellow w3-border-yellow"><p>${message.message}</p></div>
      </c:when>
      <c:when test="${message.type eq 'ERROR'}">
        <div class="w3-panel w3-border w3-pale-red w3-border-red"><p>${message.message}</p></div>
      </c:when>
    </c:choose>
    
  </c:if>

  <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Password</th>
      <th>Enabled</th>
     <th>Role</th>
     
      <th>Action</th>
    </tr>  

    <c:forEach var="users" items="${list}">   
      <tr>  
        <td>${users.idusers}</td>  
        <td>${users.userName}</td> 
        <td>${users.password}</td> 
        <td>${users.enabled}</td>
       <td>${users.roles}</td> 
        
        
        <td>
          <a href="<c:url value="/users/editusers/${users.idusers}" />"><button class="w3-btn w3-round w3-blue">Edit</button></a>
          <a href="<c:url value="/users/deleteusers/${users.idusers}" />"><button class="w3-btn w3-round w3-red">Delete</button></a>
          </td>  
      </tr>  
    </c:forEach>  
  </table> 

  <div class="w3-padding-8">
    <ul class="w3-pagination">
      <c:forEach begin="1" end="${pages}" varStatus="p">  
        <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/users/viewusers/${p.index}" />">${p.index}</a></li>
      </c:forEach>
    </ul>
  </div>
    
  </div>

  <%@ include file="theme/footer.jsp" %> 
