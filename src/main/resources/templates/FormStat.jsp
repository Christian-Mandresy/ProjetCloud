<%@ page import="java.util.List" %>
<%@ page import="com.cloudproject.backoffice.model.Region" %>
<%@ page import="com.cloudproject.backoffice.model.ResponsableRegion" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sf:form method="POST" modelAttribute="Statistique" action="http://localhost:8080/backoffice_war/getStat">
    <select name="idRegion" id="" <sf:input path="IdRegion"/> >
        <option value="">Ajouter une filtre par region</option>
        <c:forEach items="${requestScope.ListRegion}" var="lists">
            <option value="${lists.getNomRegion()}"> ${lists.getNomRegion()} </option>
        </c:forEach>
    </select>

    <select name="idType" id="" <sf:input path="IdType"/> >
        <option value="">Ajouter une filtre par type</option>
        <c:forEach items="${requestScope.ListType}" var="lists">
            <option value="${lists.getIdType()}"> ${lists.getNomType()} </option>
        </c:forEach>
    </select>

    <select name="idStatus" id="" <sf:input path="IdStatus"/> >
        <option value="">Ajouter une filtre par status</option>
        <c:forEach items="${requestScope.ListStatus}" var="lists">
            <option value="${lists.getIdStatus()}"> ${lists.getNomStatus()} </option>
        </c:forEach>
    </select>

    <input type="checkbox" id="scales" name="valide"
           checked>
    <label for="scales">Ajouter des filtres par dates</label>

    <label for="start">Date debut:</label>

    <input type="date" id="start" name="DateDeb"
           value=""
           min="" max="" >

    <label for="start">Date fin:</label>

    <input type="date" id="start" name="DateFin"
           value=""
           min="" max="">

    <button type="submit">Valider</button>

</sf:form>

<Div>
    <h3>Statistique globale Region</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Region</th>
            <th scope="col">Nombre de Signalement</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.ListStatRegion}" var="lists">
            <tr>
                <td>${ListRegion.get(lists.getId()-1).getNomRegion()}</td>
                <td>${lists.getNombre()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</Div>

<Div>
    <h3>Statistique globale par Type</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Type</th>
            <th scope="col">Nombre de Signalement</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.ListStatType}" var="lists">
            <tr>
                <td>${ListType.get(lists.getId()-1).getNomType()}</td>
                <td>${lists.getNombre()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</Div>

<Div>
    <h3>Statistique globale par Status</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Status</th>
            <th scope="col">Nombre de Signalement</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.ListStatStatus}" var="lists">
            <tr>
                <td>${ListStatus.get(lists.getId()-1).getNomStatus()}</td>
                <td>${lists.getNombre()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</Div>
