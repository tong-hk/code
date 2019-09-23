<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
        <%@include file="include/header.jsp"%>    
    </head>
    <body class="index">
    <!--导航区域开始-->
     <div id="index_navi">
            <ul id="menu">
            	<c:forEach items="${admin1.lp}" var="pr">
                	<li><a href="${PATH_WAY}/${pr.purl}" class="${pr.pclass}"></a></li>
                </c:forEach>
            </ul>
     </div>
    </body>
</html>
