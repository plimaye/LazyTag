<%--
    Document   : searchUser
    Created on : July 16, 2011, 9:21:34 PM
    Author     : Priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<%@taglib prefix="a4j" uri="https://ajax4jsf.dev.java.net/ajax"%>

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
                        <a4j:commandButton id="submit"
                                           value="#{msg.search}"
                                           action="#{userListBean.searchUser}"
                                           reRender="eheader"/>
                    </h:panelGrid>
                    <br><br><br>
                    <a4j:outputPanel id="eheader" >

                        <t:dataTable id="userTable" value="#{userListBean.userList}" var="userData"
                                     styleClass="table1" rowClasses="oddRow,evenRow" width="800px" rules="COLS" border="2">
                            <t:column style="border=10;">
                                <f:facet name="header">
                                    <a4j:commandLink value="#{msg.firstname1}" action="#{userListBean.changeSorting}" styleClass="headerRow" reRender="eheader">
                                        <f:param name="sortParam" value="firstName" />
                                    </a4j:commandLink>
                                </f:facet>
                                <h:outputText value="#{userData.firstName}"/>
                            </t:column>
                            <t:column>
                                <f:facet name="header">
                                    <a4j:commandLink value="#{msg.lastname1}" action="#{userListBean.changeSorting}" styleClass="headerRow" reRender="eheader">
                                        <f:param name="sortParam" value="lastName" />
                                    </a4j:commandLink>
                                </f:facet>
                                <h:outputText value="#{userData.lastName}"/>
                            </t:column>
                            <t:column>
                                <f:facet name="header">
                                    <a4j:commandLink value="#{msg.login1}" action="#{userListBean.changeSorting}" styleClass="headerRow" reRender="eheader">
                                        <f:param name="sortParam" value="login" />
                                    </a4j:commandLink>
                                </f:facet>
                                <h:outputText value="#{userData.login}"/>
                            </t:column>
                            <t:column>
                                <f:facet name="header">
                                    <a4j:commandLink value="#{msg.email1}" action="#{userListBean.changeSorting}" styleClass="headerRow" reRender="eheader">
                                        <f:param name="sortParam" value="email" />
                                    </a4j:commandLink>
                                </f:facet>
                                <h:outputText value="#{userData.email}"/>
                            </t:column>
                        </t:dataTable>
                        <a4j:commandButton value="<<" action="#{userListBean.getFirstPage}"  reRender="eheader"/>
                        <h:outputText value=" "/>
                        <a4j:commandButton value="<" action="#{userListBean.getPrevPage}" disabled="#{userListBean.currentPage == 1}" reRender="eheader" />
                        <h:outputText value=" "/>
                        <t:dataList value="#{userListBean.pages}" var="page">
                            <a4j:commandLink action="#{userListBean.searchUser}" value="#{page}"  reRender="eheader" rendered="#{userListBean.currentPage != page}">
                                <f:param name="currentPage" value="#{page}"/>
                            </a4j:commandLink>
                            <a4j:commandLink action="#{userListBean.searchUser}" value="#{page}"  reRender="eheader" rendered="#{userListBean.currentPage == page}"
                                             style="font-size:18px;font-weight:bold">
                                <f:param name="currentPage" value="#{page}"/>
                            </a4j:commandLink>
                            <h:outputText value=" "/>
                        </t:dataList>
                        <a4j:commandButton value=">" action="#{userListBean.getNextPage}" disabled="#{userListBean.currentPage == userListBean.numberOfPages}" reRender="eheader">
                        </a4j:commandButton>
                        <h:outputText value=" "/>
                        <a4j:commandButton value=">>" action="#{userListBean.getLastPage}" reRender="eheader"/>
                        <h:outputText value=" "/>

                    </a4j:outputPanel>

                </h:form>
            </center>
        </body>
    </html>
</f:view>
