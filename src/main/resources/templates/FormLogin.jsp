<%@ page import="java.util.List" %>
<%@ page import="com.cloudproject.backoffice.model.Region" %>
<%@ page import="com.cloudproject.backoffice.model.ResponsableRegion" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sf:form method="POST" modelAttribute="Utilisateur" action="http://localhost:8080/backoffice_war/Login">
    <fieldset>
        <table>
            <tr>
                <td>Email :</td>
                <td><sf:input path="Email" /><br/>
                    <sf:errors path="Email"/></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><sf:input path="MotDePasse" /><br/>
                    <sf:errors path="MotDePasse"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"
                                       value="Valider" /></td>
            </tr>
        </table>
    </fieldset>
    <div style="color: red"> <c:out value="${ erreur }"></c:out> </div>
</sf:form>