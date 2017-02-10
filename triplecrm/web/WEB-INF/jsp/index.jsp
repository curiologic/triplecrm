<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <html>
  <title>Triplecrm</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<sec:authorize access="hasRole('ROLE_USER')">
  <c:url value="/j_spring_security_logout" var="logoutUrl" />
  

 <%-- <%@ include file="theme/header.jsp" %> --%>

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Dashboard</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">

  </div>
  
 <%-- <%@ include file="theme/footer.jsp" %> --%>
</sec:authorize>

<sec:authorize access="isAnonymous()">
    <c:redirect url="/login"/>
</sec:authorize>