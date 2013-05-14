<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="<c:url value="${action}"/>" method="post" modelAttribute="note" name="note">
    <div class="note ${note.priority.style}">
        <div class="title"><form:input path="note.title"/></div>
        <div class="body"><form:textarea path="note.body"/></div>
        <form:errors path="note.*" cssClass="error"/>
        <div class="controls">
            <form:hidden path="note.id"/>
            <form:select path="note.priority" items="${priorities}"/>
            <input type="submit" value="<spring:message code="lang.submit"/>"/>
            <input type="button" value="<spring:message code="lang.cancel"/>" onclick="window.location.replace('<c:url value="/notes"/>');"/>
        </div>
    </div>
</form>