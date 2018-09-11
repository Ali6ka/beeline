<%@ page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cm" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="master">

    <tiles:putAttribute name="title" value="Dashboard-point" />
    <tiles:putAttribute name="sidebar">
        <cm:sidebarAdmin/>
    </tiles:putAttribute>

    <tiles:putAttribute name="page-header">
        <h1 class="page-title">point form</h1>
        <cm:breadcrumb/>
        <div class="page-header-actions">
            <div class="mb-15">
                <a href="<c:url value="/admin/points"/> ">
                    <button class="btn btn-outline btn-primary" type="button">
                        <i class="icon wb-list" aria-hidden="true"></i> point list
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
                                <cm:alert_wizard title="${result == 'success' ? 'Point successfuly saved' :
                                                                            'Sorry, the error was occured, try again'}"
                                                 alert_type="${result == 'success' ? 'success' : 'danger'}" />
                            </c:if>
                            <spring:url value="/admin/points/save" var="actionUrl"/>
                            <form:form action="${actionUrl}" method="post" class="admin-form" modelAttribute="point">
                                <div class="tab-content">
                                    <spring:bind path="name">
                                    <div class="form-group">
                                        <form:label class="form-control-label" path="name" for="name">Name<sup class="requiredStar">*</sup>
                                        </form:label>
                                        <form:input type="text" path="name" id="name" class="form-control"
                                               oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                               oninput="setCustomValidity('')" value="${point.name}" required="true"/>
                                    </div>
                                    </spring:bind>
                                    <spring:bind path="phoneNumber">
                                    <div class="form-group">
                                        <form:label class="form-control-label" path="phoneNumber" for="phoneNumber">phoneNumber <sup class="requiredStar">*</sup>
                                        </form:label>
                                        <form:input type="text" path="phoneNumber" id="phoneNumber"
                                               class="form-control"
                                               oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                               oninput="setCustomValidity('')" value="${point.phoneNumber}" required="true"/>
                                    </div>
                                    </spring:bind>
                                    <spring:bind path="address">
                                    <div class="form-group">
                                        <form:label class="form-control-label" path="address" for="address">address <sup class="requiredStar">*</sup>
                                        </form:label>
                                        <form:input type="text" path="address" id="address"
                                               class="form-control"
                                               oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                               oninput="setCustomValidity('')" value="${point.address}" required="true"/>
                                    </div>
                                    </spring:bind>
                                    <c:if test="${isNew}">
                                        <spring:bind path="company">
                                        <div class="form-group">
                                            <form:label class="form-control-label" path="company" for="company"> company <sup class="requiredStar">*</sup></form:label>
                                            <form:select path="company" class="form-control select2-hidden-accessible" data-plugin="select2"
                                                         data-select2-id="4" tabindex="-1" aria-hidden="true"
                                                         name="company" id="company" placeholder="Choose roles"
                                                         oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                                         oninput="setCustomValidity('')" required="true">
                                                <form:options items="${companies}" itemValue="id" itemLabel="name"/>
                                            </form:select>
                                        </div>
                                        </spring:bind>
                                    </c:if>
                                    <c:if test="${isAdmin}">
                                        <spring:bind path="person">
                                        <div class="form-group">
                                            <form:label class="form-control-label" path="person" for="person"> person <sup class="requiredStar">*</sup></form:label>
                                            <form:select path="person" class="form-control select2-hidden-accessible" data-plugin="select2"
                                                         data-select2-id="4" tabindex="-1" aria-hidden="true"
                                                         name="person" id="person" placeholder="Choose roles"
                                                         oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                                         oninput="setCustomValidity('')" required="true">
                                                <form:options items="${users}" itemValue="id" itemLabel="fullname"/>
                                            </form:select>
                                        </div>
                                        </spring:bind>
                                    </c:if>
                                    <spring:bind path="latitude">
                                        <div class="form-group">
                                            <form:label class="form-control-label" path="latitude" for="latitude">latitude <sup class="requiredStar">*</sup>
                                            </form:label>
                                            <form:input type="number" path="latitude" id="latitude"
                                                        class="form-control"
                                                        oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                                        oninput="setCustomValidity('')" value="${point.latitude}" required="true"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="longitude">
                                        <div class="form-group">
                                            <form:label class="form-control-label" path="longitude" for="longitude">longitude <sup class="requiredStar">*</sup>
                                            </form:label>
                                            <form:input type="number" path="longitude" id="longitude"
                                                        class="form-control"
                                                        oninvalid="this.setCustomValidity('Это поле обязательно для заполнения')"
                                                        oninput="setCustomValidity('')" value="${point.longitude}" required="true"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="id">
                                        <form:input type="hidden" path="id" value="${point.id}"/>
                                    </spring:bind>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="text-right taxes-form__submit-wrapper">
                                        <button type="submit" class="btn btn-primary">Save point<i class="icon-arrow-right14 position-right"></i></button>
                                    </div>
                                </div> <!-- .tab-content -->
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>