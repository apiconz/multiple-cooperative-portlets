package pe.apiconz.portlet.test.modulo1;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping(value = "VIEW")
public class PortletUnoController {

	private static Logger logger = Logger.getLogger(PortletUnoController.class
			.getCanonicalName());

	@RenderMapping
	public String inicio(ModelMap modelMap, RenderRequest request,
			RenderResponse response) {
		logger.debug("--> inicio");

		if (request.isRequestedSessionIdValid()) {
			PortletSession session = request.getPortletSession();
			String numeroAsession = (String) session.getAttribute(
					"numeroAsession", PortletSession.APPLICATION_SCOPE);

			if (numeroAsession != null && !numeroAsession.isEmpty()) {
				session.setAttribute("launchEvent", "true",
						PortletSession.APPLICATION_SCOPE);
				logger.debug("numeroAsession=" + numeroAsession);
				return "insesion2";
			}
		}

		return "index";
	}

	@ActionMapping(params = "action=enviarA")
	public void procesarAccionA(ModelMap modelMap, ActionRequest request,
			ActionResponse response) {
		logger.debug("--> procesarAccionA");

		String numeroA = request.getParameter("numeroA");
		logger.debug("numeroA=" + numeroA);
		PortletSession session = request.getPortletSession();
		session.setAttribute("numeroAsession", numeroA,
				PortletSession.APPLICATION_SCOPE);
		response.setRenderParameter("render", "render");
	}

	@ActionMapping(params = "action=enviarB")
	public void procesarAccionB(ModelMap modelMap, ActionRequest request,
			ActionResponse response) {
		logger.debug("--> procesarAccionB");

		String numeroA = request.getParameter("numeroB");
		logger.debug("numeroA=" + numeroA);

		if (request.isRequestedSessionIdValid()) {

			logger.debug("Si hay sesion valida");
			
			PortletSession session = request.getPortletSession();
			session.setAttribute("numeroAsession", numeroA,
					PortletSession.APPLICATION_SCOPE);

			QName eventName = new QName("http://pe.apiconz.portlet.events",
					"datoEventB");
			response.setEvent(eventName, numeroA);
			logger.debug("Se establecio evento");

		}

		logger.debug("<-- procesarAccionB");
		response.setRenderParameter("render", "render");
	}

	@RenderMapping(params = "render=render")
	public String renderPortlet(ModelMap modelMap, RenderRequest request,
			RenderResponse response) {

		logger.debug("--> renderPortlet");

		if (request.isRequestedSessionIdValid()) {
			PortletSession session = request.getPortletSession();
			String numeroAsession = (String) session.getAttribute(
					"numeroAsession", PortletSession.APPLICATION_SCOPE);

			if (numeroAsession != null && !numeroAsession.isEmpty()) {

				logger.debug("numeroAsession=" + numeroAsession);
				return "insesion";
			}
		}

		return "index";
	}

	@ActionMapping(params = "action=execAction")
	public void lanzarEvento(ModelMap modelMap, ActionRequest request,
			ActionResponse response) {
		logger.debug("--> lanzarEvento");

		if (request.isRequestedSessionIdValid()) {
			PortletSession session = request.getPortletSession();
			String numeroAsession = (String) session.getAttribute(
					"numeroAsession", PortletSession.APPLICATION_SCOPE);
			session.removeAttribute("launchEvent");
			QName eventName = new QName("http://pe.apiconz.portlet.events",
					"datoEvent");
			response.setEvent(eventName, numeroAsession);

		}

		response.setRenderParameter("render", "render");
	}

}
