package ec.edu.ups.proyecto.negocio;

import ec.edu.ups.proyecto.datos.VehiculoDAO;
import ec.edu.ups.proyecto.modelo.Cliente;
import ec.edu.ups.proyecto.modelo.Factura;
import ec.edu.ups.proyecto.modelo.Lugar;
import ec.edu.ups.proyecto.modelo.Ticket;
import ec.edu.ups.proyecto.modelo.Vehiculo;

import java.util.Date;

import ec.edu.ups.proyecto.datos.ClienteDAO;
import ec.edu.ups.proyecto.datos.FacturaDAO;
import ec.edu.ups.proyecto.datos.LugarDAO;
import ec.edu.ups.proyecto.datos.TicketDAO;
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
	
	@Inject
	private LugarDAO daoLugar;
	
	@Inject
	private TicketDAO daoTicket;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@PostConstruct
	public void init() {
//		Cliente c = new Cliente();
//		
//		c.setCedula("0106721962");
//		c.setNombre("Pedro");
//		c.setApellido("Orellana");
//		
//		daoCliente.insert(c);
//		
//		Vehiculo v = new Vehiculo();
//		
//		v.setPlaca("ABD-20");
//		v.setModelo("Fortuner");
//		v.setCliente(c);
//		
//		daoVehiculo.insert(v);
//		
//		Lugar l = new Lugar();
//		
//		l.setNroLugar(3);
//		l.setEstado(true);
//		
//		daoLugar.insert(l);
//		
//		Ticket t = new Ticket();
//		
//		t.setHoraIngreso(new Date());
//		t.setHoraSalida(new Date());
//		t.setPrecio(23.2);
//		t.setLugar(l);
//		t.setVehiculo(v);
//		
//		daoTicket.insert(t);
//		
//		Factura f = new Factura();
//		
//		f.setCodigo("0136gs52");
//		f.setTotal(22.1);
//		f.setFecha(new Date());
//		f.setTicket(t);
//		
//		daoFactura.insert(f);
		
	}
}
