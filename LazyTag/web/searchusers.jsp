<%-- 
    Document   : searchUser
    Created on : Mar 17, 2011, 9:21:34 PM
    Author     : Priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Search User</title>
            <link href="stylesheet.css" rel="stylesheet" type="text/css" />
        </head>
        <body leftmargin="0" rightmargin="0" topmargin="10" bottommargin="0">
            <center>
                <h:form id="searchuser">
                    <table width="100%">
                        <tr><td align="right"><h:commandLink action="#{userListBean.logout}" value="#{msg.logout}"/></td></tr>
                        <tr height="30px"><td></td></tr>
                    </table>
                    <h:panelGrid rendered="#{userListBean.displaySearch}" styleClass="table1" width="800px" columns="4" headerClass="title">
                        <f:facet name="header">
                            <h:outputText value="#{msg.searchuser}"/>
                        </f:facet>
                        <h:outputText value=" "/>
                        <h:outputText value=" "/>
                        <h:outputText value=" "/>
                        <h:outputText value=" "/>
                        <h:outputText value="#{msg.firstname}"/>
                        <h:inputText id="firstName" value="#{userListBean.firstName}"/>
                        <h:outputText value="#{msg.lastname}"/>
                        <h:inputText id="lastName" value="#{userListBean.lastName}"/>
                        <h:outputText value="#{msg.email}"/>
                        <h:inputText id="email" value="#{userListBean.email}"/>
                        <h:outputText value="#{msg.login1}"/>
                        <h:inputText id="login" value="#{userListBean.login}"/>
                        <h:commandButton id="submit"
                                         value="#{msg.search}"
                                         action="#{userListBean.searchUser}"/>
                    </h:panelGrid>
                    <br><br><br>
                    <t:dataTable id="userTable" value="#{userListBean.userList}" var="userData"
                                 styleClass="table1" rowClasses="oddRow,evenRow" rows="#{msg.rows}" width="800px" rules="COLS" border="2">
                        <t:column sortable="true" defaultSorted="asc" style="border=10;">
                            <f:facet name="header">
                                <t:commandSortHeader columnName="firstName" arrow="false" styleClass="headerRow">
                                    <h:outputLabel value="#{msg.firstname1}"/>
                                </t:commandSortHeader>
                            </f:facet>
                            <h:outputText value="#{userData.firstName}"/>
                        </t:column>
                        <t:column sortable="true">
                            <f:facet name="header">
                                <t:commandSortHeader columnName="lastName" arrow="false"  styleClass="headerRow">
                                    <h:outputLabel value="#{msg.lastname1}"/>
                                </t:commandSortHeader>
                            </f:facet>
                            <h:outputText value="#{userData.lastName}"/>
                        </t:column>
                        <t:column>
                            <f:facet name="header">
                                <t:commandSortHeader columnName="login" arrow="false" styleClass="headerRow">
                                    <h:outputLabel value="#{msg.login1}"/>
                                </t:commandSortHeader>
                            </f:facet>
                            <h:outputText value="#{userData.login}"/>
                        </t:column>
                        <t:column>
                            <f:facet name="header">
                                <t:commandSortHeader columnName="email" arrow="false"   styleClass="headerRow">
                                    <h:outputLabel value="#{msg.email1}"/>
                                </t:commandSortHeader>
                            </f:facet>
                            <h:outputText value="#{userData.email}"/>
                        </t:column>
                    </t:dataTable>
                    <t:dataScroller id="scroller" for="userTable" paginator="true" paginatorMaxPages="50" 
                                    paginatorActiveColumnStyle="font-size:10px;font-weight:normal;"
                                    immediate="true"   styleClass="headerRow">
                    </t:dataScroller>
                </h:form>
            </center>
        </body>
    </html>
</f:view>
