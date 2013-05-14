<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form action="<c:url value="/static/j_spring_security_check"/>" method="post">
    <table border="0" align="center">
        <c:if test="${isFail}">
            <tr>
                <td colspan="2"><span class="error"><spring:message code="lang.wrong_name_or_password"/></span></td>
            </tr>
        </c:if>
        <tr>
            <td><spring:message code="lang.name"/></td>
            <td><input type="text" name="j_username" value=''></td>
        </tr>
        <tr>
            <td><spring:message code="lang.password"/></td>
            <td><input type="password" name="j_password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><spring:message code="lang.remember_me"/> <input type="checkbox" name="_spring_security_remember_me"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input name="submit" type="submit" value="<spring:message code="lang.submit"/>"/></td>
        </tr>
    </table>
</form>