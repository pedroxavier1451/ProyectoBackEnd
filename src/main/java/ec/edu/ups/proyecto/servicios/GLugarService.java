package ec.edu.ups.proyecto.servicios;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Lugar;
import ec.edu.ups.proyecto.negocio.GestionLugar;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("Lugar")

public class GLugarService {

	@Inject GestionLugar gestionLugar;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response saveLugar(Lugar lugar) {
		try {
			
		gestionLugar.guardarLugar(lugar);
		return Response.status(Response.Status.OK).entity(lugar).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("lugarLista")
	@Produces("application/json")
	public Response getLugar() {
		List<Lugar> lista=gestionLugar.getLugar();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	
	@DELETE
	@Path("delete/{id}")
	public Response deleteLugar(@PathParam("id") int id) {
		try {
			gestionLugar.delete(id);
			return Response.status(Response.Status.OK).build();
		}catch (Exception e) {
			var error = new Error();
			error.setCodigo(98);
			error.setMensaje("Error al eliminar: "+e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	
	@GET
	@Path("verificar")
	@Produces("application/json")
	public List<Integer> contar() {
		return gestionLugar.verificar();
	}
	
	
	
	
	
}
