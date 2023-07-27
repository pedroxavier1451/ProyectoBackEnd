package ec.edu.ups.proyecto.datos;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Cliente;
import ec.edu.ups.proyecto.modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class FacturaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public void insert(Factura factura) {
		em.persist(factura);
	}
	
	public void update(Factura factura) {
		em.merge(factura);
	}

	public Factura read(int idFactura) {
		Factura f = em.find(Factura.class, idFactura);
		return f;
	}

	public void delete(int idFactura) {
		Factura f = em.find(Factura.class, idFactura);
		em.remove(f);
	}
	
	public List<Factura> getAll() {
        String jpql = "SELECT f FROM Factura f";
        TypedQuery<Factura> query = em.createQuery(jpql, Factura.class);
        return query.getResultList();
    }
    
}
