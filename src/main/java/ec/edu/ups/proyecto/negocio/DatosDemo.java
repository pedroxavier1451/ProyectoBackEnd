package ec.edu.ups.proyecto.negocio;

import ec.edu.ups.proyecto.datos.VehiculoDAO;
import ec.edu.ups.proyecto.modelo.Cliente;
import ec.edu.ups.proyecto.modelo.Vehiculo;
import ec.edu.ups.proyecto.datos.ClienteDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	@PostConstruct
	public void init() {
		Cliente c = new Cliente();
		
		c.setCedula("0106721962");
		c.setNombre("Pedro");
		c.setApellido("Orellana");
		
		daoCliente.insert(c);
		
		Vehiculo v = new Vehiculo();
		
		v.setPlaca("ABD-20");
		v.setModelo("Fortuner");
		
		daoVehiculo.insert(v);
	}
}
