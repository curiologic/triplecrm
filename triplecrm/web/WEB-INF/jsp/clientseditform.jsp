<%-- 
    Document   : clientsform
    Created on : Jan 11, 2017, 7:08:56 PM
    Author     : xulix
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

 <%@ include file="theme/header.jsp" %>

<html>
<title>Edit Client</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body id="myPage">

<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Clients > Edit Client</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      <h2>Clients</h2>
    </div>

    <form:form method="POST" action="/triplecrm/clients/editsave" cssClass="w3-container">
      <form:hidden path="idclient"  />
      
      <div class="w3-padding-8">
        <label><b>Name</b></label>
        <form:input path="name" cssClass="w3-input w3-border"  />
      </div>
      
      <div class="w3-padding-8">
        <label><b>IdClients</b></label>
        <form:input path="idclient" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Address</b></label>
        <form:input path="address" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>City</b></label>
        <form:input path="city" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>State</b></label>
        <form:input path="state" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Country</b></label>
        <form:input path="country" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Postal Code</b></label>
        <form:input path="postalCode" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Email</b></label>
        <form:input path="email" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Former Clients</b></label>
        <form:input path="formerClient" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Prospects</b></label>
        <form:input path="prospect" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Active</b></label>
        <form:input path="active" cssClass="w3-input w3-border"  />
      </div>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
    
  </div>
</div>

 <%@ include file="theme/footer.jsp" %> 