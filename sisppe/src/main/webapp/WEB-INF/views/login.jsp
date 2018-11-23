<%-- 
    Document   : login
    Created on : 23/08/2018, 10:50:02 AM
    Author     : earango
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--<link href="<c:url value='/resources/plugin/bootstrap-4.1.3/css/bootstrap.min.css' />"  rel="stylesheet"></link>-->        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        <title>login</title>
    </head>
    <body > 
        <div class="container login-container">
            <form class="form-horizontal" role="form" method="POST" action="<c:url value='/login' />">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <h2>Login</h2>
                        <hr>
                        <c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Usuario y/o Password ingresados son incorrectos</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>Ud. a salido del sistema</p>
								</div>
							</c:if>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="col-auto">
                            <label class="sr-only" for="username">Username</label>
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-user"></i></div>
                                </div>
                                <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">             
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <div class="col-auto">
                            <label class="sr-only" for="password">Clave</label>
                            <div class="input-group mb-2">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><i class="fa fa-lock"></i></div>
                                </div>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">                    
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="padding-top: .35rem">
                        <div class="form-check mb-2 mr-sm-2 mb-sm-0">
                            <label class="form-check-label">
                                <input class="form-check-input" name="remember"
                                       type="checkbox" >
                                <span style="padding-bottom: .15rem">Remember me</span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="row" style="padding-top: 1rem">
                    <div class="col-md-3"></div>
                    <div class="col-md-6"><input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                        <button type="submit" class="btn btn-block btn-primary btn-default"><i class="fa fa-sign-in"></i> Login</button>                    
                    </div>
                </div>
            </form>
        </div>
        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    </body>
</html>
