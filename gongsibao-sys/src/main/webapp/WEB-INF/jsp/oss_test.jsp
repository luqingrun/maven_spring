<%--
  Created by IntelliJ IDEA.
  User: wk
  Date: 2016/3/26
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title2</title>
</head>
<body>
    <img src="${img}">

    <img src="${pageContext.request.contextPath}/captcha/?randomKey=${randomKey}">
</body>
</html>
