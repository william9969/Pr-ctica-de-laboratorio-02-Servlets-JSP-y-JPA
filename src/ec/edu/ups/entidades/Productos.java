package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;



/**
 * Entity implementation class for Entity: Productos
 *
 */
@Entity

public class Productos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProd;
	
	private String nomProd;
	private Double precProd;
	private int cantProd;
	
	@ManyToOne
	@JoinColumn
	private CatProducto catProd;
	
	@ManyToOne
	@JoinColumn
	private Empresa empresaProd;
	
	public Productos() {
		super();
	}
	
	public Productos(int idProd, String nomProd, Double precProd, int cantProd) {
		super();
		this.idProd = idProd;
		this.nomProd = nomProd;
		this.precProd = precProd;
		this.cantProd = cantProd;
	}

	public Productos(String nomProd, Double precProd, int cantProd) {
		super();
		this.nomProd = nomProd;
		this.precProd = precProd;
		this.cantProd = cantProd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public Double getPrecProd() {
		return precProd;
	}



	public void setPrecProd(Double precProd) {
		this.precProd = precProd;
	}



	public int getCantProd() {
		return cantProd;
	}



	public void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}



	public CatProducto getCatProd() {
		return catProd;
	}



	public void setCatProd(CatProducto catProd) {
		this.catProd = catProd;
	}



	public Empresa getEmpresaProd() {
		return empresaProd;
	}



	public void setEmpresaProd(Empresa empresaProd) {
		this.empresaProd = empresaProd;
	}



	@Override
	public int hashCode() {
		return idProd;
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
