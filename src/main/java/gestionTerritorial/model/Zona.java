package gestionTerritorial.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the gtr_zonas database table.
 * 
 */
@Entity
@Table(name="gtr_zonas")
@NamedQuery(name="Zona.findAll", query="SELECT z FROM Zona z")
public class Zona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GTR_ZONAS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GTR_ZONAS_ID_GENERATOR")
	@Column(name="zon_id")
	private String id;

	@Column(name="zon_descripcion")
	private String descripcion;

	@Column(name="zon_estado")
	private String estado;

	@Column(name="zon_hectareas")
	private BigDecimal hectareas;

	@Column(name="zon_link_mapa")
	private String linkMapa;

	@Column(name="zon_link_pdf")
	private String linkPdf;

	@Column(name="zon_metros_cuadrados")
	private BigDecimal metrosCuadrados;

	@Column(name="zon_nombre")
	private String nombre;

	//bi-directional many-to-one association to AsignacionSuelo
	@OneToMany(mappedBy="gtrZona")
	@JsonIgnoreProperties(value={"gtrZona"}, allowGetters=true)
	private List<AsignacionSuelo> gtrAsignacionSuelos;

	public Zona() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getHectareas() {
		return this.hectareas;
	}

	public void setHectareas(BigDecimal hectareas) {
		this.hectareas = hectareas;
	}

	public String getLinkMapa() {
		return this.linkMapa;
	}

	public void setLinkMapa(String linkMapa) {
		this.linkMapa = linkMapa;
	}

	public String getLinkPdf() {
		return this.linkPdf;
	}

	public void setLinkPdf(String linkPdf) {
		this.linkPdf = linkPdf;
	}

	public BigDecimal getMetrosCuadrados() {
		return this.metrosCuadrados;
	}

	public void setMetrosCuadrados(BigDecimal metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AsignacionSuelo> getGtrAsignacionSuelos() {
		return this.gtrAsignacionSuelos;
	}

	public void setGtrAsignacionSuelos(List<AsignacionSuelo> gtrAsignacionSuelos) {
		this.gtrAsignacionSuelos = gtrAsignacionSuelos;
	}

	public AsignacionSuelo addGtrAsignacionSuelo(AsignacionSuelo gtrAsignacionSuelo) {
		getGtrAsignacionSuelos().add(gtrAsignacionSuelo);
		gtrAsignacionSuelo.setGtrZona(this);

		return gtrAsignacionSuelo;
	}

	public AsignacionSuelo removeGtrAsignacionSuelo(AsignacionSuelo gtrAsignacionSuelo) {
		getGtrAsignacionSuelos().remove(gtrAsignacionSuelo);
		gtrAsignacionSuelo.setGtrZona(null);

		return gtrAsignacionSuelo;
	}

}