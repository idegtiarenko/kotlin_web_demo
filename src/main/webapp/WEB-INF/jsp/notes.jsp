<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:forEach var="note" items="${notes}">
    <div class="note ${note.priority.style}">
        <div class="title">${note.title}</div>
        <div class="body">${note.body}</div>
        <div class="controls">
            <a href="<c:url value="/notes/edit/${note.id}"/>"><spring:message code="lang.edit"/></a>
            <a href="<c:url value="/notes/delete/${note.id}"/>"><spring:message code="lang.delete"/></a>
        </div>
    </div>
</c:forEach>
