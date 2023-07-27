package ec.edu.ups.proyecto.servicios;
import ec.edu.ups.proyecto.negocio.GestionClientes;
import ec.edu.ups.proyecto.modelo.Cliente;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("Cliente")

public class GClientesService {
	
	@Inject GestionClientes gestionCliente;
	
	
	//agregar a clientes a la base de datos
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveCliente(Cliente cliente) {
		try {
			gestionCliente.guardarClientes(cliente);
			return Response.status(Response.Status.OK).entity(cliente).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	

	//listar a los clientes existentes
	
	@GET
	@Path("clienteLista")
	@Produces("application/json")
	public Response getCliente() {
		List<Cliente> lista=gestionCliente.getCliente();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	
	//eliminar datos existentes de la base de datos 
	
	@DELETE
	@Path("delete/{cedula}")
	public Response deleteCliente(@PathParam("cedula") String cedula) {
		try {
			gestionCliente.delete(cedula);
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
