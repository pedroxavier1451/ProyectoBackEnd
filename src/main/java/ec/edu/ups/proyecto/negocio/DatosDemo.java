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
		/*
		Lugar l1 = new Lugar();
		Lugar l2 = new Lugar();
		Lugar l3 = new Lugar();
		Lugar l4 = new Lugar();
		Lugar l5 = new Lugar();
		Lugar l6 = new Lugar();
		Lugar l7 = new Lugar();
		Lugar l8 = new Lugar();
		Lugar l9 = new Lugar();
		Lugar l10 = new Lugar();
		Lugar l11 = new Lugar();
		Lugar l12 = new Lugar();
		Lugar l13 = new Lugar();
		Lugar l14 = new Lugar();
		Lugar l15 = new Lugar();
		Lugar l16 = new Lugar();
		Lugar l17 = new Lugar();
		Lugar l18 = new Lugar();
		Lugar l19 = new Lugar();
		Lugar l20 = new Lugar();
		Lugar l21 = new Lugar();
		Lugar l22 = new Lugar();
		Lugar l23 = new Lugar();
		Lugar l24 = new Lugar();
		Lugar l25 = new Lugar();
		
		
		l1.setNroLugar(1);
		l1.setEstado(true);
		l2.setNroLugar(2);
		l2.setEstado(true);
		l3.setNroLugar(3);
		l3.setEstado(true);
		l4.setNroLugar(4);
		l4.setEstado(true);
		l5.setNroLugar(5);
		l5.setEstado(true);
		l6.setNroLugar(6);
		l6.setEstado(true);
		l7.setNroLugar(7);
		l7.setEstado(true);
		l8.setNroLugar(8);
		l8.setEstado(true);
		l9.setNroLugar(9);
		l9.setEstado(true);
		l10.setNroLugar(10);
		l10.setEstado(true);
		l11.setNroLugar(11);
		l11.setEstado(true);
		l12.setNroLugar(12);
		l12.setEstado(true);
		l13.setNroLugar(13);
		l13.setEstado(true);
		l14.setNroLugar(14);
		l14.setEstado(true);
		l15.setNroLugar(15);
		l15.setEstado(true);
		l16.setNroLugar(16);
		l16.setEstado(true);
		l17.setNroLugar(17);
		l17.setEstado(true);
		l18.setNroLugar(18);
		l18.setEstado(true);
		l19.setNroLugar(19);
		l19.setEstado(true);
		l20.setNroLugar(20);
		l20.setEstado(true);
		l21.setNroLugar(21);
		l21.setEstado(true);
		l22.setNroLugar(22);
		l22.setEstado(true);
		l23.setNroLugar(23);
		l23.setEstado(true);
		l24.setNroLugar(24);
		l24.setEstado(true);
		l25.setNroLugar(25);
		l25.setEstado(true);
		
		daoLugar.insert(l1);
		daoLugar.insert(l2);
		daoLugar.insert(l3);
		daoLugar.insert(l4);
		daoLugar.insert(l5);
		daoLugar.insert(l6);
		daoLugar.insert(l7);
		daoLugar.insert(l8);
		daoLugar.insert(l9);
		daoLugar.insert(l10);
		daoLugar.insert(l11);
		daoLugar.insert(l12);
		daoLugar.insert(l13);
		daoLugar.insert(l14);
		daoLugar.insert(l15);
		daoLugar.insert(l16);
		daoLugar.insert(l17);
		daoLugar.insert(l18);
		daoLugar.insert(l19);
		daoLugar.insert(l20);
		daoLugar.insert(l21);
		daoLugar.insert(l22);
		daoLugar.insert(l23);
		daoLugar.insert(l24);
		daoLugar.insert(l25);
		
		*/
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
