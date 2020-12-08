package ec.edu.ups.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidades.DetRequerimiento;
import ec.edu.ups.entidades.Productos;
import ec.edu.ups.entidades.Requerimiento;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class RequerimientoC
 */
@WebServlet("/RequerimientoC")
public class RequerimientoC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequerimientoC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Entro");
		Usuario usr = new Usuario();
		usr = (Usuario)session.getAttribute("usr");
		
    	System.out.println("Crear objeto");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	Productos producto;
    	DetRequerimiento detRequerimiento;
    	Requerimiento requerimiento;

    	
    	int cantidadFactura = Integer.parseInt(request.getParameter("cantidadFactura"));
    	
    	Double total =0.0;
    	
    	
		
		Usuario usuReq = DAOFactory.getFactory().getUsuarioDAO().read(usr.getIdUsu());
		
		GregorianCalendar gcalendario = new GregorianCalendar();
		requerimiento = new Requerimiento(gcalendario.getInstance(), "", "",'P');
		System.out.println(requerimiento);
		requerimiento.setUsuarioReq(usuReq);
	
		DAOFactory.getFactory().getRequerimientoDAO().create(requerimiento);

		
    	for (int i = 1; i <= cantidadFactura; i++) {
    		String nombre = request.getParameter("prod"+i);
    		
    		Double precio = Double.parseDouble(request.getParameter("precio"+i));
    		System.out.println(nombre);
    		int cantidad = Integer.parseInt(request.getParameter("cantidad"+i));
    		//Productos cantidad = DAOFactory.getFactory().getProductosDAO().read());
    		int idproducto = Integer.parseInt(request.getParameter("id"+i));
    		//Productos idproducto = DAOFactory.getFactory().getProductosDAO().read(Integer.parseInt(request.getParameter("id"+i)));
    		int descuento = Integer.parseInt(request.getParameter("descuento"+i));
    		
    		//producto = new Productos(idproducto, nombre, precio, cantidad);
    		producto = DAOFactory.getFactory().getProductosDAO().read(idproducto);
    		System.out.println(producto);
    		//Productos productoId = DAOFactory.getFactory().getProductosDAO().read(id)
    	
    		detRequerimiento= new DetRequerimiento(cantidad, idproducto, producto.getCantProd(), producto.getPrecProd(), descuento);
    		
    		
    		//total += cantidad * precio;
    		detRequerimiento.setRequerimientoDetReq(requerimiento);
    		
    		DAOFactory.getFactory().getDetRequerimientoDAO().create(detRequerimiento);
    		
    	}
    	response.getWriter().print("La compra ha sida registrado correctamente");
    	request.getRequestDispatcher("/User/Requerimiento.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
