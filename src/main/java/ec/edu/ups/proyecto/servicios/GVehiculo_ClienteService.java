package ec.edu.ups.proyecto.servicios;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Cliente;
import ec.edu.ups.proyecto.modelo.Vehiculo;
import ec.edu.ups.proyecto.negocio.GestionClientes;
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

@Path("Vehiculo-Cliente")

public class GVehiculo_ClienteService {
	
	String cedula="";
	
	static Cliente c;
	
	
	@Inject GestionVehiculos gestionVehiculo;
	
	@Inject GestionClientes gestionCliente;
	
	
	/////////////////////////////////////////////////////// Cliente //////////////////////////////////////////////////////////
	
	//agregar a clientes a la base de datos
		@POST
		@Produces("application/json")
		@Consumes("application/json")
		@Path("AgregarCliente")
		public Response saveCliente(Cliente cliente) {
			try {
				GVehiculo_ClienteService.c=cliente;
				cedula=cliente.getCedula();
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
		@Path("deleteCliente/{cedula}")
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

	
	
	////////////////////////////////////////////////////////////  Vehiculos //////////////////////////////////////////////////////////////
	
	//guardar vehiculos
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("AgregarVehiculo")
	public Response saveVehiculo(Vehiculo v) {
		try {
			v.setCliente(c);
			System.out.print("----------------"+v+"=------------------------=");
			gestionVehiculo.guardarVehiculo(v);
			c=null;
			return Response.status(Response.Status.OK).entity(v).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	//listar los vehiculos
	
	@GET
	@Path("vehiculosLista")
	@Produces("application/json")
	public Response getVehiculo() {
		List<Vehiculo> lista=gestionVehiculo.getVehiculos();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	
	@DELETE
	@Path("deleteVehiculo/{placa}")
	public Response deleteVehiculo(@PathParam("placa") String placa)
	{
		try {
			gestionVehiculo.delete(placa);
			return Response.status(Response.Status.OK).build();
			
		}catch (Exception e) {
			var error = new Error();
			error.setCodigo(98);
			error.setMensaje("Error al eliminar: "+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	 
	
	////////////////////////////// Ticket ////////////////////////////////////////
}
