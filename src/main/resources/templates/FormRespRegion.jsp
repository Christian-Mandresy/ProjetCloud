<%@ page import="java.util.List" %>
<%@ page import="com.cloudproject.backoffice.model.Region" %>
<%@ page import="com.cloudproject.backoffice.model.ResponsableRegion" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sf:form method="POST" modelAttribute="ResponsableRegion" action="http://localhost:8080/backoffice_war/insertResp">
    <select name="idRegion" id="" <sf:input path="IdRegion"/> >
    <c:forEach items="${requestScope.ListRegion}" var="lists">
        <option value="${lists.getIdRegion()}"> ${lists.getNomRegion()} </option>
    </c:forEach>
    </select>

    <fieldset>
        <table>
            <tr>
                <td>Nom :</td>
                <td><sf:input path="Nom" /><br/>
                    <sf:errors path="Nom"/></td>
            </tr>
            <tr>
                <td>Prénom :</td>
                <td><sf:input path="Prenom" /><br/>
                    <sf:errors path="Prenom"/></td>
            </tr>
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
    <div style="color: lawngreen"> <c:out value="${ success }"></c:out> </div>
</sf:form>