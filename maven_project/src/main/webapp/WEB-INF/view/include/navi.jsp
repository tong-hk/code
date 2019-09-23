<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">
    <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>            
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
	<ul id="menu">
		<c:forEach items="${admin1.lp}" var="pr">
			<li><a href="${PATH_WAY}/${pr.purl}" class="${pr.pclass}"></a></li>
		</c:forEach>
	</ul>
</div>
