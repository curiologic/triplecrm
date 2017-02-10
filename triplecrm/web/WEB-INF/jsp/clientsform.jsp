<%-- 
    Document   : clientsform
    Created on : Jan 11, 2017, 7:16:38 PM
    Author     : xulix
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%--  <%@ include file="theme/header.jsp" %> --%>

<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body id="myPage">


<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Clients > Add Client</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      <h2>Client Data</h2>
    </div>

    <form:form method="post" action="save" cssClass="w3-container">
      <div class="w3-padding-8">
        <label><b>ID</b></label>
        <form:input path="idclient" cssClass="w3-input w3-border" /> 
        <label><b>Name</b></label>
        <form:input path= "name" cssClass="w3-input w3-border"  />
         <label><b>Address</b></label>
        <form:input path="Address" cssClass="w3-input w3-border" />
         <label><b>City</b></label>
       <form:input path="city" cssClass="w3-input w3-border"  />
        <label><b>State</b></label>
       <form:input path="State" cssClass="w3-input w3-border"  />
        <label><b>Postal Code</b></label>
       <form:input path="PostalCode" cssClass="w3-input w3-border" /> 
        <label><b>Phone Number</b></label>
       <form:input path="PhoneNumber" cssClass="w3-input w3-border"  />
       <label><b>Email</b></label>
        <form:input path="Email" cssClass="w3-input w3-border"  />
        <label><b>Prospect</b></label>
       <form:input path="Prospect" cssClass="w3-input w3-border"  />
        <label><b>Former Client</b></label>
       <form:input path="FormerClient" cssClass="w3-input w3-border"  />
        <label><b>Active</b></label>
       <form:input path="Active" cssClass="w3-input w3-border"  />
        <label><b>Comments</b></label>
        <form:input path="Comments" cssClass="w3-input w3-border"  />
      </div>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
  </div>

</div>