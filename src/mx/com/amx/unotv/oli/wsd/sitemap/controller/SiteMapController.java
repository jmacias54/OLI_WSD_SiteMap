/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.sitemap.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.oli.wsd.sitemap.dao.SiteMapDAO;
import mx.com.amx.unotv.oli.wsd.sitemap.model.NotaDTO;
import mx.com.amx.unotv.oli.wsd.sitemap.response.ResponseNotaDTO;
import mx.com.amx.unotv.oli.wsd.sitemap.controller.exception.ControllerException;


/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("siteMap")
public class SiteMapController {
	
	private static Logger logger = Logger.getLogger(SiteMapController.class);
	
	@Autowired
	SiteMapDAO siteMapDAO;
	
	
	
	@RequestMapping(value = "/getElementosNewsSiteMap/{numElementos}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseNotaDTO getElementosNewsSiteMap(@PathVariable int numElementos, HttpServletResponse res) throws ControllerException {
		logger.info("--- getElementosNewsSiteMap [ SiteMapController ] --- ");

		ResponseNotaDTO response = new ResponseNotaDTO();
		try {
			logger.info("numElementos: " + numElementos);

			response.setLista(siteMapDAO.getElementosNewsSiteMap(numElementos));

		} catch (Exception e) {
			logger.error("Error getElementosNewsSiteMap [ SiteMapController ] ", e);
			throw new ControllerException("Error getElementosNewsSiteMap [ SiteMapController ] " +e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/getElementosInsertar/{numElementos}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public List<NotaDTO> getElementosInsertar(@PathVariable int numElementos, HttpServletResponse response) throws ControllerException {
		logger.info("--- getElementosInsertar [ SiteMapController ] ---");

		ArrayList<NotaDTO> listElementosInsertar = new ArrayList<NotaDTO>();

		try {
			logger.info("numElementos: " + numElementos);
			listElementosInsertar = (ArrayList<NotaDTO>) siteMapDAO.getElementosInsertar(numElementos);

		} catch (Exception e) {
			logger.error("Error getElementosInsertar [ SiteMapController ] ", e);
			throw new ControllerException("Error getElementosNewsSiteMap [ SiteMapController ] " +e.getMessage());
			
		}

		return listElementosInsertar;
	}

	@RequestMapping(value = "/actualizarEstatusElemento", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Boolean actualizarEstatusElemento(@RequestBody String idContenido, HttpServletResponse response) throws ControllerException {
		logger.info("--- actualizarEstatusElemento [ SiteMapController ] ---");
		boolean respuesta = false;
		try {
			logger.info("idContenido: " + idContenido);
			respuesta = siteMapDAO.actualizarEstatusElemento(idContenido);

		} catch (Exception e) {
			logger.error("Error actualizarEstatusElemento [ SiteMapController ] ", e);
			throw new ControllerException("Error getElementosNewsSiteMap [ SiteMapController ] " +e.getMessage());
		}

		return respuesta;
	}

	@RequestMapping(value = "/getSecuencia", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Integer getSecuencia(HttpServletResponse response) throws mx.com.amx.unotv.oli.wsd.sitemap.controller.exception.ControllerException {
		logger.info("--- getSecuencia [ SiteMapController ] --- ");
		int secuencia = 0;
		try {

			secuencia = siteMapDAO.getSecuencia();

		} catch (Exception e) {
			logger.error("Error getSecuencia [ SiteMapController ] ", e);
			throw new ControllerException("Error getElementosNewsSiteMap [ SiteMapController ] " +e.getMessage());
		}

		return secuencia;
	}



}
