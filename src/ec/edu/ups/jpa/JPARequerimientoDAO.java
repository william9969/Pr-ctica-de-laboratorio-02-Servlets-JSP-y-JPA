package ec.edu.ups.jpa;

import ec.edu.ups.entidades.CatProducto;
import ec.edu.ups.entidades.DetRequerimiento;
import ec.edu.ups.entidades.Requerimiento;

import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.RequerimientoDAO;

public class JPARequerimientoDAO extends JPAGenericDAO<Requerimiento, Integer> implements RequerimientoDAO{

	public JPARequerimientoDAO() {
		super(Requerimiento.class);
	}

	@Override
	public List<Requerimiento> finbyEmpresaID(int empresaID) {
		String queryFindPRequerimientos="SELECT r FROM Requerimiento r JOIN r.usuarioReq u WHERE u.empresaUsu.idEmp=:emprID  ";
		
		List<Requerimiento> requerimientos =  em.createQuery(queryFindPRequerimientos).setParameter("emprID",empresaID ).getResultList();;
		em.close();
		//System.out.println(categorias.get(1).getNomCatProd() + categorias.get(2).getNomCatProd() + categorias.get(3).getNomCatProd());
		return requerimientos;
	}



	@Override
	public List<Requerimiento> findbyUserID(int usuarioID) {
		
		String queryFindRequerimiento="SELECT r FROM Requerimiento r JOIN r.usuarioReq u WHERE u.idUsu=:usuID ";
		List<Requerimiento> detallesReque= em.createQuery(queryFindRequerimiento).setParameter("usuID", usuarioID).getResultList();
	
		em.close();

		return detallesReque;
	}

}
