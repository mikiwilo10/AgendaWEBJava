package ec.edu.ups.appDis.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.appDis.business.ContactosON;

import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Telefono;


@WebServlet("/telefono")
public class RegistroAgenda extends HttpServlet {

	@Inject
	private ContactosON gan;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<h1>Hola mundo</h1>");
		
		
		
		try {

			
			
		Persona p = new Persona();
			
			
			List<Telefono> telefonos = new ArrayList<>();
			Telefono t1 = new Telefono();
			Telefono t2 = new Telefono();
			
			t1.setNumero("0992801234");
			t1.setTipoTelefono("celular");
			t1.setPersona(p);
			telefonos.add(t1);
			
			t2.setNumero("2427235");
			t2.setTipoTelefono("convencinal");
			t2.setPersona(p);
			telefonos.add(t2);
			
			String ced="0302540174";
			
			try {
				if (gan.validarCedula(ced) == true) {
					
					p.setNombre("erika");
					p.setApellido("saltos");
					p.setCedula(ced);
					
					p.setTelefono(telefonos);
					
					
					gan.insertarPersona(p);
				} else {
					System.out.println("cedula mala");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
//			
//			
//			
//			
//			
//			
//			response.getWriter().println("<h1>Inserción exitosa</h1>");
//			response.getWriter().println(p.getNombre());

	//		List<Persona>personas=gan.getPersonas();
		//for (Persona persona : personas) {
				//List<Persona> tel=gan.getPersonas();
	        //	response.getWriter().println(persona.toString());
	        //	response.getWriter().println("");
	        	
		//}
			
			// Telefono tell = gan.getTelefono();
		        
		      //  response.getWriter().println("<br><br>Datos personales: " + tell);
		        //response.getWriter().println("<br><br>Datos domicilio: " + tell.getPersona());
		   //    Persona per=gan.getPersona(5);
		     // response.getWriter().println("<br><br>Datos personales: " + per.getNombre());
		      //response.getWriter().println("<br><br>Datos domicilio: " + per.getTelefono());
		        
		        
			
			
		} catch (Exception e) {
			response.getWriter().println("<h1>"+e.getMessage()+"</h1>");
		}
	}
}
 