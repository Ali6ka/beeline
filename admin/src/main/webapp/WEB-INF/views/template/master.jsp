<%@ page pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html class="no-js js-menubar" lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="bootstrap admin template">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title><tiles:insertAttribute name="title" /></title>


    <link rel="apple-touch-icon" href="../../../assets/images/apple-touch-icon.png">
    <link rel="shortcut icon" href="../../../assets/images/favicon.ico">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="../../../assets/global/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../assets/global/css/bootstrap-extend.min.css">
    <link rel="stylesheet" href="../../../assets/css/site.min.css">

    <!-- Plugins -->
    <link rel="stylesheet" href="../../../assets/global/vendor/flag-icon-css/flag-icon.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/animsition/animsition.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/asscrollable/asScrollable.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/switchery/switchery.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/intro-js/introjs.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/slidepanel/slidePanel.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/bootstrap-select/bootstrap-select.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/select2/select2.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/multi-select/multi-select.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/dropify/dropify.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/jquery-wizard/jquery-wizard.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/formvalidation/formValidation.min.css">
    <link rel="stylesheet" href="../../../assets/plugins/bootstrap-datepicker/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="../../../assets/examples/css/pages/profile.min.css">
    <link rel="stylesheet" href="../../../assets/global/vendor/datatables.net-bs4/dataTables.bootstrap4.min.css">
    <link rel="stylesheet"
          href="../../../assets/global/vendor/datatables.net-responsive-bs4/dataTables.responsive.bootstrap4.min.css">
    <link rel="stylesheet"
          href="../../../assets/global/vendor/datatables.net-buttons-bs4/dataTables.buttons.bootstrap4.min.css">

    <!-- Fonts -->
    <link rel="stylesheet" href="../../../assets/global/fonts/web-icons/web-icons.min.css">
    <link rel="stylesheet" href="../../../assets/global/fonts/font-awesome/font-awesome.min.css">
    <link rel="stylesheet" href="../../../assets/global/fonts/brand-icons/brand-icons.min.css">
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,300italic'>

    <!-- Scripts -->
    <script src="../../../assets/global/vendor/breakpoints/breakpoints.js"></script>
    <script>
        Breakpoints();
    </script>

</head>

<body class="animsition dashboard">
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="sidebar" defaultValue=""/>
<tiles:insertAttribute name="gridmenu" />
<div class="page">
    <div class="page-header">
        <tiles:insertAttribute name="page-header" />
    </div>
    <div class="page-content">
        <tiles:insertAttribute name="page-content" />
    </div>
</div>
<tiles:insertAttribute name="footer" />
<!-- .wrapper -->

<!-- Core  -->

<script src="../../../assets/global/vendor/babel-external-helpers/babel-external-helpers.js"></script>
<script src="../../../assets/global/vendor/jquery/jquery.js"></script>
<script src="../../../assets/global/vendor/popper-js/umd/popper.min.js"></script>
<script src="../../../assets/global/vendor/bootstrap/bootstrap.min.js"></script>
<script src="../../../assets/global/vendor/animsition/animsition.min.js"></script>
<script src="../../../assets/global/vendor/mousewheel/jquery.mousewheel.js"></script>
<script src="../../../assets/global/vendor/asscrollbar/jquery-asScrollbar.min.js"></script>
<script src="../../../assets/global/vendor/asscrollable/jquery-asScrollable.min.js"></script>
<script src="../../../assets/global/vendor/ashoverscroll/jquery-asHoverScroll.min.js"></script>

<!-- Plugins -->
<script src="../../../assets/global/vendor/switchery/switchery.min.js"></script>
<script src="../../../assets/global/vendor/intro-js/intro.min.js"></script>
<script src="../../../assets/global/vendor/screenfull/screenfull.js"></script>
<script src="../../../assets/global/vendor/slidepanel/jquery-slidePanel.min.js"></script>
<script src="../../../assets/global/vendor/bootstrap-select/bootstrap-select.min.js"></script>
<script src="../../../assets/global/vendor/select2/select2.full.min.js"></script>
<script src="../../../assets/global/vendor/multi-select/jquery.multi-select.js"></script>
<script src="../../../assets/global/vendor/datatables.net/jquery.dataTables.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-bs4/dataTables.bootstrap4.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-fixedheader/dataTables.fixedHeader.min.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-fixedcolumns/dataTables.fixedColumns.min.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-rowgroup/dataTables.rowGroup.min.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-scroller/dataTables.scroller.min.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-responsive/dataTables.responsive.min.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-responsive-bs4/responsive.bootstrap4.min.js?"></script>
<script src="../../../assets/global/vendor/datatables.net-buttons/dataTables.buttons.min.js?"></script>
<script src="../../../assets/global/vendor/asrange/jquery-asRange.min.js"></script>
<script src="../../../assets/global/vendor/bootbox/bootbox.min.js"></script>
<script src="../../../assets/plugins/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>

<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload.js"></script>
<script src="../../../assets/global/vendor/blueimp-load-image/load-image.all.min.js"></script>
<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload-process.js"></script>
<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload-image.js"></script>
<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload-audio.js"></script>
<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload-video.js"></script>
<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload-validate.js"></script>
<script src="../../../assets/global/vendor/blueimp-file-upload/jquery.fileupload-ui.js"></script>
<script src="../../../assets/global/vendor/dropify/dropify.min.js"></script>
<script src="../../../assets/global/vendor/formvalidation/formValidation.min.js"></script>
<script src="../../../assets/global/vendor/formvalidation/framework/bootstrap.min.js"></script>
<script src="../../../assets/global/vendor/matchheight/jquery.matchHeight-min.js"></script>
<script src="../../../assets/global/vendor/jquery-wizard/jquery-wizard.min.js"></script>

<!-- Scripts -->
<script src="../../../assets/global/js/Component.js"></script>
<script src="../../../assets/global/js/Plugin.js"></script>
<script src="../../../assets/global/js/Base.js"></script>
<script src="../../../assets/global/js/Config.js"></script>

<script src="../../../assets/js/Section/Menubar.js"></script>
<script src="../../../assets/js/Section/GridMenu.js"></script>
<script src="../../../assets/js/Section/Sidebar.js"></script>
<script src="../../../assets/js/Section/PageAside.js"></script>
<script src="../../../assets/js/Plugin/menu.js"></script>

<script src="../../../assets/global/js/config/colors.js"></script>
<script src="../../../assets/js/config/tour.js"></script>
<script>Config.set('assets', '../../../assets');</script>

<!-- Page -->
<script src="../../../assets/js/Site.js"></script>
<script src="../../../assets/global/js/Plugin/asscrollable.js"></script>
<script src="../../../assets/global/js/Plugin/slidepanel.js"></script>
<script src="../../../assets/global/js/Plugin/switchery.js"></script>
<script src="../../../assets/global/js/Plugin/select2.js"></script>
<script src="../../../assets/global/js/Plugin/multi-select.js"></script>
<script src="../../../assets/global/js/Plugin/datatables.js"></script>
<script src="../../../assets/examples/js/tables/datatable.js"></script>
<script src="../../../assets/global/js/Plugin/dropify.js"></script>
<script src="../../../assets/global/js/Plugin/jquery-wizard.js"></script>
<script src="../../../assets/global/js/Plugin/matchheight.js"></script>
<script src="../../../assets/examples/js/forms/wizard.js"></script>
<script src="../../../assets/global/js/Plugin/responsive-tabs.js"></script>
<script src="../../../assets/global/js/Plugin/tabs.js"></script>





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
