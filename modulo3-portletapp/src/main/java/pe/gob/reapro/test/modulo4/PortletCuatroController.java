package pe.gob.reapro.test.modulo4;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.EventMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping(value = "VIEW")
public class PortletCuatroController {

	private static Logger logger = Logger.getLogger(PortletCuatroController.class
			.getCanonicalName());

	@RenderMapping
	public String inicio(RenderRequest request, RenderResponse response) {
		logger.debug("--> inicio");

		logger.debug("<-- inicio");

		return "index";
	}
	
	@EventMapping(value = "{http://pe.apiconz.portlet.events}datoEventC")
	public void datoEvent(ModelMap modelMap, EventRequest request,
			EventResponse response) throws PortletException, IOException {

		logger.debug("--> datoEvent");

		Event event = request.getEvent();
		String numero = (String) event.getValue();

		logger.debug("numero=" + numero);
		modelMap.addAttribute("numero", numero);

		response.setRenderParameter("render", "successB");
	}

	@RenderMapping(params = "render=successB")
	public String successB(RenderRequest request, RenderResponse response) {
		logger.debug("--> successB");

		logger.debug("<-- successB");

		return "successB";
	}

}
