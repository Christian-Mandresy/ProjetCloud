<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Type</th>
        <th scope="col">Status</th>
        <th scope="col">Region</th>
        <th scope="col">Date de Signalement</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.ListStat}" var="lists">
        <tr>
            <th >${ListType.get(lists.getIdType()-1).getNomType()}</th>
            <td>${ListStatus.get(lists.getIdStatus()-1).getNomStatus()}</td>
            <td>${lists.getNomRegion()}</td>
            <td>${lists.getDateHeureSignalement()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>