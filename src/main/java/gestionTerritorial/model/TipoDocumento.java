package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gtr_tipo_documento database table.
 * 
 */
@Entity
@Table(name="gtr_tipo_documento")
@NamedQuery(name="TipoDocumento.findAll", query="SELECT t FROM TipoDocumento t")
public class TipoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_TIPO_DOCUMENTO_ID_GENERATOR", sequenceName="GTR_TIPO_DOCUMENTO_TDO_ID_SEQ",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_TIPO_DOCUMENTO_ID_GENERATOR")
	@Column(name="tdo_id")
	private Integer id;

	@Column(name="tdo_estado")
	private String estado;

	@Column(name="tdo_nombre")
	private String nombre;

	//bi-directional many-to-one association to Documento
	@OneToMany(mappedBy="gtrTipoDocumento")
	private List<Documento> gtrDocumentos;

	public TipoDocumento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Documento> getGtrDocumentos() {
		return this.gtrDocumentos;
	}

	public void setGtrDocumentos(List<Documento> gtrDocumentos) {
		this.gtrDocumentos = gtrDocumentos;
	}

	public Documento addGtrDocumento(Documento gtrDocumento) {
		getGtrDocumentos().add(gtrDocumento);
		gtrDocumento.setGtrTipoDocumento(this);

		return gtrDocumento;
	}

	public Documento removeGtrDocumento(Documento gtrDocumento) {
		getGtrDocumentos().remove(gtrDocumento);
		gtrDocumento.setGtrTipoDocumento(null);

		return gtrDocumento;
	}

}