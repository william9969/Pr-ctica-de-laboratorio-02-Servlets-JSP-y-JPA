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
import ec.edu.ups.entidades.DetRequerimiento;
import ec.edu.ups.entidades.Requerimiento;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class EditarRequerimientos
 */
@WebServlet("/EditarRequerimientos")
public class EditarRequerimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarRequerimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Requerimiento reqEdit = (Requerimiento)session.getAttribute("requerEmpEditar");
		Usuario usu = (Usuario)session.getAttribute("usr");
		
		if(reqEdit!=null) {
			
			int idEmpresa = usu.getEmpresaUsu().getIdEmp();
			
			String value=request.getParameter("name");
			System.out.println("Imprimit valor de selecion");

			String estado=request.getParameter("estado");
			String obsReq=request.getParameter("obsRequerimiento");
			String fecR=request.getParameter("fechaReq");
			
			Requerimiento reqnuevo = new Requerimiento(reqEdit.getIdReq(),reqEdit.getFecReq(),usu.getNombreUsu(),obsReq,estado.charAt(0));
			reqnuevo.setDetRequerimientos(reqEdit.getDetRequerimientos());
			reqnuevo.setUsuarioReq(reqEdit.getUsuarioReq());
			DAOFactory.getFactory().getRequerimientoDAO().update(reqnuevo);
			System.out.println("Requerimiento nuevo" + reqnuevo);
			
			List<Requerimiento> reqListEmpresa = DAOFactory.getFactory().getRequerimientoDAO().finbyEmpresaID(idEmpresa);
			
			if(reqListEmpresa!=null) {
			for(int i=0;i<reqListEmpresa.size();i++) {
				Set<DetRequerimiento> reqListDetReq = new HashSet<DetRequerimiento>();
				List<DetRequerimiento> lista= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(reqListEmpresa.get(i).getIdReq());
				reqListDetReq.addAll(lista);
				reqListEmpresa.get(i).setDetRequerimientos(reqListDetReq);
			}}
			
			session.setAttribute("listReqEmp", reqListEmpresa);
			Requerimiento req=null;
			session.setAttribute("requerEmpEditar", req);
			//System.out.println("RequerimientosEmpresa"+reqListEmpresa);
			request.getRequestDispatcher("/Admin/ListarRequerimientos.jsp").forward(request,response);
			
		}
		else if(reqEdit==null) {
			String idid = request.getParameter("idRequerimientoEditar");
			String idRequerimientoEdit = idid.substring(0,idid.length()-2);
			int idReq= Integer.parseInt(idRequerimientoEdit);	
			Requerimiento requerimiento= DAOFactory.getFactory().getRequerimientoDAO().read(idReq);
			System.out.println(requerimiento);
			
			
			if(requerimiento!=null) {
				Set<DetRequerimiento> detReqUsu = new HashSet<DetRequerimiento>();
				List<DetRequerimiento>lista= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(requerimiento.getIdReq());
				detReqUsu.addAll(lista);
				
				requerimiento.setDetRequerimientos(detReqUsu);
			}
			session.setAttribute("requerEmpEditar", requerimiento);
			request.getRequestDispatcher("/Admin/AdministrarRequerimientos.jsp").forward(request,response);
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
