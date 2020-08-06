package ec.edu.ups.appDis.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.appDis.dao.PersonaDao;
import ec.edu.ups.appDis.dao.TelefonoDao;
import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Telefono;

@Stateless
public class ContactosON {

	@Inject
	private PersonaDao perdao;

	@Inject
	private TelefonoDao teldao;

	public void insertarPersona(Persona p) throws Exception {

		if (validarCedula(p.getCedula()) == true) {
			perdao.insert(p);
		} 
		

	}

	public Persona buscarPersona(String cedula) {
		return perdao.buscarPersona(cedula);
	}

	
//	public List<Persona> getPersonas(Telefono tel) {
//		return getPersonas(tel);
//	}
	

	public List<Persona> recuperarPersona() throws Exception{
		return perdao.getPersonas("%");
	}

	
	
//	public Telefono getTelefono() {
//		return teldao.getTelefono();
//	}

//	public Persona getPersona(int id) {
//		return perdao.getPersona(id);
//	}

	public boolean validarCedula(String cedula) throws Exception {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) {
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {

					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
						// JOptionPane.showMessageDialog(null, "Cedula Correcta");
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {

			// System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
			throw new Exception("Una excepcion ocurrio en el proceso de validadcion" + err);
		}

		if (!cedulaCorrecta) {
			throw new Exception("Cedula Ingresada es Incorrecta");
			// JOptionPane.showMessageDialog(null, "Cedula Ingresada es Incorrecta");
			// System.out.println("La Cédula ingresada es Incorrecta");
		}

		return cedulaCorrecta;
		// JOptionPane.showMessageDialog(null, "Cedula Correcta");
	}
}

