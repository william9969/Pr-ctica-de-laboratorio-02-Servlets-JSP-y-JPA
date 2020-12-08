package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;
public abstract class DAOFactory{
	
	protected static DAOFactory factory = new JPADAOFactory();
	
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract CatProductoDAO getCatProductoDAO();
	public abstract DetRequerimientoDAO getDetRequerimientoDAO();
	public abstract EmpresaDAO getEmpresaDAO();
	public abstract ProductosDAO getProductosDAO();
	public abstract RequerimientoDAO getRequerimientoDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	
	
	
	
	
	
}
