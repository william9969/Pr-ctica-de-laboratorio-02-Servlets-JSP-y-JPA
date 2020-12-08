package ec.edu.ups.test;

import ec.edu.ups.dao.*;
import ec.edu.ups.entidades.*;
public class test {

	public static void main(String[] args) {
		EmpresaDAO empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		ProductosDAO productosDAO = DAOFactory.getFactory().getProductosDAO();
		CatProductoDAO catProductoDAO = DAOFactory.getFactory().getCatProductoDAO();
		RequerimientoDAO requerimientosDAO = DAOFactory.getFactory().getRequerimientoDAO();
		DetRequerimientoDAO detRequerimientoDAO = DAOFactory.getFactory().getDetRequerimientoDAO();
		
		Empresa megaPlazaDelSur = new Empresa ("Plaza Del Sur","Ucubamba");
		Empresa megaTiendaDelSur = new Empresa ("Mega Tienda Del Sur","Indurama");
		Empresa megaTiendaSantaCecilia = new Empresa ("Mega Santa Cecilia","9DeOctubre");
		
		empresaDAO.create(megaTiendaSantaCecilia);
		empresaDAO.create(megaTiendaDelSur);
		empresaDAO.create(megaPlazaDelSur);
		
		
		
		//////////////////////CREANDO USUARIOS ADMINISTRADORES///////////// 

		
		Usuario usuarioAdm = new Usuario("Jessica Guncay","gjessica@est.ups.edu.ec","Jessica123",'A');
		usuarioAdm.setEmpresaUsu(megaTiendaDelSur);
		//System.out.println(usuarioAdm.getTipoUsu());
		usuarioDAO.create(usuarioAdm);
		 

	
		Usuario usuarioAmdPDS = new Usuario("William Sinchi", "wsinchi@est.ups.edu.ec", "William123",'A');
		usuarioAmdPDS.setEmpresaUsu(megaPlazaDelSur);
		usuarioDAO.create(usuarioAmdPDS);
	
	
		Usuario usuarioAmdMSC = new Usuario("Karla Agudo", "kagudo@est.ups.edu.ec", "Karla123",'A');
		//empresaDAO.create(megaTiendaSantaCecilia);
		usuarioAmdMSC.setEmpresaUsu(megaTiendaSantaCecilia);
		usuarioDAO.create(usuarioAmdMSC); 
		
		///////////////////CREANDO USUARIOS NORMALES/////////////
		
		Usuario usuarioMSC = new Usuario("Valeria Guncay", "gvaleria@est.ups.edu.ec", "Valeria123",'N');
		//empresaDAO.create(megaTiendaSantaCecilia);
		usuarioMSC.setEmpresaUsu(megaTiendaSantaCecilia);
		usuarioDAO.create(usuarioMSC); 
		
		Usuario usuarioPDS = new Usuario("Jessica Sinchi", "jsinchi@est.ups.edu.ec", "JessicaP123",'N');
		usuarioPDS.setEmpresaUsu(megaPlazaDelSur);
		usuarioDAO.create(usuarioPDS);
		
		Usuario usuarioMTS = new Usuario("Carmen Calderon","ccarmen@est.ups.edu.ec","Carmen123",'N');
		usuarioMTS.setEmpresaUsu(megaTiendaDelSur);
		usuarioDAO.create(usuarioMTS);
		
		
		//////////////////CREAR CATEGORIAS/////////////////
		CatProducto carnesMTS = new CatProducto("Carnes");
		CatProducto lacteosMTS = new CatProducto("Lacteos");
		CatProducto bebidasMTS = new CatProducto("Bebidas");
		CatProducto fiestaMTS = new CatProducto("Fiesta");
		catProductoDAO.create(bebidasMTS);
		catProductoDAO.create(carnesMTS);
		catProductoDAO.create(lacteosMTS);
		catProductoDAO.create(fiestaMTS);
		
		
		CatProducto frutasMPS = new CatProducto("Frutas");
		CatProducto jugueMPS = new CatProducto("Jugueteria");
		CatProducto panaMPS = new CatProducto("Panaderia");
		CatProducto vestiMPS= new CatProducto("Vestimenta");	
		catProductoDAO.create(frutasMPS);
		catProductoDAO.create(jugueMPS);
		catProductoDAO.create(panaMPS);
		catProductoDAO.create(vestiMPS);
		
		
		
		
		CatProducto licoMTSC = new CatProducto("Licores");
		CatProducto papeMTSC = new CatProducto("Papeleria");
		CatProducto limpiezaMTSC = new CatProducto("Limpieza");
		CatProducto calzadoMTSC = new CatProducto("Calzado");
		catProductoDAO.create(licoMTSC);
		catProductoDAO.create(papeMTSC);
		catProductoDAO.create(limpiezaMTSC);
		catProductoDAO.create(calzadoMTSC);

		//////////////////CREA PRODUCTOS EN MEGA TIENDA DEL SUR/////////////////
		
		/////CATEGORIA CARNES
		Productos proCarRes = new Productos ("Carne Res",3.25, 10);
		proCarRes.setCatProd(carnesMTS);
		proCarRes.setEmpresaProd(megaTiendaDelSur);	
		productosDAO.create(proCarRes);
		
		Productos proPollo = new Productos ("Pollo",3.10, 10);
		proPollo.setCatProd(carnesMTS);
		proPollo.setEmpresaProd(megaTiendaDelSur);		
		productosDAO.create(proPollo);
		
		Productos proCarChan= new Productos ("Carne Chancho",3.50, 12);
		proCarChan.setCatProd(carnesMTS);
		proCarChan.setEmpresaProd(megaTiendaDelSur);		
		productosDAO.create(proCarChan);
		
		
		//////CATEGORIA LACTEOS
		Productos proYogurt= new Productos ("Yogurt",0.85, 10);
		proYogurt.setCatProd(lacteosMTS);
		proYogurt.setEmpresaProd(megaTiendaDelSur);		
		productosDAO.create(proYogurt);
		
		Productos proLeche= new Productos ("Leche",0.85, 10);
		proLeche.setCatProd(lacteosMTS);
		proLeche.setEmpresaProd(megaTiendaDelSur);	
		productosDAO.create(proLeche);
		
		Productos proQueso= new Productos ("Queso",0.85, 10);
		proQueso.setCatProd(lacteosMTS);
		proQueso.setEmpresaProd(megaTiendaDelSur);		
		productosDAO.create(proQueso);
		
		///// CATEGORIA BEBIDAS
		Productos proBeCo = new Productos ("Coca-Cola",2.85, 12);
		proBeCo.setCatProd(bebidasMTS);
		proBeCo.setEmpresaProd(megaTiendaDelSur);
		productosDAO.create(proBeCo);
		
		Productos proBeVi = new Productos ("Vivant",0.45, 15);
		proBeVi.setCatProd(bebidasMTS);
		proBeVi.setEmpresaProd(megaTiendaDelSur);
		productosDAO.create(proBeVi);
		
		Productos proBeGui = new Productos ("Guitic",0.75, 10);
		proBeGui.setCatProd(bebidasMTS);
		proBeGui.setEmpresaProd(megaTiendaDelSur);
		productosDAO.create(proBeGui);
		
		///// CATEGORIA FIESTA
		
		Productos proGlo = new Productos ("Globos",1.5, 14);
		proGlo.setCatProd(fiestaMTS);
		proGlo.setEmpresaProd(megaTiendaDelSur);
		productosDAO.create(proGlo);
		
		Productos proSer = new Productos ("Serpentinas",1.5, 11);
		proSer.setCatProd(fiestaMTS);
		proSer.setEmpresaProd(megaTiendaDelSur);
		productosDAO.create(proSer);
		
		Productos proPin = new Productos ("Piñata",8.5, 11);
		proPin.setCatProd(fiestaMTS);
		proPin.setEmpresaProd(megaTiendaDelSur);
		productosDAO.create(proPin);

		
		//////////////////CREA PRODUCTOS EN MEGA PLAZA SUR/////////////////	
				
		///////CATEGORIA FRUTAS
		Productos proMPSManzana = new Productos ("Manzana",0.55, 10);
		proMPSManzana.setCatProd(frutasMPS);
		proMPSManzana.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSManzana);
		
