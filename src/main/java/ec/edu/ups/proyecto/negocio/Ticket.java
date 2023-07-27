package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.TicketDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class Ticket {
	
	@Inject
	private TicketDAO daoTicket;
	
	private boolean isCodigoValido(int idTicket) {
		return idTicket != 0;
	}
	
	public void guardarTicket(Ticket ticket) {
		if(!this.isCodigoValido(ticket.getIdCliente()))
			throw new Exception("Codigo Incorrecto");
		
		if(daoTicket.read(ticket.getIdTicket())==null) {
			try {
				daoTicket.insert(ticket);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
		else {
			try {
				daoTicket.update(ticket);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
	}
	
	public List<Ticket> getTickets(){
		return daoTicket.getAll();
	}
	
	public void delete(int id) {
		daoTicket.delete(id);
	}

}
