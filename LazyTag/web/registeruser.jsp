<%-- 
    Copyright© 2011 Priya Limaye, Nandini Mahendran

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

    Contact: plimaye@pdx.edu, mnandini@pdx.edu

    Document   : registeruser
    Created on : July 10, 2011, 10:03:06 AM
    Author     : Nandini
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
            <title>Register User</title>
            <link href="stylesheet.css" rel="stylesheet" type="text/css" />
        </head>
        <body leftmargin="0" rightmargin="0" topmargin="40" bottommargin="0">
            <center>
                <h:form id="userform">
                    <table class="table1" width="700px">
                        <tr>
                            <td colspan="3">
                                <H2 class="title"><h:outputLabel value="#{msg.create}"/></H2>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <h:outputText value="If you already have an account, you can "/>
                                <h:outputLink value="./faces/login.jsp">sign in here</h:outputLink>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h:messages globalOnly="true" styleClass="success"/>
                            </td>
                            <td colspan="2"></td>
                        </tr>
                        <tr>
                            <td>
                                <h:outputText value="#{msg.firstname}"/></td>
                            <td>
                                <h:inputText id="firstName" value="#{userBean.firstName}"
                                             required="true" requiredMessage="#{msg.field_reqd}">
                                    <f:validator validatorId="AlphaValidator"/>
                                </h:inputText>
                            </td>
                            <td>
                                <h:message styleClass="error" for="firstName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h:outputText value="#{msg.lastname}"/></td>
                            <td>
                                <h:inputText id="lastName" value="#{userBean.lastName}"  required="true" requiredMessage="#{msg.field_reqd}">
                                    <f:validator validatorId="AlphaValidator"/>
                                </h:inputText>
                            </td>
                            <td>
                                <h:message styleClass="error" for="lastName"/>
                            </td>
                        <tr>
                            <td>
                                <h:outputText value="#{msg.email}"/>
                            </td>
                            <td>
                                <h:inputText id="email" value="#{userBean.email}" required="false">
                                    <f:validator validatorId="EmailValidator"/>
                                </h:inputText>
                            </td>
                            <td>
                                <h:message styleClass="error" for="email"/>
                            </td>
                        <tr>
                            <td>
                                <h:outputText value="#{msg.desiredlogin}"/>
                            </td>
                            <td>
                                <h:inputText id="login" value="#{userBean.login}"  required="true"
                                             requiredMessage="#{msg.field_reqd}"
                                             validator="#{userBean.validateLogin}">
                                    <f:validator validatorId="AlphaNumValidator"/>
                                </h:inputText>
                            </td>
                            <td>
                                <h:message styleClass="error" for="login"/>
                            </td>
                        <tr>
                            <td>
                                <h:outputText value="#{msg.desiredpassword}"/>
                            </td>
                            <td>
                                <h:inputSecret id="password" value="#{userBean.password}"  required="true" requiredMessage="#{msg.field_reqd}">
                                    <f:validateLength minimum="6"/>
                                </h:inputSecret>
                            </td>
                            <td>
                                <h:message styleClass="error" for="password"/>
                            </td>
                        </tr>
                        <tr><td colspan="3"/></tr>
                        <tr>
                            <td></td>
                            <td align="left">
                                <h:commandButton id="submit"
                                                 value="#{msg.create}"
                                                 action="#{userBean.registerUser}"/>
                            </td>
                            <td></td>
                    </table>
                </h:form>
            </center>
            <script>
                document.getElementById('userform:firstName').focus();
            </script>
        </body>
    </html>
</f:view>
