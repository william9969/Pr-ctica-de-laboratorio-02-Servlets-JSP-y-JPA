package ec.edu.ups.jpa;

import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.dao.EmpresaDAO;

public class JPAEmpresaDAO extends JPAGenericDAO<Empresa, Integer> implements EmpresaDAO{

	public JPAEmpresaDAO() {
		super(Empresa.class);
		// TODO Auto-generated constructor stub
	}

}
