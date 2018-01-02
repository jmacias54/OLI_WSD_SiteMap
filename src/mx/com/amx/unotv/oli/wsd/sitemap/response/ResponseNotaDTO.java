/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.sitemap.response;

import java.util.List;

import mx.com.amx.unotv.oli.wsd.sitemap.model.NotaDTO;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class ResponseNotaDTO {

	private List<NotaDTO> lista;

	/**
	 * Obtiene el valor de lista.
	 * @return valor de lista.
	 */
	public List<NotaDTO> getLista() {
		return lista;
	}

	/**
	 * Asigna el valor de lista.
	 * @param lista valor de lista.
	 */
	public void setLista(List<NotaDTO> lista) {
		this.lista = lista;
	}
}
