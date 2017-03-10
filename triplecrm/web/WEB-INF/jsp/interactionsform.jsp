<%-- 
    Document   : interactionsform
    Created on : Feb 8, 2017, 6:07:14 PM
    Author     : xulix
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="theme/header.jsp" %> 
<!DOCTYPE html>
<html>
   
<title>Interactions</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body id="myPage">
    
   <header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Interactions > Add Interaction</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      <h2>Interaction Information</h2>
    </div>

  
     <form:form method="post" action="save" cssClass="w3-container">
      <div class="w3-padding-8">
        <label><b>ID</b></label>
        <form:input path="idclient" cssClass="w3-input w3-border" /> 
        <label><b>Time Of Contact</b></label>
        <form:input path= "TimeOfContact" cssClass="w3-input w3-border"  />
         <label><b>In Person</b></label>
        <form:input path="InPerson" cssClass="w3-input w3-border" />
         <label><b>Phone</b></label>
       <form:input path="Phone" cssClass="w3-input w3-border"  />
         <label><b>Email</b></label>
       <form:input path="email" cssClass="w3-input w3-border"  />
        <label><b>Confernce Call</b></label>
       <form:input path="ConferenceCall" cssClass="w3-input w3-border"  />
      </div>
        
      
      <c:choose>
      <c:when test="${not empty interactions.clients}">
        <form:hidden path="idclient" />
        <div class="w3-padding-8">
          <label><b>Client</b></label>
          <div class="w3-panel w3-border">
            <p><b>${interactions.clients.name}</b></p>
          </div>
         </div>
      </c:when>
      
      <c:otherwise>
        <div class="w3-padding-8">
          <label><b>Client</b></label>
          <form:select path="idclient" cssClass="w3-select w3-border">
              <form:option value="-1">Select Client</form:option>
              <form:options items="${interactions.clients}"  />
          </form:select>
        </div>
      </c:otherwise>
      </c:choose>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
  </div>

</div>
 <%@ include file="theme/footer.jsp" %>
</html>
