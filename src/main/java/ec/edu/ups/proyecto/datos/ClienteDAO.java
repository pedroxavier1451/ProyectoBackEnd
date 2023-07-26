package ec.edu.ups.proyecto.datos;

<<<<<<< Updated upstream
import java.util.List;
=======
public class ClienteDAO {
	
	
>>>>>>> Stashed changes

import ec.edu.ups.proyecto.modelo.Cliente;
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

	public Cliente read(int idCliente) {
		Cliente c = em.find(Cliente.class, idCliente);
		return c;
	}

	public void delete(int idCliente) {
		Cliente c = em.find(Cliente.class, idCliente);
		em.remove(c);
	}
	
	public List<Cliente> getAll() {
        String jpql = "SELECT c FROM Cliente c";
        TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
        return query.getResultList();
    }
}
