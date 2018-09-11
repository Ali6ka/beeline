<%@ page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cm" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="master">
<tiles:putAttribute name="title" value="Dashboard-User" />
<tiles:putAttribute name="sidebar">
    <cm:sidebarAdmin/>
</tiles:putAttribute>

<tiles:putAttribute name="page-header">
    <h1 class="page-title">User form</h1>
    <cm:breadcrumb/>
    <div class="page-header-actions">
        <div class="mb-15">
            <a href="<c:url value="/admin/users"/> ">
                <button class="btn btn-outline btn-primary" type="button">
                    <i class="icon wb-list" aria-hidden="true"></i> User list
                </button>
            </a>
        </div>
    </div>
</tiles:putAttribute>

<tiles:putAttribute name="page-content">
    <div class="panel">
        <div class="panel-body container-fluid">
            <div class="row row-lg">
                <div class="col-md-4">
                    <!-- Example Basic Form (Form row) -->
                    <div class="example-wrap">
                        <c:if test="${!empty result}">
                            <cm:alert_wizard title="${result == 'success' ? 'User successfuly saved' :
                                                                            'Sorry, the error was occured, try again'}"
                                             alert_type="${result == 'success' ? 'success' : 'danger'}" />
                        </c:if>
                        <div id="exampleAddRow_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                            <spring:url value="/admin/users/save" var="userActionUrl" />
                            <form:form action="${userActionUrl}" method="post" class="admin-form" modelAttribute="user">
                                <div class="form-row">
                                    <spring:bind path="username">
                                    <div class="form-group col-md-6">
                                        <form:label class="form-control-label" path="username">Username <sup class="requiredStar">*</sup></form:label>
                                        <form:input type="text" path="username" id="username" class="form-control"
                                               placeholder="Enter username"
                                               oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                               oninput="setCustomValidity('')"/>
                                    </div>
                                    </spring:bind>
                                    <c:if test="${isNew eq 'true'}">
                                        <spring:bind path="password">
                                        <div class="form-group col-md-6">
                                            <form:label class="form-control-label" path="password">Password <sup class="requiredStar">*</sup></form:label>
                                            <form:input type="password" path="password" id="password"  class="form-control" placeholder="Your strong password"
                                                   oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                                   oninput="setCustomValidity('')" />
                                        </div>
                                        </spring:bind>
                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <spring:bind path="fullname">
                                    <form:label class="form-control-label" path="fullname">Fullname <sup class="requiredStar">*</sup></form:label>
                                    <form:input type="text" path="fullname" id="fullanme" class="form-control" value="${user.fullname}"
                                           placeholder="Enter fullname"
                                           oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                           oninput="setCustomValidity('')"/>
                                    </spring:bind>
                                </div>
                                <div class="form-group">
                                    <spring:bind path="phoneNumber">
                                        <form:label class="form-control-label" path="phoneNumber">Phone-number <sup class="requiredStar">*</sup></form:label>
                                        <form:input type="text" path="phoneNumber" id="fullanme" class="form-control" value="${user.phoneNumber}"
                                                    placeholder="Enter phoneNumber"
                                                    oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                                    oninput="setCustomValidity('')"/>
                                    </spring:bind>
                                </div>
                                <div class="form-group">
                                    <spring:bind path="isAdmin">
                                        <form:label class="form-control-label" path="isAdmin">isAdmin <sup class="requiredStar">*</sup></form:label>
                                        <form:checkbox path="isAdmin" id="isAdmin" class="" value="${user.isAdmin}"/>
                                    </spring:bind>
                                </div>
                                <div class="form-group">
                                    <spring:bind path="id">
                                        <form:input type="hidden" path="id" name="userId" value="${user.id}"/>
                                    </spring:bind>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="text-right">
                                        <button type="submit" class="btn btn-primary">Save user<i class="icon-arrow-right14 position-right"></i></button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <!-- End Example Basic Form (Form row) -->
                </div>
            </div>
        </div>
    </div>
</tiles:putAttribute>
</tiles:insertDefinition>
