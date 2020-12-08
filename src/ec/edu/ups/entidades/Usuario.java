package ec.edu.ups.entidades;

import java.io.Serializable;

import java.util.*;
import java.util.Set;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsu;
	
	private String nombreUsu;
	private String emailUsu;
	private String passUsu;
	private char tipoUsu;
	@ManyToOne
	@JoinColumn
	private Empresa empresaUsu;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioReq")
	private Set<Requerimiento> requerimientos = new HashSet<Requerimiento>();


	public Usuario() {
		super();
	}
	
	


	public Usuario(String nombreUsu, String emailUsu, String passUsu, char tipoUsu) {
		super();
		this.nombreUsu = nombreUsu;
		this.emailUsu = emailUsu;
		this.passUsu = passUsu;
		this.tipoUsu = tipoUsu;
	}




	public int getIdUsu() {
		return idUsu;
	}


	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}


	public String getNombreUsu() {
		return nombreUsu;
	}


	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}


	public String getEmailUsu() {
		return emailUsu;
	}


	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}


	public String getPassUsu() {
		return passUsu;
	}


	public void setPassUsu(String passUsu) {
		this.passUsu = passUsu;
	}


	public char getTipoUsu() {
		return tipoUsu;
	}


	public void setTipoUsu(char tipoUsu) {
		this.tipoUsu = tipoUsu;
	}


	public Empresa getEmpresaUsu() {
		return empresaUsu;
	}


	public void setEmpresaUsu(Empresa empresaUsu) {
		this.empresaUsu = empresaUsu;
	}


	public Set<Requerimiento> getRequerimientos() {
		return requerimientos;
	}


	public void setRequerimientos(Set<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
   
}
