package ec.edu.ups.proyecto.servicios;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Factura;
import ec.edu.ups.proyecto.modelo.Ticket;
import ec.edu.ups.proyecto.negocio.GestionFactura;
import ec.edu.ups.proyecto.negocio.GestionTicket;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("Factura")

public class GFactura_Service {
	
	@Inject GestionFactura gestionFactura;
	@Inject GestionTicket gestionTicket;
	
	static Ticket t;
	
	
	//Buscar Ticket
	
	@GET
	@Path("buscarTicket/{id}")
	@Produces("application/json")
	public Response buscarVehiculo(@PathParam("id") int id) {
		try {
			t= gestionTicket.buscarTicket(id);
			return Response.status(Response.Status.OK).build();
		}catch (Exception e) {
			var error = new Error();
			error.setCodigo(98);
			error.setMensaje("Error al eliminar: "+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
		
	}
	
	
	//////////////////////////// Factura ./////////////////////////////
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("AgregarFactura")
	public Response saveFactura(Factura factura) {
		try {
			factura.setTicket(t);
			factura.setCodigo(gestionFactura.generarCodigoFactura());
			System.out.print("--------------"+t+"-------------");
			gestionFactura.guardarFactura(factura);
			t=null;
			return Response.status(Response.Status.OK).entity(factura).build();
		}catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@GET
	@Path("facturaLista")
	@Produces("application/json")
	public Response getFactura() {
		List<Factura> lista=gestionFactura.getFactura();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	
	@DELETE
	@Path("deleteFactura/{id}")
	public Response deleteFactura(@PathParam("id") int id) {	
		try {
			gestionFactura.delete(id);
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
