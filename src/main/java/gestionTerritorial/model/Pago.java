package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the gtr_pago database table.
 * 
 */
@Entity
@Table(name="gtr_pago")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_PAGO_ID_GENERATOR", sequenceName="GTR_PAGO_PAG_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_PAGO_ID_GENERATOR")
	@Column(name="pag_id")
	private Integer id;

	@Column(name="pag_base_imponible")
	private String baseImponible;

	@Column(name="pag_descripcion")
	private String descripcion;

	@Column(name="pag_fecha_pago_acordada")
	private Timestamp fechaPagoAcordada;

	@Column(name="pag_fecha_pago_efectivo")
	private Timestamp fechaPagoEfectivo;

	@Column(name="pag_iva")
	private BigDecimal iva;

	@Column(name="pag_mes")
	private String mes;

	@Column(name="pag_multas")
	private BigDecimal multas;

	@Column(name="pag_num_dias_retraso")
	private BigDecimal numDiasRetraso;

	@Column(name="pag_observacion")
	private String observacion;

	@Column(name="pag_pago_registrado")
	private Boolean pagoRegistrado;

	@Column(name="pag_tipo_pago")
	private String tipoPago;

	//bi-directional many-to-one association to ContratoAsignacion
	@ManyToOne
	@JoinColumn(name="cas_id")
	private ContratoAsignacion gtrContratoAsignacion;

	public Pago() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBaseImponible() {
		return this.baseImponible;
	}

	public void setBaseImponible(String baseImponible) {
		this.baseImponible = baseImponible;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechaPagoAcordada() {
		return this.fechaPagoAcordada;
	}

	public void setFechaPagoAcordada(Timestamp fechaPagoAcordada) {
		this.fechaPagoAcordada = fechaPagoAcordada;
	}

	public Timestamp getFechaPagoEfectivo() {
		return this.fechaPagoEfectivo;
	}

	public void setFechaPagoEfectivo(Timestamp fechaPagoEfectivo) {
		this.fechaPagoEfectivo = fechaPagoEfectivo;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getMes() {
		return this.mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public BigDecimal getMultas() {
		return this.multas;
	}

	public void setMultas(BigDecimal multas) {
		this.multas = multas;
	}

	public BigDecimal getNumDiasRetraso() {
		return this.numDiasRetraso;
	}

	public void setNumDiasRetraso(BigDecimal numDiasRetraso) {
		this.numDiasRetraso = numDiasRetraso;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Boolean getPagoRegistrado() {
		return this.pagoRegistrado;
	}

	public void setPagoRegistrado(Boolean pagoRegistrado) {
		this.pagoRegistrado = pagoRegistrado;
	}

	public String getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public ContratoAsignacion getGtrContratoAsignacion() {
		return this.gtrContratoAsignacion;
	}

	public void setGtrContratoAsignacion(ContratoAsignacion gtrContratoAsignacion) {
		this.gtrContratoAsignacion = gtrContratoAsignacion;
	}

}