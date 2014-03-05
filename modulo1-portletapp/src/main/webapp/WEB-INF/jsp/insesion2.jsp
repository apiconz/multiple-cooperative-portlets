<%@ page contentType="text/html"%>
<%@ page contentType="text/html" isELIgnored="false"
	import="javax.portlet.PortletSession"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<portlet:defineObjects />
<%@include file="jquery-dependencies.jsp"%>


<%
	String valor = (String) portletSession.getAttribute("launchEvent",
			PortletSession.APPLICATION_SCOPE);
%>
<portlet:actionURL var="accionURL">
	<portlet:param name="action" value="execAction" />
</portlet:actionURL>

<form action="${accionURL}" method="post" id="launchEvent"></form>

<script type="text/javascript">
    document.getElementById("launchEvent").submit();
    
</script>