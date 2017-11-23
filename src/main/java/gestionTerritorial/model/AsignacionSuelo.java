package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gtr_asignacion_suelo database table.
 * 
 */
@Entity
@Table(name="gtr_asignacion_suelo")
@NamedQuery(name="AsignacionSuelo.findAll", query="SELECT a FROM AsignacionSuelo a")
public class AsignacionSuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_ASIGNACION_SUELO_ID_GENERATOR", sequenceName="GTR_ASIGNACION_SUELO_SUE_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_ASIGNACION_SUELO_ID_GENERATOR")
	@Column(name="sue_id")
	private Integer id;

	@Column(name="sue_actividad")
	private String actividad;

	@Column(name="sue_aplica_politica_incentivos")
	private Boolean aplicaPoliticaIncentivos;

	@Column(name="sue_aplica_regulacion_ambiental")
	private Boolean aplicaRegulacionAmbiental;

	@Column(name="sue_asignacion")
	private String asignacion;

	@Column(name="sue_descripcion")
	private String descripcion;

	@Column(name="sue_direccion_responsable")
	private String direccionResponsable;

	@Column(name="sue_ente_aprobador")
	private String enteAprobador;

	@Column(name="sue_estado")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="sue_fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="sue_fecha_inicio")
	private Date fechaInicio;

	@Column(name="sue_figura_legal")
	private String figuraLegal;

	@Column(name="sue_nombre")
	private String nombre;

	@Column(name="sue_numero_anios")
	private Integer numeroAnios;

	@Column(name="sue_obs_politica_incentivos")
	private String obsPoliticaIncentivos;

	@Column(name="sue_observacion")
	private String observacion;

	@Column(name="sue_responsable")
	private String responsable;

	@Column(name="sue_superficie_asignada")
	private BigDecimal superficieAsignada;

	@Column(name="sue_superficie_solicitada")
	private BigDecimal superficieSolicitada;

	@Column(name="sue_tipo")
	private String tipo;

	@Column(name="sue_tipo_regulacion")
	private String tipoRegulacion;

	@Column(name="sue_unidad_sup_asignada")
	private String unidadSupAsignada;

	@Column(name="sue_unidad_sup_solicitada")
	private String unidadSupSolicitada;

	@Column(name="sue_unidad_tiempo")
	private String unidadTiempo;

	//bi-directional many-to-one association to Zona
	@ManyToOne
	@JoinColumn(name="zon_id")
	@JsonIgnoreProperties(value = { "gtrAsignacionSuelos" })
	private Zona gtrZona;

	//bi-directional many-to-one association to ContratoAsignacion
	@OneToMany(mappedBy="gtrAsignacionSuelo")
	@JsonIgnoreProperties(value={"gtrAsignacionSuelo"},allowGetters=true)
	private List<ContratoAsignacion> gtrContratoAsignacions;

	//bi-directional many-to-one association to FuenteHidrica
	@OneToMany(mappedBy="gtrAsignacionSuelo")
	@JsonIgnoreProperties(value={"gtrAsignacionSuelo"}, allowGetters=true)
	private List<FuenteHidrica> gtrFuenteHidricas;

	//bi-directional many-to-one association to HistorialSeguimiento
	@OneToMany(mappedBy="gtrAsignacionSuelo")
	@JsonIgnoreProperties(value={"gtrAsignacionSuelo"},allowGetters=true)
	private List<HistorialSeguimiento> gtrHistorialSeguimientos;

	public AsignacionSuelo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public Boolean getAplicaPoliticaIncentivos() {
		return this.aplicaPoliticaIncentivos;
	}

	public void setAplicaPoliticaIncentivos(Boolean aplicaPoliticaIncentivos) {
		this.aplicaPoliticaIncentivos = aplicaPoliticaIncentivos;
	}

	public Boolean getAplicaRegulacionAmbiental() {
		return this.aplicaRegulacionAmbiental;
	}

	public void setAplicaRegulacionAmbiental(Boolean aplicaRegulacionAmbiental) {
		this.aplicaRegulacionAmbiental = aplicaRegulacionAmbiental;
	}

	public String getAsignacion() {
		return this.asignacion;
	}

	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccionResponsable() {
		return this.direccionResponsable;
	}

	public void setDireccionResponsable(String direccionResponsable) {
		this.direccionResponsable = direccionResponsable;
	}

	public String getEnteAprobador() {
		return this.enteAprobador;
	}

	public void setEnteAprobador(String enteAprobador) {
		this.enteAprobador = enteAprobador;
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

	public String getFiguraLegal() {
		return this.figuraLegal;
	}

	public void setFiguraLegal(String figuraLegal) {
		this.figuraLegal = figuraLegal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroAnios() {
		return this.numeroAnios;
	}

	public void setNumeroAnios(Integer numeroAnios) {
		this.numeroAnios = numeroAnios;
	}

	public String getObsPoliticaIncentivos() {
		return this.obsPoliticaIncentivos;
	}

	public void setObsPoliticaIncentivos(String obsPoliticaIncentivos) {
		this.obsPoliticaIncentivos = obsPoliticaIncentivos;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public BigDecimal getSuperficieAsignada() {
		return this.superficieAsignada;
	}

	public void setSuperficieAsignada(BigDecimal superficieAsignada) {
		this.superficieAsignada = superficieAsignada;
	}

	public BigDecimal getSuperficieSolicitada() {
		return this.superficieSolicitada;
	}

	public void setSuperficieSolicitada(BigDecimal superficieSolicitada) {
		this.superficieSolicitada = superficieSolicitada;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoRegulacion() {
		return this.tipoRegulacion;
	}

	public void setTipoRegulacion(String tipoRegulacion) {
		this.tipoRegulacion = tipoRegulacion;
	}

	public String getUnidadSupAsignada() {
		return this.unidadSupAsignada;
	}

	public void setUnidadSupAsignada(String unidadSupAsignada) {
		this.unidadSupAsignada = unidadSupAsignada;
	}

	public String getUnidadSupSolicitada() {
		return this.unidadSupSolicitada;
	}

	public void setUnidadSupSolicitada(String unidadSupSolicitada) {
		this.unidadSupSolicitada = unidadSupSolicitada;
	}

	public String getUnidadTiempo() {
		return this.unidadTiempo;
	}

	public void setUnidadTiempo(String unidadTiempo) {
		this.unidadTiempo = unidadTiempo;
	}

	public Zona getGtrZona() {
		return this.gtrZona;
	}

	public void setGtrZona(Zona gtrZona) {
		this.gtrZona = gtrZona;
	}

	public List<ContratoAsignacion> getGtrContratoAsignacions() {
		return this.gtrContratoAsignacions;
	}

	public void setGtrContratoAsignacions(List<ContratoAsignacion> gtrContratoAsignacions) {
		this.gtrContratoAsignacions = gtrContratoAsignacions;
	}

	public ContratoAsignacion addGtrContratoAsignacion(ContratoAsignacion gtrContratoAsignacion) {
		getGtrContratoAsignacions().add(gtrContratoAsignacion);
		gtrContratoAsignacion.setGtrAsignacionSuelo(this);

		return gtrContratoAsignacion;
	}

	public ContratoAsignacion removeGtrContratoAsignacion(ContratoAsignacion gtrContratoAsignacion) {
		getGtrContratoAsignacions().remove(gtrContratoAsignacion);
		gtrContratoAsignacion.setGtrAsignacionSuelo(null);

		return gtrContratoAsignacion;
	}

	public List<FuenteHidrica> getGtrFuenteHidricas() {
		return this.gtrFuenteHidricas;
	}

	public void setGtrFuenteHidricas(List<FuenteHidrica> gtrFuenteHidricas) {
		this.gtrFuenteHidricas = gtrFuenteHidricas;
	}

	public FuenteHidrica addGtrFuenteHidrica(FuenteHidrica gtrFuenteHidrica) {
		getGtrFuenteHidricas().add(gtrFuenteHidrica);
		gtrFuenteHidrica.setGtrAsignacionSuelo(this);

		return gtrFuenteHidrica;
	}

	public FuenteHidrica removeGtrFuenteHidrica(FuenteHidrica gtrFuenteHidrica) {
		getGtrFuenteHidricas().remove(gtrFuenteHidrica);
		gtrFuenteHidrica.setGtrAsignacionSuelo(null);

		return gtrFuenteHidrica;
	}

	public List<HistorialSeguimiento> getGtrHistorialSeguimientos() {
		return this.gtrHistorialSeguimientos;
	}

	public void setGtrHistorialSeguimientos(List<HistorialSeguimiento> gtrHistorialSeguimientos) {
		this.gtrHistorialSeguimientos = gtrHistorialSeguimientos;
	}

	public HistorialSeguimiento addGtrHistorialSeguimiento(HistorialSeguimiento gtrHistorialSeguimiento) {
		getGtrHistorialSeguimientos().add(gtrHistorialSeguimiento);
		gtrHistorialSeguimiento.setGtrAsignacionSuelo(this);

		return gtrHistorialSeguimiento;
	}

	public HistorialSeguimiento removeGtrHistorialSeguimiento(HistorialSeguimiento gtrHistorialSeguimiento) {
		getGtrHistorialSeguimientos().remove(gtrHistorialSeguimiento);
		gtrHistorialSeguimiento.setGtrAsignacionSuelo(null);

		return gtrHistorialSeguimiento;
	}

}