<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page pageEncoding="UTF-8"%>

<div class="site-gridmenu scrollable scrollable-inverse scrollable-vertical is-disabled">
    <div class="scrollable-container" style="">
        <div class="scrollable-content" style="">
            <ul>
                <li>
                    <a href="<c:url value="/"/>">
                        <i class="icon wb-home"></i>
                        <span>Home</span>
                    </a>
                </li>
                <li>
                    <a href="apps/calendar/calendar.html">
                        <i class="icon wb-calendar"></i>
                        <span>Calendar</span>
                    </a>
                </li>
                <li>
                    <a href="apps/media/overview.html">
                        <i class="icon wb-camera"></i>
                        <span>Media</span>
                    </a>
                </li>
                <li>
                    <a href="apps/documents/categories.html">
                        <i class="icon wb-order"></i>
                        <span>Documents</span>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/admin"/>">
                        <i class="icon wb-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="scrollable-bar scrollable-bar-vertical scrollable-bar-hide is-disabled" draggable="false">
        <div class="scrollable-bar-handle"></div>
    </div>
</div>