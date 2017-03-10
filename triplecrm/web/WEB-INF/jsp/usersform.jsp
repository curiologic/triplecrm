<%-- 
    Document   : clientsform
    Created on : Jan 11, 2017, 7:16:38 PM
    Author     : xulix
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

  <%@ include file="theme/header.jsp" %> 

<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body id="myPage">


<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Users > Add User</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      <h2>User Data</h2>
    </div>

    <form:form method="post" action="save" cssClass="w3-container">
      <div class="w3-padding-8">
        <label><b>ID</b></label>
        <form:input path="idusers" cssClass="w3-input w3-border" /> 
        <label><b>Name</b></label>
        <form:input path= "UserName" cssClass="w3-input w3-border"  />
         <label><b>Password</b></label>
        <form:input path="Password" cssClass="w3-input w3-border" />
        <label><b>Enabled</b></label>
        <form:input path="enabled" cssClass="w3-input w3-border" />
       <label><b>Role</b></label>
        <form:input path="roles" cssClass="w3-input w3-border" />
      </div>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
  </div>

</div>
    
    <%@ include file="theme/footer.jsp" %>