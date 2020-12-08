package ec.edu.ups.jpa;

import ec.edu.ups.entidades.CatProducto;
import ec.edu.ups.entidades.DetRequerimiento;

import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DetRequerimientoDAO;

public class JPADetRequerimientoDAO extends JPAGenericDAO<DetRequerimiento, Integer> implements DetRequerimientoDAO{

	public JPADetRequerimientoDAO() {
		super(DetRequerimiento.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DetRequerimiento> finByRequerimientoID(int idRequerimiento) {
		String queryFindDetalleRequerimiento="SELECT dr FROM DetRequerimiento dr JOIN dr.requerimientoDetReq r WHERE r.idReq=:reqID ";
		List<DetRequerimiento> detallesReque= em.createQuery(queryFindDetalleRequerimiento).setParameter("reqID", idRequerimiento).getResultList();
	
		em.close();

		return detallesReque;
	}

}
