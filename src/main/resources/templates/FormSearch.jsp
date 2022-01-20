<%@ page import="java.util.List" %>
<%@ page import="com.cloudproject.backoffice.model.Region" %>
<%@ page import="com.cloudproject.backoffice.model.ResponsableRegion" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sf:form method="POST" modelAttribute="Statistique" action="http://localhost:8080/backoffice_war_exploded/find">
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