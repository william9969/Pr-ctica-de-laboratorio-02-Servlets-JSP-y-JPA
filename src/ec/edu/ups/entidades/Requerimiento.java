package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Requerimiento
 *
 */
@Entity

public class Requerimiento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReq;
	
	@Temporal(TemporalType.DATE)
	private Calendar fecReq;
	
	private String autorizaReq;
	private String obserReq;
	private char estadoReq;
	
	@ManyToOne
	@JoinColumn
	private Usuario usuarioReq;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimientoDetReq")
	private Set<DetRequerimiento> detRequerimientos= new HashSet<DetRequerimiento>();

	public Requerimiento() {
		super();
	}
	
	
	public Requerimiento(int idReq, Calendar fecReq, String autorizaReq, String obserReq, char estadoReq) {
		super();
		this.idReq = idReq;
		this.fecReq = fecReq;
		this.autorizaReq = autorizaReq;
		this.obserReq = obserReq;
		this.estadoReq = estadoReq;
	}


	public Requerimiento(Calendar fecReq, String autorizaReq, String obserReq, char estadoReq) {
		super();
		this.fecReq = fecReq;
		this.autorizaReq = autorizaReq;
		this.obserReq = obserReq;
		this.estadoReq = estadoReq;
	}
	public int getIdReq() {
		return idReq;
	}
	public void setIdReq(int idReq) {
		this.idReq = idReq;
	}
	public Calendar getFecReq() {
		return fecReq;
	}
	public void setFecReq(Calendar fecReq) {
		this.fecReq = fecReq;
	}
	public String getAutorizaReq() {
		return autorizaReq;
	}
	public void setAutorizaReq(String autorizaReq) {
		this.autorizaReq = autorizaReq;
	}
	public String getObserReq() {
		return obserReq;
	}
	public void setObserReq(String obserReq) {
		this.obserReq = obserReq;
	}
	public char getEstadoReq() {
		return estadoReq;
	}
	public void setEstadoReq(char estadoReq) {
		this.estadoReq = estadoReq;
	}
	public Usuario getUsuarioReq() {
		return usuarioReq;
	}
	public void setUsuarioReq(Usuario usuarioReq) {
		this.usuarioReq = usuarioReq;
	}
	public Set<DetRequerimiento> getDetRequerimientos() {
		return detRequerimientos;
	}
	public void setDetRequerimientos(Set<DetRequerimiento> detRequerimientos) {
		this.detRequerimientos = detRequerimientos;
	}
	
	@Override
	public int hashCode() {
		return this.idReq;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return obj.hashCode() == this.hashCode();
	}
	
	
   
}
