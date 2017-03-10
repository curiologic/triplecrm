<%-- 
    Document   : interactionseditform
    Created on : Feb 8, 2017, 6:02:01 PM
    Author     : xulix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="theme/header.jsp" %> 
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
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
      <h2>Interactions</h2>
    </div>

    <form:form method="POST" action="/triplecrm/interactions/editsave" cssClass="w3-container">
      <form:hidden path="id"  />
      
       <div class="w3-padding-8">
        <label><b>InteractionsID</b></label>
        <form:input path="idinteractions" cssClass="w3-input w3-border"  />
      </div>
      
      
      <div class="w3-padding-8">
        <label><b>Time of Contact</b></label>
        <form:input path="TimeOfContact" cssClass="w3-input w3-border"  />
      </div>
      
      <div class="w3-padding-8">
        <label><b>Client</b></label>
        <form:select path="idclient" cssClass="w3-select w3-border" items="${command.clients}" />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Email</b></label>
        <form:input path="email" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>Phone</b></label>
        <form:input path="Phone" cssClass="w3-input w3-border"  />
      </div>
      
       <div class="w3-padding-8">
        <label><b>In Person</b></label>
        <form:input path="inPerson" cssClass="w3-input w3-border"  />
      </div
      
       <div class="w3-padding-8">
        <label><b>Conference Call</b></label>
        <form:input path="conferenceCall" cssClass="w3-input w3-border"  />
      </div>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
    
  </div>
</div>
       <%@ include file="theme/footer.jsp" %>