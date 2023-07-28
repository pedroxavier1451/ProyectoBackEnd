package ec.edu.ups.proyecto.datos;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Lugar;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class LugarDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public void insert(Lugar lugar) {
		em.persist(lugar);
	}
	
	public void update(Lugar lugar) {
		em.merge(lugar);
	}

	public Lugar read(int idLugar) {
		Lugar l = em.find(Lugar.class, idLugar);
		return l;
	}

	public void delete(int idLugar) {
		Lugar l = em.find(Lugar.class, idLugar);
		em.remove(l);
	}
	
	public List<Lugar> getAll() {
        String jpql = "SELECT l FROM Lugar l";
        TypedQuery<Lugar> query = em.createQuery(jpql, Lugar.class);
        return query.getResultList();
    }
	
	public Lugar getLugar(int id) {
		Lugar l = em.find(Lugar.class, id);
		return l;
	}
}
