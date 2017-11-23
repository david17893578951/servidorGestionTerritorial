package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the gtr_historial_seguimiento database table.
 * 
 */
@Entity
@Table(name="gtr_historial_seguimiento")
@NamedQuery(name="HistorialSeguimiento.findAll", query="SELECT h FROM HistorialSeguimiento h")
public class HistorialSeguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_HISTORIAL_SEGUIMIENTO_ID_GENERATOR", sequenceName="GTR_HISTORIAL_SEGUIMIENTO_HSE_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_HISTORIAL_SEGUIMIENTO_ID_GENERATOR")
	@Column(name="hse_id")
	private Integer id;

	@Column(name="hse_adjunto_doc")
	private String adjuntoDoc;

	@Column(name="hse_adjunto_fot")
	private String adjuntoFot;

	@Column(name="hse_estado")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="hse_fecha")
	private Date fecha;

	@Column(name="hse_fecha_registro")
	private Timestamp fechaRegistro;

	@Column(name="hse_novedades")
	private String novedades;

	@Column(name="hse_responsable")
	private String responsable;

	@Column(name="hse_usuario")
	private String usuario;

	//bi-directional many-to-one association to AsignacionSuelo
	@ManyToOne
	@JoinColumn(name="sue_id")
	@JsonIgnoreProperties(value = { "gtrHistorialSeguimientos","gtrFuenteHidricas", "gtrContratoAsignacions"  })
	private AsignacionSuelo gtrAsignacionSuelo;

	public HistorialSeguimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdjuntoDoc() {
		return this.adjuntoDoc;
	}

	public void setAdjuntoDoc(String adjuntoDoc) {
		this.adjuntoDoc = adjuntoDoc;
	}

	public String getAdjuntoFot() {
		return this.adjuntoFot;
	}

	public void setAdjuntoFot(String adjuntoFot) {
		this.adjuntoFot = adjuntoFot;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNovedades() {
		return this.novedades;
	}

	public void setNovedades(String novedades) {
		this.novedades = novedades;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public AsignacionSuelo getGtrAsignacionSuelo() {
		return this.gtrAsignacionSuelo;
	}

	public void setGtrAsignacionSuelo(AsignacionSuelo gtrAsignacionSuelo) {
		this.gtrAsignacionSuelo = gtrAsignacionSuelo;
	}

}