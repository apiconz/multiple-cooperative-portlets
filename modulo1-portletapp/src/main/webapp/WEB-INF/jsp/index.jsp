<%@ page contentType="text/html"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<portlet:defineObjects />
<portlet:actionURL var="accionAURL">
    <portlet:param name="action" value="enviarA" />
</portlet:actionURL>
<portlet:actionURL var="accionBURL">
    <portlet:param name="action" value="enviarB" />
</portlet:actionURL>

Formulario A
<form action="${accionAURL}" method="post">
    <input type="text" name="numeroA" />
    <input type="submit" value="Enviar" />
</form>


Formulario B
<form action="${accionBURL}" method="post">
    <input type="text" name="numeroB" />
    <input type="submit" value="Enviar" />
</form>


