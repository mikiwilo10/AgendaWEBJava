package ec.edu.ups.appDis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9051315575261221633L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int idPersona;
	   
	private String nombre;
	   
	private String apellido;
	    
	private String cedula;
	
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Telefono>telefono; 
	    
		public int getIdPersona() {
			return idPersona;
		}
		public void setIdPersona(int idPersona) {
			this.idPersona = idPersona;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public List<Telefono> getTelefono() {
			return telefono;
		}
		public void setTelefono(List<Telefono> telefono) {
			this.telefono = telefono;
		}
		@Override
		public String toString() {
			return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula="
					+ cedula + ", telefono=" + telefono + "]";
		}
		/*
		 @Override
		public String toString() {
			return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula="
					+ cedula + "]";
		}
		 */
		   
		public void addTelefonos(Telefono t) {
	    	if(telefono == null) 
	    		telefono = new ArrayList<Telefono>();    	    		
	    	
	    	telefono.add(t);
	    	
		}
	    
}
