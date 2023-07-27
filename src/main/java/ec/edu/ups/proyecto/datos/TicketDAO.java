package ec.edu.ups.proyecto.datos;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Ticket;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class TicketDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public void insert(Ticket ticket) {
		em.persist(ticket);
	}
	
	public void update(Ticket ticket) {
		em.merge(ticket);
	}

	public Ticket read(int idTicket) {
		Ticket t = em.find(Ticket.class, idTicket);
		return t;
	}

	public void delete(int idTicket) {
		Ticket t = em.find(Ticket.class, idTicket);
		em.remove(t);
	}
	
	public List<Ticket> getAll() {
        String jpql = "SELECT t FROM Ticket t";
        TypedQuery<Ticket> query = em.createQuery(jpql, Ticket.class);
        return query.getResultList();
    }
    
}