		Productos proMPSSandias = new Productos ("Sandias",1.55, 12);
		proMPSSandias.setCatProd(frutasMPS);
		proMPSSandias.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSSandias);
		
		Productos proMPSPeras = new Productos ("Peras",0.60, 10);
		proMPSPeras.setCatProd(frutasMPS);
		proMPSPeras.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSPeras);
		
		///////CATEGORIA JUGUETERIA
		Productos proMPSBar = new Productos ("Barbie",10.55, 12);
		proMPSBar.setCatProd(jugueMPS);
		proMPSBar.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSBar);
		
		Productos proMPSPeBa = new Productos ("Pelota de Basquet",19.75, 11);
		proMPSPeBa.setCatProd(jugueMPS);
		proMPSPeBa.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSPeBa);
		
		Productos proMPSPeFu = new Productos ("Pelota de Futol",18.65, 15);
		proMPSPeFu.setCatProd(jugueMPS);
		proMPSPeFu.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSPeFu);
		
		///////CATEGORIA PANADERIA
		Productos proMPSPanEn = new Productos ("Pan enrollado",0.25, 10);
		proMPSPanEn.setCatProd(panaMPS);
		proMPSPanEn.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSPanEn);
		
		Productos proMPSPanEnq = new Productos ("Pan enquesillado",0.25, 13);
		proMPSPanEnq.setCatProd(panaMPS);
		proMPSPanEnq.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSPanEnq);
		
		Productos proMPSTorGran = new Productos ("Torta Grande", 12.50, 10);
		proMPSTorGran.setCatProd(panaMPS);
		proMPSTorGran.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSTorGran);
		
		Productos proMPSTorMEd = new Productos ("Torta Mediana",6.25, 15);
		proMPSTorMEd.setCatProd(panaMPS);
		proMPSTorMEd.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSTorMEd);
		
		///////CATEGORIA VESTIMENTA  
		Productos proMPSCamisa= new Productos ("Camisa",8.25, 10);
		proMPSCamisa.setCatProd(vestiMPS);
		proMPSCamisa.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSCamisa);
		
		Productos proMPSPantalon= new Productos ("Pantalon",15.75, 15);
		proMPSPantalon.setCatProd(vestiMPS);
		proMPSPantalon.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSPantalon);
		
		Productos proMPSCamiseta= new Productos ("Camiseta",10.75, 12);
		proMPSCamiseta.setCatProd(vestiMPS);
		proMPSCamiseta.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSCamiseta);
		
		Productos proMPSVestido= new Productos ("Vestido",18.50, 15);
		proMPSVestido.setCatProd(vestiMPS);
		proMPSVestido.setEmpresaProd(megaPlazaDelSur);
		productosDAO.create(proMPSVestido);
		
		//////////////////CREA PRODUCTOS EN MEGA SANTA CECILIA/////////////////			
				
		/////CATEGORIA LICORES
		Productos proMCSCerveza= new Productos ("Cerveza",2.25, 15);
		proMCSCerveza.setCatProd(licoMTSC);
		proMCSCerveza.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMCSCerveza);
		
		Productos proMSCWis= new Productos ("Whisky",12.25, 10);
		proMSCWis.setCatProd(licoMTSC);
		proMSCWis.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCWis);
		
		Productos proMPSZhu= new Productos ("Zhumir",5.25, 15);
		proMPSZhu.setCatProd(licoMTSC);
		proMPSZhu.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMPSZhu);
		
		/////CATEGORIA PAPELERIA
		Productos proMSCCuadernos= new Productos ("Cuadernos",2.25, 15);
		proMSCCuadernos.setCatProd(papeMTSC);
		proMSCCuadernos.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCCuadernos);
		
		Productos proMSCEsferos= new Productos ("Esferos", 0.25, 20);
		proMSCEsferos.setCatProd(papeMTSC);
		proMSCEsferos.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCEsferos);
		
		Productos proMSCCarpetas= new Productos ("Carpetas",5.25, 15);
		proMSCCarpetas.setCatProd(papeMTSC);
		proMSCCarpetas.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCCarpetas);
		
		/////CATEGORIA LIMPIEZA
		Productos proMSCDetergente= new Productos ("Detergente",4.25, 15);
		proMSCDetergente.setCatProd(limpiezaMTSC);
		proMSCDetergente.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCDetergente);
		
		Productos proMSCCloro= new Productos ("Cloro", 0.25, 30);
		proMSCCloro.setCatProd(limpiezaMTSC);
		proMSCCloro.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCCloro);
		
		Productos proMSCVanish= new Productos ("Vanish",1.25, 20);
		proMSCVanish.setCatProd(limpiezaMTSC);
		proMSCVanish.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCVanish);
		
		
		/////CATEGORIA CALZADO
		Productos proMSCTacones= new Productos ("Tacones",15.75, 25);
		proMSCTacones.setCatProd(calzadoMTSC);
		proMSCTacones.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCTacones);
		
		Productos proMSCDepHom= new Productos ("Deportivos Hombre", 10.5, 30);
		proMSCDepHom.setCatProd(calzadoMTSC);
		proMSCDepHom.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCDepHom);
		
		Productos proMSCAdidas= new Productos ("Adidas",71.25, 20);
		proMSCAdidas.setCatProd(calzadoMTSC);
		proMSCAdidas.setEmpresaProd(megaTiendaSantaCecilia);
		productosDAO.create(proMSCAdidas);
	}
}