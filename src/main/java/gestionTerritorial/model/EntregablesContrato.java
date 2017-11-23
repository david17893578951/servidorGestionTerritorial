package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;


/**
 * The persistent class for the gtr_entregables_contrato database table.
 * 
 */
@Entity
@Table(name="gtr_entregables_contrato")
@NamedQuery(name="EntregablesContrato.findAll", query="SELECT e FROM EntregablesContrato e")
public class EntregablesContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_ENTREGABLES_CONTRATO_ID_GENERATOR", sequenceName="GTR_ENTREGABLES_CONTRATO_ECO_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_ENTREGABLES_CONTRATO_ID_GENERATOR")
	@Column(name="eco_id")
	private Integer id;

	@Column(name="eco_documento")
	private String documento;

	@Column(name="eco_estado")
	private String estado;

	@Column(name="eco_fecha_max_entrega")
	private Timestamp fechaMaxEntrega;

	@Column(name="eco_fecha_subida")
	private Timestamp fechaSubida;

	@Column(name="eco_nombre_entregable")
	private String nombreEntregable;

	@Column(name="eco_responsable")
	private String responsable;

	@Column(name="eco_usuario_subida")
	private String usuarioSubida;

	//bi-directional many-to-one association to ContratoAsignacion
	@ManyToOne
	@JoinColumn(name="cas_id")
	//@JsonIgnoreProperties(value = { "gtrEntregablesContratos" })
	@JsonIgnoreProperties(value = { "gtrEntregablesContratos", "gtrPagos", "gtrAdministradorContratos" })
	private ContratoAsignacion gtrContratoAsignacion;

	public EntregablesContrato() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaMaxEntrega() {
		return this.fechaMaxEntrega;
	}

	public void setFechaMaxEntrega(Timestamp fechaMaxEntrega) {
		this.fechaMaxEntrega = fechaMaxEntrega;
	}

	public Timestamp getFechaSubida() {
		return this.fechaSubida;
	}

	public void setFechaSubida(Timestamp fechaSubida) {
		this.fechaSubida = fechaSubida;
	}

	public String getNombreEntregable() {
		return this.nombreEntregable;
	}

	public void setNombreEntregable(String nombreEntregable) {
		this.nombreEntregable = nombreEntregable;
	}

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getUsuarioSubida() {
		return this.usuarioSubida;
	}

	public void setUsuarioSubida(String usuarioSubida) {
		this.usuarioSubida = usuarioSubida;
	}

	public ContratoAsignacion getGtrContratoAsignacion() {
		return this.gtrContratoAsignacion;
	}

	public void setGtrContratoAsignacion(ContratoAsignacion gtrContratoAsignacion) {
		this.gtrContratoAsignacion = gtrContratoAsignacion;
	}

}