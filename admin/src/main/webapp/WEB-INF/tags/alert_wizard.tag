<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="alert title" %>
<%@ attribute name="alert_type" required="true" type="java.lang.String" description="success, warning, danger, info" %>
<%@ attribute name="alert_icon" required="false" type="java.lang.String" description="class for alert icon" %>
<%@ attribute name="subtitle" required="false" type="java.lang.String" description="alert subtitle" %>
<%@ attribute name="style" required="false" type="java.lang.String" description="additional class" %>

<c:if test="${!empty title && !empty alert_type}">
    <div class="alert alert-${alert_type}  mb-10 alert-styled-left alert-bordered ${style}">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>

        <!-- Please use here font awesome icons http://fontawesome.io/icons/ -->
        <i id="alert-icon" class="alert_icon ${alert_icon}"></i>
        <span class="text-semibold">${title}</span><br/>
        <c:if test="${!empty subtitle}">
            <small>${subtitle}</small>
        </c:if>
    </div>
</c:if>