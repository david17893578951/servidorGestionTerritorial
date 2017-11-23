package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the gtr_administrador_contrato database table.
 * 
 */
@Entity
@Table(name="gtr_administrador_contrato")
@NamedQuery(name="AdministradorContrato.findAll", query="SELECT a FROM AdministradorContrato a")
public class AdministradorContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_ADMINISTRADOR_CONTRATO_ID_GENERATOR", sequenceName="GTR_ADMINISTRADOR_CONTRATO_ADC_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_ADMINISTRADOR_CONTRATO_ID_GENERATOR")
	@Column(name="adc_id")
	private Integer id;

	@Column(name="adc_administrador")
	private String administrador;

	@Column(name="adc_direccion_adm")
	private String direccionAdm;

	@Column(name="adc_estado")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="adc_fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="adc_fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to ContratoAsignacion
	@ManyToOne
	@JoinColumn(name="cas_id")
	
	@JsonIgnoreProperties(value = { "gtrAdministradorContratos" })
	private ContratoAsignacion gtrContratoAsignacion;

	public AdministradorContrato() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getDireccionAdm() {
		return this.direccionAdm;
	}

	public void setDireccionAdm(String direccionAdm) {
		this.direccionAdm = direccionAdm;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public ContratoAsignacion getGtrContratoAsignacion() {
		return this.gtrContratoAsignacion;
	}

	public void setGtrContratoAsignacion(ContratoAsignacion gtrContratoAsignacion) {
		this.gtrContratoAsignacion = gtrContratoAsignacion;
	}

}