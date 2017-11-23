package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the gtr_documento database table.
 * 
 */
@Entity
@Table(name="gtr_documento")
@NamedQuery(name="Documento.findAll", query="SELECT d FROM Documento d")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_DOCUMENTO_ID_GENERATOR", sequenceName="GTR_DOCUMENTO_DOC_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_DOCUMENTO_ID_GENERATOR")
	@Column(name="doc_id")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="doc_fecha_establecida")
	private Date fechaEstablecida;

	@Column(name="doc_fecha_hora_subido")
	private Timestamp fechaHoraSubido;

	@Column(name="doc_informacion")
	private String informacion;

	@Column(name="doc_usua_responsable")
	private String usuaResponsable;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tdo_id")
	private TipoDocumento gtrTipoDocumento;

	public Documento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaEstablecida() {
		return this.fechaEstablecida;
	}

	public void setFechaEstablecida(Date fechaEstablecida) {
		this.fechaEstablecida = fechaEstablecida;
	}

	public Timestamp getFechaHoraSubido() {
		return this.fechaHoraSubido;
	}

	public void setFechaHoraSubido(Timestamp fechaHoraSubido) {
		this.fechaHoraSubido = fechaHoraSubido;
	}

	public String getInformacion() {
		return this.informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getUsuaResponsable() {
		return this.usuaResponsable;
	}

	public void setUsuaResponsable(String usuaResponsable) {
		this.usuaResponsable = usuaResponsable;
	}

	public TipoDocumento getGtrTipoDocumento() {
		return this.gtrTipoDocumento;
	}

	public void setGtrTipoDocumento(TipoDocumento gtrTipoDocumento) {
		this.gtrTipoDocumento = gtrTipoDocumento;
	}

}