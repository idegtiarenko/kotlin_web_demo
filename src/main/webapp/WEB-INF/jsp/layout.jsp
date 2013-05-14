<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><spring:message code="lang.header"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>

<div class="header">
    <spring:message code="lang.header"/>
</div>

<div class="menu">
    <span class="main">
        <sec:authorize access="hasRole('ROLE_USER')">
            <a href="<c:url value="/notes/create"/>"><spring:message code="lang.add"/></a>
        </sec:authorize>
        <sec:authorize access="permitAll">
            <a href="<c:url value="/notes"/>"><spring:message code="lang.notes"/></a>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')">
            <a href="<c:url value="/profile"/>"><spring:message code="lang.profile"/></a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout"/>"><spring:message code="lang.logout"/></a>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <a href="<c:url value="/login"/>"><spring:message code="lang.login"/></a>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
            <a href="<c:url value="/register"/>"><spring:message code="lang.register"/></a>
        </sec:authorize>
    </span>
    <span class="lang"> [
        <a href="?lang=en_US">EN</a> |
        <a href="?lang=ru_RU">RU</a> |
        <a href="?lang=ua_UA">UA</a> ]
    </span>
</div>

<div class="content">
    <tiles:insertAttribute name="content"/>
</div>

<div class="footer">
    <spring:message code="lang.footer"/>
</div>

</body>
</html>