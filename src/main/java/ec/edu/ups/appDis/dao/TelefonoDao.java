package ec.edu.ups.appDis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appDis.model.Persona;
import ec.edu.ups.appDis.model.Telefono;

@Stateless
public class TelefonoDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Telefono tel) {
		
		em.persist(tel);
	}
	
//	public void update(Telefono tel) {
//		em.merge(tel);
//	}
//	
//	public Telefono read(int id) {
//		return em.find(Telefono.class, id);
//	}
//	
//	public void delete(int id) {
//		Telefono tel = read(id);
//		em.remove(tel);
//	}
	
//	public List<Telefono> getTelefono(String filtro){
//		String jpql = "SELECT p FROM Curso p";
//		
//		Query q = em.createQuery(jpql, Telefono.class);
//		
//		return q.getResultList();
//	}
	
//	public Telefono getTelefono(){
//		
//		String jpql = "SELECT p FROM Telefono p";
//		
//		Query q = em.createQuery(jpql, Telefono.class);
//		
//		List<Telefono>tel=q.getResultList();
//		for (Telefono telefono : tel) {
//			telefono.getPersona().getIdPersona();
//		}
//		
//		return tel.get(6);
//	}
	
	
	
//	public List<Telefono> listar(String filtro) {
//
//		String jpql = "SELECT p FROM Telefono p " + " WHERE persona_cedula LIKE :filtro";
//
//		Query q = em.createQuery(jpql, Telefono.class);
//
//		q.setParameter("filtro", "%");
//		return q.getResultList();
//	}
}
