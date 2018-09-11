<%@ page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cm" tagdir="/WEB-INF/tags"%>

<tiles:insertDefinition name="master">
<tiles:putAttribute name="title" value="Dashboard-User" />
<tiles:putAttribute name="sidebar">
    <cm:sidebarAdmin/>
</tiles:putAttribute>

<tiles:putAttribute name="page-header">
    <h1 class="page-title">Point list</h1>
    <cm:breadcrumb/>
    <div class="page-header-actions">
        <div class="mb-15">
            <a href="<c:url value="/admin/points/new"/> ">
                <button id="addToTable" class="btn btn-outline btn-primary" type="button">
                    <i class="icon wb-plus" aria-hidden="true"></i> Create new
                </button>
            </a>
        </div>
    </div>
</tiles:putAttribute>

<tiles:putAttribute name="page-content">
    <div class="panel">
        <div class="panel-body">
            <c:if test="${!empty result}">
                <cm:alert_wizard title="${result == 'success' ? 'Point successfuly deleted' :
                'Sorry, the error was occured, try again'}"
                                 alert_type="${result == 'success' ? 'success' : 'danger'}" />
            </c:if>
            <table class="table table-bordered table-hover table-striped" cellspacing="0" id="exampleAddRow">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Company</th>
                    <th>Phone number</th>
                    <th>Address</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                    <th>Person</th>
                    <th class="text-center">Edit/Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${points}" var="point">
                    <tr class="gradeA">
                        <td>${point.name}</td>
                        <td>${point.company.name}</td>
                        <td>${point.phoneNumber}</td>
                        <td>${point.address}</td>
                        <td>${point.latitude}</td>
                        <td>${point.longitude}</td>
                        <td>${point.person.fullname}</td>
                        <td class="actions text-center">
                            <a href="<c:url value="/admin/points/update/${point.id}"/>"
                               class="btn btn-sm btn-icon btn-pure btn-default on-default edit-row"
                               data-toggle="tooltip" data-original-title="Edit">
                                <i class="icon wb-edit" aria-hidden="true"></i>
                            </a>
                            <a href="<c:url value="/admin/points/delete/${point.id}"/>"
                               class="btn btn-sm btn-icon btn-pure btn-default on-default remove-row"
                               data-toggle="tooltip" data-original-title="Remove">
                                <i class="icon wb-trash" aria-hidden="true"></i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</tiles:putAttribute>
</tiles:insertDefinition>


