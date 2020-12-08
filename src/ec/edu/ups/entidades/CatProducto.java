package ec.edu.ups.entidades;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CatProducto
 *
 */
@Entity

public class CatProducto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCatProd;
	
	private String nomCatProd;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catProd")
	private Set<Productos> productos = new HashSet<Productos>();
	
	
	public CatProducto() {
		super();
	}

	public CatProducto(String nomCatProd) {
		super();
		this.nomCatProd = nomCatProd;
	}


	public int getIdCatProd() {
		return idCatProd;
	}


	public void setIdCatProd(int idCatProd) {
		this.idCatProd = idCatProd;
	}


	public String getNomCatProd() {
		return nomCatProd;
	}


	public void setNomCatProd(String nomCatProd) {
		this.nomCatProd = nomCatProd;
	}

	public Set<Productos> getProductos() {
		return productos;
	}

	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}
	
	public void addProductos (Productos productos) {
		this.productos.add(productos);
	}
	
	public void removeProduct (Productos productos) {
		this.productos.remove(productos); 
	}
	@Override
	public int hashCode() {
		return this.idCatProd;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return this.hashCode()==obj.hashCode();
	}
	
}
