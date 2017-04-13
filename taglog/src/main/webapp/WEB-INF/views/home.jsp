<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false" %>
<html>
  <head>
	<meta charset="utf-8">
    <title>Spitter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
  あああああ
  あいうえ
    <h1><s:message code="spitter.welcome" text="Welcome" /></h1>

    <s:url value="/spitter/register" var="registerUrl" />

    <a href="<s:url value="/spittles" />">Spittles</a> | 
    <a href="${registerUrl}">Register</a>

  </body>
</html>
