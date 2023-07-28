package ec.edu.ups.proyecto.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ec.edu.ups.proyecto.datos.FacturaDAO;
import ec.edu.ups.proyecto.datos.TicketDAO;
import ec.edu.ups.proyecto.modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionFactura {

	@Inject
	private FacturaDAO daoFactura;

	 private static final int NUM_DIGITS = 6;
	
	private boolean isCodigoValido(int idFactura) {
		return idFactura !=0;
	}
	
	
	public void guardarFactura(Factura factura) throws Exception {
		
		
		if(daoFactura.read(factura.getIdFactura())==null) {
			try {
				daoFactura.insert(factura);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
		else {
			try {
				daoFactura.update(factura);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
	}
	
	public List<Factura> getFactura(){
		return daoFactura.getAll();
		
	}
	
	public void delete(int id) {
		daoFactura.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	public static String generarCodigoFactura() {
        String codigoFactura = generarCodigoAleatorio(NUM_DIGITS) + obtenerFechaActual();
        return codigoFactura;
    }
	private static String generarCodigoAleatorio(int numDigits) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < numDigits; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }

    private static String obtenerFechaActual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date fechaActual = new Date();
        return dateFormat.format(fechaActual);
    }
}
