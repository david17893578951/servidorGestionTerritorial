package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the gtr_contrato_asignacion database table.
 * 
 */
@Entity
@Table(name="gtr_contrato_asignacion")
@NamedQuery(name="ContratoAsignacion.findAll", query="SELECT c FROM ContratoAsignacion c")
public class ContratoAsignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_CONTRATO_ASIGNACION_ID_GENERATOR", sequenceName="GTR_CONTRATO_ASIGNACION_CAS_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_CONTRATO_ASIGNACION_ID_GENERATOR")
	@Column(name="cas_id")
	private Integer id;

	@Column(name="cas_arrendador")
	private String arrendador;

	@Column(name="cas_arrendatario")
	private String arrendatario;

	@Column(name="cas_codigo_contrato")
	private String codigoContrato;

	@Column(name="cas_estado")
	private String estado;

	@Column(name="cas_fecha_fin")
	private Timestamp fechaFin;

	@Column(name="cas_fecha_finalizacion")
	private Timestamp fechaFinalizacion;

	@Column(name="cas_fecha_inicio")
	private Timestamp fechaInicio;

	@Column(name="cas_fecha_creacion_contrato")
	private Timestamp fechaCreacionContrato;

	@Column(name="cas_numero_alicuotas")
	private Integer numeroAlicuotas;

	@Column(name="cas_observaciones")
	private String observaciones;

	@Column(name="cas_periodicidad_pago")
	private BigDecimal periodicidadPago;

	@Column(name="cas_precio")
	private BigDecimal precio;

	@Column(name="cas_razon_terminacion_cont")
	private String razonTerminacionCont;

	@Column(name="cas_terminacion_contractual")
	private Boolean terminacionContractual;

	@Column(name="cas_tipo")
	private String tipo;

	
	//bi-directional many-to-one association to AdministradorContrato
	@OneToMany(mappedBy="gtrContratoAsignacion")
	@JsonIgnoreProperties(value={"gtrContratoAsignacion"},allowGetters=true)
	private List<AdministradorContrato> gtrAdministradorContratos;

	//bi-directional many-to-one association to AsignacionSuelo
	@ManyToOne
	@JoinColumn(name="sue_id")
	@JsonIgnoreProperties(value = { "gtrContratoAsignacions" })
	private AsignacionSuelo gtrAsignacionSuelo;

	//bi-directional many-to-one association to EntregablesContrato
	@OneToMany(mappedBy="gtrContratoAsignacion")
	@JsonIgnoreProperties(value={"gtrContratoAsignacion"},allowGetters=true)
	private List<EntregablesContrato> gtrEntregablesContratos;

	//bi-directional many-to-one association to Pago
	
	@OneToMany(mappedBy="gtrContratoAsignacion")
	private List<Pago> gtrPagos;

	public ContratoAsignacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArrendador() {
		return this.arrendador;
	}

	public void setArrendador(String arrendador) {
		this.arrendador = arrendador;
	}

	public String getArrendatario() {
		return this.arrendatario;
	}

	public void setArrendatario(String arrendatario) {
		this.arrendatario = arrendatario;
	}

	public String getCodigoContrato() {
		return this.codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Timestamp getFechaFinalizacion() {
		return this.fechaFinalizacion;
	}

	public void setFechaFinalizacion(Timestamp fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaCreacionContrato() {
		return this.fechaCreacionContrato;
	}

	public void setFechaSubidaContrato(Timestamp fechaSubidaContrato) {
		this.fechaCreacionContrato = fechaSubidaContrato;
	}

	public Integer getNumeroAlicuotas() {
		return this.numeroAlicuotas;
	}

	public void setNumeroAlicuotas(Integer numeroAlicuotas) {
		this.numeroAlicuotas = numeroAlicuotas;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPeriodicidadPago() {
		return this.periodicidadPago;
	}

	public void setPeriodicidadPago(BigDecimal periodicidadPago) {
		this.periodicidadPago = periodicidadPago;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getRazonTerminacionCont() {
		return this.razonTerminacionCont;
	}

	public void setRazonTerminacionCont(String razonTerminacionCont) {
		this.razonTerminacionCont = razonTerminacionCont;
	}

	public Boolean getTerminacionContractual() {
		return this.terminacionContractual;
	}

	public void setTerminacionContractual(Boolean terminacionContractual) {
		this.terminacionContractual = terminacionContractual;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<AdministradorContrato> getGtrAdministradorContratos() {
		return this.gtrAdministradorContratos;
	}

	public void setGtrAdministradorContratos(List<AdministradorContrato> gtrAdministradorContratos) {
		this.gtrAdministradorContratos = gtrAdministradorContratos;
	}

	public AdministradorContrato addGtrAdministradorContrato(AdministradorContrato gtrAdministradorContrato) {
		getGtrAdministradorContratos().add(gtrAdministradorContrato);
		gtrAdministradorContrato.setGtrContratoAsignacion(this);

		return gtrAdministradorContrato;
	}

	public AdministradorContrato removeGtrAdministradorContrato(AdministradorContrato gtrAdministradorContrato) {
		getGtrAdministradorContratos().remove(gtrAdministradorContrato);
		gtrAdministradorContrato.setGtrContratoAsignacion(null);

		return gtrAdministradorContrato;
	}

	public AsignacionSuelo getGtrAsignacionSuelo() {
		return this.gtrAsignacionSuelo;
	}

	public void setGtrAsignacionSuelo(AsignacionSuelo gtrAsignacionSuelo) {
		this.gtrAsignacionSuelo = gtrAsignacionSuelo;
	}

	public List<EntregablesContrato> getGtrEntregablesContratos() {
		return this.gtrEntregablesContratos;
	}

	public void setGtrEntregablesContratos(List<EntregablesContrato> gtrEntregablesContratos) {
		this.gtrEntregablesContratos = gtrEntregablesContratos;
	}

	public EntregablesContrato addGtrEntregablesContrato(EntregablesContrato gtrEntregablesContrato) {
		getGtrEntregablesContratos().add(gtrEntregablesContrato);
		gtrEntregablesContrato.setGtrContratoAsignacion(this);

		return gtrEntregablesContrato;
	}

	public EntregablesContrato removeGtrEntregablesContrato(EntregablesContrato gtrEntregablesContrato) {
		getGtrEntregablesContratos().remove(gtrEntregablesContrato);
		gtrEntregablesContrato.setGtrContratoAsignacion(null);

		return gtrEntregablesContrato;
	}

	public List<Pago> getGtrPagos() {
		return this.gtrPagos;
	}

	public void setGtrPagos(List<Pago> gtrPagos) {
		this.gtrPagos = gtrPagos;
	}

	public Pago addGtrPago(Pago gtrPago) {
		getGtrPagos().add(gtrPago);
		gtrPago.setGtrContratoAsignacion(this);

		return gtrPago;
	}

	public Pago removeGtrPago(Pago gtrPago) {
		getGtrPagos().remove(gtrPago);
		gtrPago.setGtrContratoAsignacion(null);

		return gtrPago;
	}

}