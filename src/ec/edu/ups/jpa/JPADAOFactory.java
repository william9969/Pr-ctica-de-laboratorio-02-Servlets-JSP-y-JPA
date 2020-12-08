package ec.edu.ups.jpa;

import ec.edu.ups.dao.*;

public class JPADAOFactory extends DAOFactory{

	@Override
	public CatProductoDAO getCatProductoDAO() {
		// TODO Auto-generated method stub
		return new JPACatProductoDAO();
	}

	@Override
	public DetRequerimientoDAO getDetRequerimientoDAO() {
		// TODO Auto-generated method stub
		return new JPADetRequerimientoDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		// TODO Auto-generated method stub
		return new JPAEmpresaDAO();
	}

	@Override
	public ProductosDAO getProductosDAO() {
		// TODO Auto-generated method stub
		return new JPAProductosDAO();
	}

	@Override
	public JPARequerimientoDAO getRequerimientoDAO() {
		// TODO Auto-generated method stub
		return new JPARequerimientoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}

}
