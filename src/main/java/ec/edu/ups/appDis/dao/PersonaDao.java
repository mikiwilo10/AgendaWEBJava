package ec.edu.ups.appDis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appDis.model.Persona;


@Stateless
public class PersonaDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public boolean insert(Persona p) throws Exception {
		try {
			em.persist(p);
			return true;
		} catch (Exception e) {
			throw new Exception("Error al ingresar la persona: "+e.getMessage());
		}
	}
	
//	public void update(Persona p) {
//		em.merge(p);
//	}
//	
//	public Persona read(int id) {
//		return em.find(Persona.class, id);
//	}
//	
//	public void delete(int id) {
//		Persona  p = read(id);
//		em.remove(p);
//	}
	
	public Persona buscarPersona(String cedula) {
		return em.find(Persona.class, cedula);
	}
	
	 public List<Persona> getPersonas(String cedula){
    	String jpql = "SELECT p FROM Persona p WHERE cedula LIKE :cedula";
    	//System.out.println(jpql);

    	Query q = em.createQuery(jpql, Persona.class);
    	 
    	q.setParameter("cedula", cedula +"%");
    	return q.getResultList();
    	
    	
    }
	
//	public Persona getPersona(int id){
//		String jpql = "SELECT p FROM Persona p"
//				+ "WHERE p.idPersona = :id";
//		
//		Query q = em.createQuery(jpql, Persona.class);
//		
//		q.setParameter("id", id);
//			
//			
//			
//			Persona alumno = (Persona) q.getSingleResult();
//			//alumno.getIdPersona();
//			
//			
//			return alumno;
//		
//	
//	}
	
}
