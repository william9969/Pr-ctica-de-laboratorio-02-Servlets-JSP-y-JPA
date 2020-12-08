package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.CatProducto;
import ec.edu.ups.entidades.Productos;

public interface ProductosDAO extends GenericDAO <Productos, Integer>{
	public abstract List<Productos> fyndbyIDEmpresa(int idEmpresa);
	public abstract List<CatProducto> findCatbyEmpresaID(int empID);
}
