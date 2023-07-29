package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.TicketDAO;
import ec.edu.ups.proyecto.modelo.Ticket;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionTicket {
	
	@Inject 
	private TicketDAO daoTicket;

	public void guardarTicket(Ticket ticket) throws Exception {
		if(daoTicket .read(ticket.getIdTicket())==null) {
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
	
	public List<Ticket> getTicket(){
		return daoTicket.getAll();
	}
	
	public void delete(int idTicket) {
		daoTicket.delete(idTicket);
	}
	
	public Ticket buscarTicket(int id) {
		return daoTicket.getTicket(id);
	}
	
	//calcular Precio
	
	public void calcularTotal(Ticket ticket) {
		int hora1=ticket.getHoraIngreso().getHours();
		int min1=ticket.getHoraIngreso().getMinutes();
		
		int hora2=ticket.getHoraSalida().getHours();
		int min2=ticket.getHoraSalida().getMinutes();
		
		
		ticket.getHoraSalida();
		ticket.getPrecio();
	}
}
