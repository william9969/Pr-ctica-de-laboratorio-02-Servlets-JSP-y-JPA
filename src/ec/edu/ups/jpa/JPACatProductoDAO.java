package ec.edu.ups.jpa;

import ec.edu.ups.entidades.CatProducto;

import java.util.List;

import ec.edu.ups.dao.CatProductoDAO;

public class JPACatProductoDAO extends JPAGenericDAO<CatProducto, Integer> implements CatProductoDAO{

	public JPACatProductoDAO() {
		super(CatProducto.class);
		// TODO Auto-generated constructor stub
	}


}
