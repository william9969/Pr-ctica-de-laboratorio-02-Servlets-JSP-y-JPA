package ec.edu.ups.vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.entidades.CatProducto;
import ec.edu.ups.entidades.DetRequerimiento;
import ec.edu.ups.entidades.Empresa;
import ec.edu.ups.entidades.Productos;
import ec.edu.ups.entidades.Requerimiento;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String contrasenia = request.getParameter("contrasena");
		//ArrayList<CatProductos> list = 
		
		Usuario usuarioObj = DAOFactory.getFactory().getUsuarioDAO().findUsuarioEmailPass(usuario, contrasenia);
		//System.out.println(usuarioObj.getNombreUsu());
		if (usuarioObj != null) {			
			Empresa empresaObj = usuarioObj.getEmpresaUsu();
			//System.out.println("Estas la empresa "+empresaObj.getIdEmp());
			List<Productos> listPro = DAOFactory.getFactory().getProductosDAO().fyndbyIDEmpresa(empresaObj.getIdEmp());
			//System.out.println("Estas loggeado");
			//<Requerimiento> lisRequerimientos = DAOFactory.getFactory().getRequerimientosDAO().findbyUserID(usuarioObj.getIdUsu());
			//usuarioObj.setRequerimientos(DAOFactory.getFactory().getRequerimientosDAO().findbyUserID(usuarioObj.getIdUsu()));
			List<CatProducto> categorias = DAOFactory.getFactory().getProductosDAO().findCatbyEmpresaID(empresaObj.getIdEmp());
			try {
				int idEmpresa = empresaObj.getIdEmp();
				//RequestDispatcher rd = null;
				//Establecer el inicio de sesion.
				HttpSession session = request.getSession(true);
				//Obtener datos del 
				String tipoUSU = String.valueOf(usuarioObj.getTipoUsu());	
				//System.out.println("El tipo de usuario es"+ tipoUSU);
				session.setAttribute("usr", usuarioObj);
				session.setAttribute("cat", categorias);
				session.setAttribute("listProS", listPro);
				//System.out.println("A verr");
				
				//ArrayList<Requerimiento> reque= (ArrayList<Requerimiento>) usuarioObj.getRequerimientos();
				if (tipoUSU.equals("A")) {
					//System.out.println("Has entrado como Admin");
					List<Requerimiento> reqListEmpresa = DAOFactory.getFactory().getRequerimientoDAO().finbyEmpresaID(idEmpresa);
					//System.out.println("Total de Requerimientos " + reqListEmpresa.size());
					
					if(reqListEmpresa!=null) {
					for(int i=0;i<reqListEmpresa.size();i++) {
						Set<DetRequerimiento> reqListDetReq = new HashSet<DetRequerimiento>() ;
						List<DetRequerimiento> lista=DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(reqListEmpresa.get(i).getIdReq());
						reqListDetReq.addAll(lista);
						reqListEmpresa.get(i).setDetRequerimientos(reqListDetReq);
					}}
						
					session.setAttribute("listReqEmp", reqListEmpresa);
					//System.out.println("RequerimientosEmpresa"+reqListEmpresa);
					request.getRequestDispatcher("/Admin/Administrador.jsp").forward(request,response);
						
					
				}else if(tipoUSU.equals("N")) {
					
					List<Requerimiento> requerimientoUsuario=DAOFactory.getFactory().getRequerimientoDAO().findbyUserID(usuarioObj.getIdUsu());
					try{
						if(requerimientoUsuario!=null) {
							for(int i=0;i<requerimientoUsuario.size();i++) {
								Set<DetRequerimiento> detReqUsu = new HashSet<DetRequerimiento>() ;
								List<DetRequerimiento> detReqUsuLS= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(requerimientoUsuario.get(i).getIdReq());
								detReqUsu.addAll(detReqUsuLS);
								requerimientoUsuario.get(i).setDetRequerimientos(detReqUsu);

							}
						}
						
					}catch(Exception e) {
						System.out.println("Lista Nula");
					}
					session.setAttribute("listReqUsuario", requerimientoUsuario);
					request.getRequestDispatcher("/User/Usuario.jsp").forward(request,response);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error: "+e);
			}
			
			/////////////////////////////////
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
