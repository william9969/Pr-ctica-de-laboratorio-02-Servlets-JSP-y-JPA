package ec.edu.ups.dao;
import java.util.List;
import java.util.Set;

import ec.edu.ups.entidades.Requerimiento;
public interface RequerimientoDAO extends GenericDAO<Requerimiento, Integer>{
	public abstract List<Requerimiento> finbyEmpresaID(int empresaID);

	public abstract List<Requerimiento> findbyUserID(int usuarioID);
}
