<%@ page pageEncoding="UTF-8" session="true"%><%@
        taglib
        uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%><%@
        taglib
        prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@
        taglib
        prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<tiles:insertDefinition name="master_second">
    <tiles:putAttribute name="title" value="MCMS: Login" />
    <tiles:putAttribute name="body">

        <!-- Page -->
        <div class="page vertical-align text-center" data-animsition-in="fade-in" data-animsition-out="fade-out">
            <div class="page-content vertical-align-middle animation-slide-top animation-duration-1">
                <div class="panel">
                    <div class="panel-body">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Invalid username and password.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>You have been logged out successfully.</p>
                            </div>
                        </c:if>
                        <div class="brand">
                            <h2 class="brand-text font-size-18">Beeline Admin</h2>
                        </div>
                        <form method="post" action="login">
                            <div class="form-group form-material floating" data-plugin="formMaterial">
                                <input type="text" class="form-control" name="ssoId" />
                                <label class="floating-label">Login</label>
                            </div>
                            <div class="form-group form-material floating" data-plugin="formMaterial">
                                <input type="password" class="form-control" name="password" />
                                <label class="floating-label">Password</label>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <button type="submit" class="btn btn-primary btn-block btn-lg mt-40">Sign in</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Page -->
    </tiles:putAttribute>
</tiles:insertDefinition>