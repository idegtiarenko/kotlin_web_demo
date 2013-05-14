<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="<c:url value="${action}"/>" method="post" modelAttribute="profile" name="profile">
    <table border="0" align="center">
        <tr>
            <td colspan="2"><form:errors path="profile.*" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="lang.name"/></td>
            <td><form:input path="profile.name"/></td>
        </tr>
        <tr>
            <td><spring:message code="lang.password"/></td>
            <td><form:password path="profile.password"/></td>
        </tr>
        <tr>
            <td><spring:message code="lang.password_repeat"/></td>
            <td><form:password path="profile.passwordRepeat"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><form:hidden path="profile.id"/><input name="submit" type="submit" value="<spring:message code="lang.submit"/>"/></td>
        </tr>
    </table>
</form>