package ec.edu.ups.entidades;

import java.io.Serializable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity

public class Empresa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmp;
	private String nomEmp;
	private String dirEmp;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaUsu")
	private Set<Usuario> usuario= new HashSet<Usuario>();
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaProd")
	private Set<Productos> productos = new HashSet<Productos>();;  
	
	public Empresa() {
		super();
	}

	public Empresa(String nomEmp, String dirEmp) {
		super();
		this.nomEmp = nomEmp;
		this.dirEmp = dirEmp;
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getDirEmp() {
		return dirEmp;
	}

	public void setDirEmp(String dirEmp) {
		this.dirEmp = dirEmp;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void addUsuario (Usuario usuario) {
		this.usuario.add(usuario);
	}
	
	public void removeUsuario (Usuario usuario) {
		this.usuario.remove(usuario);
	}
	
	public Set<Productos> getProductos() {
		return productos;
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}

	public void addProductos (Productos producto) {
		this.productos.add(producto);
	}
	
	public void removeProductos (Productos producto) {
		this.productos.remove(producto);
	}
	
	@Override
	public int hashCode() {
		return this.idEmp;
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
