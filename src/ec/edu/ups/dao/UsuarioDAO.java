package ec.edu.ups.dao;
import ec.edu.ups.entidades.Usuario;
public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
	public abstract Usuario findUsuarioEmailPass(String email, String password);
}
