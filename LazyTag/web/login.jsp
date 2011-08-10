<%-- 
    Document   : login
    Created on : July 9, 2011, 10:54:09 AM
    Author     : Priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Login</title>
            <link href="stylesheet.css" rel="stylesheet" type="text/css" />
        </head>
        <body leftmargin="0" rightmargin="0" topmargin="40" bottommargin="0">
            <center><h:form id="loginForm">
                    <table class="table1" width="400px">
                        <tr>
                            <td colspan="2">
                                <H2 class="title"> <h:outputText value="#{msg.login}"/> </H2>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="left">
                                <h:messages styleClass="error"/>
                            </td>
                        </tr>
                        <tr><td align="left">
                                <h:outputLabel value="#{msg.loginid}"/> </td>
                            <td align="left">
                                <h:inputText size="20"  id="loginId" value="#{loginBean.loginId}" required="true"
                                             requiredMessage="#{msg.loginid_reqd}"/></td>
                        <tr><td  align="left">
                                <h:outputLabel value="#{msg.password}"/></td>
                            <td  align="left">
                                <h:inputSecret size="20" value="#{loginBean.password}" required="true"
                                               requiredMessage="#{msg.password_reqd}" label="#{msg.password}"/>
                            </td>
                        </tr>
                        <tr><td colspan="2"></td></tr>
                        <tr>
                            <td></td>
                            <td  align="left" ><h:commandButton value="#{msg.login}"
                                             action="#{loginBean.authenticate}"/>
                            </td>
                        </tr>
                        <tr>
                            <td  align="left">
                                <h:outputLabel value="#{msg.newuser}"/></td>
                            <td align="left">
                                <h:commandButton value="#{msg.register}" action="registeruser" immediate="true"/>
                            </td>
                        </tr>
                    </table>
                </center>
            </h:form>
        </body>
        <script>
            document.getElementById('loginForm:loginId').focus();
        </script>
    </html>
</f:view>

