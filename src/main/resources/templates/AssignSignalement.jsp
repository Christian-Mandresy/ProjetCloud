<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Nom de Region trouve grace aux coordonees : ${region}</p>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Type</th>
        <th scope="col">Status</th>
        <th scope="col">Date de Signalement</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <th >${ListType.get(Signalement.getIdType()-1).getNomType()}</th>
            <td>${ListStatus.get(Signalement.getIdStatus()-1).getNomStatus()}</td>
            <td>${Signalement.getDateHeureSignalement()}</td>
        </tr>
    </tbody>
</table>