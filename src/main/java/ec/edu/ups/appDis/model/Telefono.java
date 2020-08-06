package ec.edu.ups.appDis.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Telefono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6990652300584859995L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefono")
	private int idTelefono;
	
	private String numero;
	
	private String tipoTelefono;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_persona")
	private Persona persona;
	 
	 
	public int getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona p) {
		this.persona = p;
	}
//	@Override
//	public String toString() {
//		return "Telefono [idTelefono=" + idTelefono + ", numero=" + numero + ", tipoTelefono=" + tipoTelefono + ", p="
//				+ persona + "]";
//	}
//	
	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", numero=" + numero + ", tipoTelefono=" + tipoTelefono + "]";
	}
	  
	  
}
