package ec.edu.ups.proyecto.datos;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Ticket;
import ec.edu.ups.proyecto.modelo.Vehiculo;
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
	
	public Ticket getTicket(int id) {
		Ticket t = em.find(Ticket.class, id);
		return t;
	}
	
//	public Vehiculo getVehiculoCedula(String c) {
//		 String jpql = "SELECT vehiculo.placa, vehiculo.modelo, vehiculo.cedula FROM cliente INNER JOIN vehiculo ON cliente.cedula = vehiculo.cedula WHERE cliente.cedula = c";
//	        TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
//	        System.out.print("-------- valores de dao -----------"+query.getSingleResult());
//	        return query.getSingleResult();
//		
//	}
	



    
}
