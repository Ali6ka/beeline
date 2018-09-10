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
                            <img class="brand-img" src="../../assets//images/logo-blue.png" alt="...">
                            <h2 class="brand-text font-size-18">IAU PITV</h2>
                        </div>
                        <form method="post" action="/j_spring_security_check">
                            <div class="form-group form-material floating" data-plugin="formMaterial">
                                <input type="text" class="form-control" name="ssoId" />
                                <label class="floating-label">Login</label>
                            </div>
                            <div class="form-group form-material floating" data-plugin="formMaterial">
                                <input type="password" class="form-control" name="password" />
                                <label class="floating-label">Password</label>
                            </div>
                            <div class="form-group clearfix">
                                <div class="checkbox-custom checkbox-inline checkbox-primary checkbox-lg float-left">
                                    <input type="checkbox" id="inputCheckbox" name="remember">
                                    <label for="inputCheckbox">Remember me</label>
                                </div>
                                <a class="float-right" href="forgot-password.html">Forgot password?</a>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <button type="submit" class="btn btn-primary btn-block btn-lg mt-40">Sign in</button>
                        </form>
                        <p>Still no account? Please ask administrator</p>
                    </div>
                </div>

                <footer class="page-copyright page-copyright-inverse">
                    <p>WEBSITE BY IAU</p>
                    <p>© 2018. All RIGHT RESERVED.</p>
                </footer>
            </div>
        </div>
        <!-- End Page -->
    </tiles:putAttribute>
</tiles:insertDefinition>