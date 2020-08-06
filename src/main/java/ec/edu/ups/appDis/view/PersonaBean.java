package ec.edu.ups.appDis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.hibernate.validator.constraints.ScriptAssert;

import ec.edu.ups.appDis.business.ContactosON;
import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Telefono;

@ManagedBean
@ViewScoped
public class PersonaBean {
	
	@Inject
	private ContactosON on;
	
	private Persona p;
	
	//private Telefono t;
	
	private List<Persona> listaper;
	
	
	public Persona getP() {
		return p;
	}
	public void setP(Persona p) {
		this.p = p;
	}
	
	public List<Persona> getListaper() {
		return listaper;
	}
	public void setListaper(List<Persona> listaper) {
		this.listaper = listaper;
	}
	
	
	@Override
	public String toString() {
		return "PersonaBean [p=" + p + ", listaper=" + listaper + "]";
	}
	
	@PostConstruct
	public void init() {
		p =new Persona();
		p.addTelefonos(new Telefono());
		cargarPersona();
	}
	
	
	public String guardarDatos() {
		try {
			on.insertarPersona(p);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "listar";
	}
	
	
	public String agregarTelefono() {
		p.addTelefonos(new Telefono());
		return null;
	}
	
	public void loadDatosPersona() {
		try {
			p=on.buscarPersona(p.getCedula());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void cargarPersona() {
		try {
			listaper= on.recuperarPersona();
			
			List<Persona> listaper2=on.recuperarPersona();
			
			for (Persona persona : listaper2) {
				System.out.println("Cedula"+ persona.getCedula());
				System.out.println("Nombre"+ persona.getNombre());
				System.out.println("Apellido"+ persona.getApellido());
				System.out.println("-----"+ persona.getTelefono());	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al Listar" +e.getMessage());
		}
		
	}

}
