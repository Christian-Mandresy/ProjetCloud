<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Type</th>
        <th scope="col">Status</th>
        <th scope="col">Date de Signalement</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.ListSign}" var="lists">
        <tr>
            <th >${ListType.get(lists.getIdType()-1).getNomType()}</th>
            <td>${ListStatus.get(lists.getIdStatus()-1).getNomStatus()}</td>
            <td>${lists.getDateHeureSignalement()}</td>
            <td><a href="http://localhost:8080/backoffice_war_exploded/Assign?Long=${lists.getLongitude()}&Lat=${lists.getLatitude()}&Id=${lists.getIdSignalement()}">assigner une region</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>