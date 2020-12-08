package ec.edu.ups.dao;
import java.util.List;

import ec.edu.ups.entidades.DetRequerimiento;
public interface DetRequerimientoDAO extends GenericDAO<DetRequerimiento, Integer>{
	public abstract List<DetRequerimiento> finByRequerimientoID(int idRequerimiento);
}
