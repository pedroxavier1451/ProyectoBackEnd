package ec.edu.ups.proyecto.servicios;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Cliente;
import ec.edu.ups.proyecto.modelo.Lugar;
import ec.edu.ups.proyecto.modelo.Ticket;
import ec.edu.ups.proyecto.modelo.Vehiculo;
import ec.edu.ups.proyecto.negocio.GestionLugar;
import ec.edu.ups.proyecto.negocio.GestionTicket;
import ec.edu.ups.proyecto.negocio.GestionVehiculos;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("Ticket")

public class GTicket_Service {
	
	static Vehiculo v;
	static Lugar l;
	
	@Inject GestionTicket gestionTicket;
	@Inject GestionVehiculos gestionVehiculo;
	@Inject GestionLugar gestionLugar;
	
	
	//Buscar vehiculo-lugar
	
	@GET
	@Path("BuscarVehiculo-Lugar/{placa}/{id}")
	@Produces("application/json")
	public Response buscarVehiculo(@PathParam("placa") String placa, @PathParam("id") int id) {
		try {
			v= gestionVehiculo.buscarVehiculo(placa);
			l=gestionLugar.buscarLugar(id);
			return Response.status(Response.Status.OK).build();
		}catch (Exception e) {
			var error = new Error();
			error.setCodigo(98);
			error.setMensaje("Error al eliminar: "+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
		
	}

	
	////////////////////////////////////// Ticket/////////////////////////
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("AgregarTicket")
	public Response saveTicket(Ticket ticket) {
		try {
			ticket.setVehiculo(v);
			ticket.setLugar(l);
			System.out.print("----------------------"+v+"-----------"+l+"-------------------");
			gestionTicket.guardarTicket(ticket);
			v=null;
			l=null;
			return Response.status(Response.Status.OK).entity(ticket).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("ticketLista")
	@Produces("application/json")
	public Response getCliente() {
		List<Ticket> lista=gestionTicket.getTicket();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	
	@DELETE
	@Path("deleteTicket/{id}")
	public Response deleteCliente(@PathParam("id") int id) {
		try {
			gestionTicket.delete(id);
			return Response.status(Response.Status.OK).build();
		}
		catch (Exception e) {
			var error = new Error();
			error.setCodigo(98);
			error.setMensaje("Error al eliminar: "+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

}
