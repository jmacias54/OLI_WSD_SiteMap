/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.sitemap.model;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NotaDTO {

	private String fcIdContenido;
	private String fcTitulo;
	private String fcLinkDetalle;
	// private String fcNombre;
	private String fcFechaModificacion;
	private String fcFechaPubli;
	private String fcKeyWords;

	/**
	 * 
	 */
	public NotaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFcIdContenido() {
		return fcIdContenido;
	}

	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	public String getFcTitulo() {
		return fcTitulo;
	}

	public void setFcTitulo(String fcTitulo) {
		this.fcTitulo = fcTitulo;
	}

	public String getFcLinkDetalle() {
		return fcLinkDetalle;
	}

	public void setFcLinkDetalle(String fcLinkDetalle) {
		this.fcLinkDetalle = fcLinkDetalle;
	}

	public String getFcFechaModificacion() {
		return fcFechaModificacion;
	}

	public void setFcFechaModificacion(String fcFechaModificacion) {
		this.fcFechaModificacion = fcFechaModificacion;
	}

	public String getFcFechaPubli() {
		return fcFechaPubli;
	}

	public void setFcFechaPubli(String fcFechaPubli) {
		this.fcFechaPubli = fcFechaPubli;
	}

	public String getFcKeyWords() {
		return fcKeyWords;
	}

	public void setFcKeyWords(String fcKeyWords) {
		this.fcKeyWords = fcKeyWords;
	}

	@Override
	public String toString() {
		return "NotaDTO [fcIdContenido=" + fcIdContenido + ", fcTitulo=" + fcTitulo + ", fcLinkDetalle=" + fcLinkDetalle
				+ ", fcFechaModificacion=" + fcFechaModificacion + ", fcFechaPubli=" + fcFechaPubli + ", fcKeyWords="
				+ fcKeyWords + "]";
	}

}
