/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.sitemap.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.amx.unotv.oli.wsd.sitemap.dao.exception.SiteMapDAOException;
import mx.com.amx.unotv.oli.wsd.sitemap.model.NotaDTO;


/**
 * @author Jesus A. Macias Benitez
 *
 */
public class SiteMapDAO {

	private static Logger logger = Logger.getLogger(SiteMapDAO.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<NotaDTO> getElementosNewsSiteMap(int numElementos) throws SiteMapDAOException {
		logger.debug(" --- getElementosNewsSiteMap [ SiteMapDAO ] ---- ");
		
		StringBuffer sql = new StringBuffer();
		try {
	
			sql.append(" SELECT DATE_FORMAT(H.FD_FECHA_MODIFICACION, '%Y-%m-%d') AS fcFechaModificacion,     ");
			sql.append(" DATE_FORMAT(H.FD_FECHA_MODIFICACION, '%Y-%m-%d') AS fcFechaPubli,    ");
			sql.append(" H.FC_ID_CONTENIDO as fcIdContenido,  ");
			sql.append(" H.FC_TITULO as fcTitulo,  ");
			sql.append(" H.FC_KEYWORDS as fcKeyWords, ");
			sql.append(" CONCAT('https://www.unotv.com/','pyeongchang/','noticias/','detalle/',COALESCE(H.FC_FRIENDLY_URL,'')) as fcLinkDetalle  ");
			sql.append(" FROM oli_mx_n_nota H,   oli_mx_c_categoria  C  ");
			sql.append(" WHERE  C.FC_ID_CATEGORIA=H.FC_ID_CATEGORIA  ");
			sql.append(" ORDER BY H.FD_FECHA_PUBLICACION DESC ");		
			sql.append(" LIMIT " + numElementos + " ");

			return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<NotaDTO>(NotaDTO.class));

		} catch (NullPointerException npe) {
			logger.error(" Error getElementosNewsSiteMap [ SiteMapDAO ]  ", npe);
			logger.error("Error SQL: " + sql);
			return Collections.emptyList();
		} catch (Exception e) {

			logger.error(" Error getElementosNewsSiteMap [ SiteMapDAO ]  ", e);
			logger.error("Error SQL: " + sql);

			throw new SiteMapDAOException(e.getMessage());

		}

	}
	
	
	public List<NotaDTO> getElementosInsertar(int numElementos) throws SiteMapDAOException {
		
		logger.debug(" --- getElementosInsertar [ SiteMapDAO ]  ---- ");
		
		StringBuffer sql = new StringBuffer();
		try {
			
			sql.append(" SELECT DATE_FORMAT(H.FD_FECHA_MODIFICACION, '%Y-%m-%d') AS fcFechaModificacion,     ");
			sql.append(" DATE_FORMAT(H.FD_FECHA_MODIFICACION, '%Y-%m-%d') AS fcFechaPubli,    ");
			sql.append(" H.FC_ID_CONTENIDO as fcIdContenido,  ");
			sql.append(" H.FC_TITULO as fcTitulo,  ");
			sql.append(" H.FC_KEYWORDS as fcKeyWords, ");
			sql.append(" CONCAT('https://www.unotv.com/','pyeongchang/','noticias/','detalle/',COALESCE(H.FC_FRIENDLY_URL,'')) as fcLinkDetalle  ");
			sql.append(" FROM oli_mx_h_nota H,   oli_mx_c_categoria  C  ");
			sql.append(" WHERE  C.FC_ID_CATEGORIA=H.FC_ID_CATEGORIA  ");
			sql.append(" ORDER BY H.FD_FECHA_PUBLICACION DESC ");		
			sql.append(" LIMIT " + numElementos + " ");

			return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<NotaDTO>(NotaDTO.class));

		} catch (NullPointerException npe) {
			logger.error(" Error getElementosInsertar [ SiteMapDAO ] ", npe);
			logger.error("Error SQL: " + sql);
			return Collections.emptyList();
		} catch (Exception e) {

			logger.error(" Error getElementosInsertar  [ SiteMapDAO ]  ", e);
			logger.error("Error SQL: " + sql);

			throw new SiteMapDAOException(e.getMessage());

		}

		
	}
	
	
	public boolean actualizarEstatusElemento(String id) {
		logger.debug(" --- actualizarEstatusElemento [ SiteMapDAO ]  ---- ");
		boolean bandera=true;
		try {			
			String strQuery = " UPDATE oli_mx_h_nota SET FI_BAN_OTROS=1 WHERE FC_ID_CONTENIDO  = ?";
			jdbcTemplate.update(strQuery, new Object[]{id});
			return bandera;
		} catch (Exception e) {
			logger.error(" Error actualizarEstatusElemento [ SiteMapDAO ] ",e );
			bandera=false;
			return bandera;
			
		}	
	}
	
	
	public Integer getSecuencia() throws SiteMapDAOException{
		logger.debug(" --- getSecuencia [ SiteMapDAO ]  ---- ");
		
		Integer secuencia = 0;
		
		try {
			final StringBuffer sb = new StringBuffer();				
			sb.append( " SELECT getNextSeqSiteMapOLI(); ");
			Object[] inputs = new Object[] {};
			secuencia =  jdbcTemplate.queryForObject(sb.toString(), inputs,Integer.class);
						
		} catch (Exception e) {
			secuencia = 0;
			logger.error(" Error getSecuencia [ SiteMapDAO ] ",e );		
			throw new SiteMapDAOException(e.getMessage());
		}
		return secuencia;
	}

}
