package ec.edu.ups.jpa;

import ec.edu.ups.entidades.Productos;
import ec.edu.ups.entidades.Usuario;

import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{

	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario findUsuarioEmailPass(String email, String password) {
		Usuario usuario=null;
		String queryFindPRoductos="SELECT u FROM Usuario u WHERE u.emailUsu=:emaUsu AND u.passUsu=:passUsu";
		try {
			usuario = (Usuario) em.createQuery(queryFindPRoductos).setParameter("emaUsu",email ).setParameter("passUsu", password).getSingleResult();
			em.close();
		}catch(Exception e) {
			System.out.println("Error al buscar El usuario");
		}
		
		return usuario;
	}

}
