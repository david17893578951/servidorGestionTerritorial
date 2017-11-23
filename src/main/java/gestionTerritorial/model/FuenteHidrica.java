package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the gtr_fuente_hidrica database table.
 * 
 */
@Entity
@Table(name="gtr_fuente_hidrica")
@NamedQuery(name="FuenteHidrica.findAll", query="SELECT f FROM FuenteHidrica f")
public class FuenteHidrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_FUENTE_HIDRICA_ID_GENERATOR", sequenceName="GTR_FUENTE_HIDRICA_HID_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_FUENTE_HIDRICA_ID_GENERATOR")
	@Column(name="hid_id")
	private Integer id;

	@Column(name="hid_caudal_asignado")
	private String caudalAsignado;

	@Column(name="hid_concesion_fuente_hidrica")
	private String concesionFuenteHidrica;

	@Column(name="hid_cuadal_total")
	private String cuadalTotal;

	@Column(name="hid_estado")
	private String estado;

	@Column(name="hid_fuente_hidrica")
	private String fuenteHidrica;

	@Column(name="hid_responsable_concesion")
	private String responsableConcesion;

	//bi-directional many-to-one association to AsignacionSuelo
	@ManyToOne
	@JoinColumn(name="sue_id")
	@JsonIgnoreProperties(value = { "gtrFuenteHidricas", "gtrHistorialSeguimientos", "gtrContratoAsignacions" })
	private AsignacionSuelo gtrAsignacionSuelo;

	public FuenteHidrica() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaudalAsignado() {
		return this.caudalAsignado;
	}

	public void setCaudalAsignado(String caudalAsignado) {
		this.caudalAsignado = caudalAsignado;
	}

	public String getConcesionFuenteHidrica() {
		return this.concesionFuenteHidrica;
	}

	public void setConcesionFuenteHidrica(String concesionFuenteHidrica) {
		this.concesionFuenteHidrica = concesionFuenteHidrica;
	}

	public String getCuadalTotal() {
		return this.cuadalTotal;
	}

	public void setCuadalTotal(String cuadalTotal) {
		this.cuadalTotal = cuadalTotal;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFuenteHidrica() {
		return this.fuenteHidrica;
	}

	public void setFuenteHidrica(String fuenteHidrica) {
		this.fuenteHidrica = fuenteHidrica;
	}

	public String getResponsableConcesion() {
		return this.responsableConcesion;
	}

	public void setResponsableConcesion(String responsableConcesion) {
		this.responsableConcesion = responsableConcesion;
	}

	public AsignacionSuelo getGtrAsignacionSuelo() {
		return this.gtrAsignacionSuelo;
	}

	public void setGtrAsignacionSuelo(AsignacionSuelo gtrAsignacionSuelo) {
		this.gtrAsignacionSuelo = gtrAsignacionSuelo;
	}

}