package ec.edu.ups.proyecto.datos;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Cliente;
import ec.edu.ups.proyecto.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ClienteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}

	public Cliente read(String cedula) {
		Cliente c = em.find(Cliente.class, cedula);
		return c;
	}

	public void delete(String cedula) {
		Cliente c = em.find(Cliente.class, cedula);
		em.remove(c);
	}
	
	public List<Cliente> getAll() {
        String jpql = "SELECT c FROM Cliente c";
        TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
        return query.getResultList();
    }
	
	public Cliente getCliente(String cedula) {
		Cliente c = em.find(Cliente.class, cedula);
		return c;
	}
}
