package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: DetRequerimiento
 *
 */
@Entity

public class DetRequerimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetReq;
	
	private int cantProDetReq;//Cantidad que Requiere del Producto
	private int idProdDetReq;//Id del Producto que Requiere
	private int invenProdDetReq;//Inventario del producto que Requiere
	private double precProdDetReq;// Precio del producto que Requiere
	private int desProdDetReq;//Porcentaje de Descuento
	
	@ManyToOne
	@JoinColumn
	private Requerimiento requerimientoDetReq; 
	
	
	public DetRequerimiento() {
		super();
	}


	public DetRequerimiento(int cantProDetReq, int idProdDetReq, int invenProdDetReq, double precProdDetReq,
			int desProdDetReq) {
		super();
		this.cantProDetReq = cantProDetReq;
		this.idProdDetReq = idProdDetReq;
		this.invenProdDetReq = invenProdDetReq;
		this.precProdDetReq = precProdDetReq;
		this.desProdDetReq = desProdDetReq;
	}


	public int getIdDetReq() {
		return idDetReq;
	}


	public void setIdDetReq(int idDetReq) {
		this.idDetReq = idDetReq;
	}


	public int getCantProDetReq() {
		return cantProDetReq;
	}


	public void setCantProDetReq(int cantProDetReq) {
		this.cantProDetReq = cantProDetReq;
	}


	public int getIdProdDetReq() {
		return idProdDetReq;
	}


	public void setIdProdDetReq(int idProdDetReq) {
		this.idProdDetReq = idProdDetReq;
	}


	public int getInvenProdDetReq() {
		return invenProdDetReq;
	}


	public void setInvenProdDetReq(int invenProdDetReq) {
		this.invenProdDetReq = invenProdDetReq;
	}


	public double getPrecProdDetReq() {
		return precProdDetReq;
	}


	public void setPrecProdDetReq(double precProdDetReq) {
		this.precProdDetReq = precProdDetReq;
	}


	public int getDesProdDetReq() {
		return desProdDetReq;
	}


	public void setDesProdDetReq(int desProdDetReq) {
		this.desProdDetReq = desProdDetReq;
	}


	public Requerimiento getRequerimientoDetReq() {
		return requerimientoDetReq;
	}


	public void setRequerimientoDetReq(Requerimiento requerimientoDetReq) {
		this.requerimientoDetReq = requerimientoDetReq;
	}


	@Override
	public int hashCode() {
		return this.idDetReq;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return this.hashCode()== obj.hashCode();
	}
	
	
   
}
