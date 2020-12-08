package ec.edu.ups.jpa;
import ec.edu.ups.entidades.CatProducto;
import ec.edu.ups.entidades.Productos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductosDAO;
public class JPAProductosDAO extends JPAGenericDAO<Productos, Integer> implements ProductosDAO{

	public JPAProductosDAO() {
		super(Productos.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Productos> fyndbyIDEmpresa(int idEmpresa) {
		String queryFindPRoductos="SELECT p FROM Productos p JOIN p.empresaProd e WHERE e.idEmp=:empID";
		List<Productos> lisFindProductos= em.createQuery(queryFindPRoductos).setParameter("empID",idEmpresa ).getResultList();
		em.close();
		return lisFindProductos;
	}

	@Override
	public List<CatProducto> findCatbyEmpresaID(int empID) {
		
		String queryFindPRoductos="SELECT cp FROM Productos p JOIN p.catProd cp WHERE p.empresaProd.idEmp=:emprID  GROUP BY cp.idCatProd";
		
		List<CatProducto> categorias =  em.createQuery(queryFindPRoductos).setParameter("emprID",empID ).getResultList();;
		em.close();
		//System.out.println(categorias.get(1).getNomCatProd() + categorias.get(2).getNomCatProd() + categorias.get(3).getNomCatProd());
		return categorias;
	}

}
