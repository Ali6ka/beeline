<%@ page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html class="no-js css-menubar" lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title><tiles:insertAttribute name="title" /></title>

    <link rel="apple-touch-icon" href="<c:url value="/assets/images/apple-touch-icon.png"/>"/>
    <link rel="shortcut icon" href="<c:url value="/assets/images/favicon.ico"/>"/>

    <!-- Stylesheets -->
    <link rel="stylesheet" href="<c:url value="/assets/global/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/css/bootstrap-extend.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/css/site.min.css"/>"/>

    <!-- Plugins -->
    <link rel="stylesheet" href="<c:url value="/assets/global/vendor/animsition/animsition.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/vendor/asscrollable/asScrollable.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/vendor/switchery/switchery.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/vendor/intro-js/introjs.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/vendor/slidepanel/slidePanel.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/vendor/flag-icon-css/flag-icon.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/examples/css/pages/login-v3.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/plugins/flip-clock/flipclock.css"/>"/>


    <!-- Fonts -->
    <link rel="stylesheet" href="<c:url value="/assets/global/fonts/web-icons/web-icons.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/assets/global/fonts/brand-icons/brand-icons.min.css"/>"/>
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'>

    <!-- Scripts -->
    <script src="<c:url value="/assets/global/vendor/breakpoints/breakpoints.min.js"/>"></script>
    <script>
        Breakpoints();
    </script>
</head>


<body class="animsition page-login-v3 layout-full">

    <tiles:insertAttribute name="body" />


<script src="<c:url value="/assets/global/vendor/babel-external-helpers/babel-external-helpers.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/popper-js/umd/popper.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/bootstrap/bootstrap.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/animsition/animsition.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/mousewheel/jquery.mousewheel.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/asscrollbar/jquery-asScrollbar.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/asscrollable/jquery-asScrollable.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/ashoverscroll/jquery-asHoverScroll.min.js"/>"></script>

<!-- Plugins -->
<script src="<c:url value="/assets/global/vendor/switchery/switchery.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/intro-js/intro.min.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/screenfull/screenfull.js"/>"></script>
<script src="<c:url value="/assets/global/vendor/slidepanel/jquery-slidePanel.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/flip-clock/flipclock.min.js"/>"></script>

<!-- Scripts -->
<script src="<c:url value="/assets/global/js/Component.js"/>"></script>
<script src="<c:url value="/assets/global/js/Plugin.js"/>"></script>
<script src="<c:url value="/assets/global/js/Base.js"/>"></script>
<script src="<c:url value="/assets/global/js/Config.js"/>"></script>

<script src="<c:url value="/assets/js/Section/Menubar.js"/>"></script>
<script src="<c:url value="/assets/js/Section/GridMenu.js"/>"></script>
<script src="<c:url value="/assets/js/Section/Sidebar.js"/>"></script>
<script src="<c:url value="/assets/js/Section/PageAside.js"/>"></script>
<script src="<c:url value="/assets/js/Plugin/menu.js"/>"></script>

<script src="<c:url value="/assets/global/js/config/colors.js"/>"></script>
<script src="<c:url value="/assets/js/config/tour.js"/>"></script>
<script>Config.set('assets', '../../../assets');</script>

<!-- Page -->
<script src="<c:url value="/assets/js/Site.js"/>"></script>
<script src="<c:url value="/assets/global/js/Plugin/asscrollable.js"/>"></script>
<script src="<c:url value="/assets/global/js/Plugin/slidepanel.js"/>"></script>
<script src="<c:url value="/assets/global/js/Plugin/switchery.js"/>"></script>
<script src="<c:url value="/assets/global/js/Plugin/material.js"/>"></script>


<script>
    (function(document, window, $){
        'use strict';
        var Site = window.Site;
        $(document).ready(function(){
            Site.run();
        });
    })(document, window, jQuery);
</script>
<!-- logic for show/hide sidebar on mobile(less than 768px) -->
</body>
</html>