package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.FacturaDAO;
import ec.edu.ups.proyecto.modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionFactura {

	@Inject
	private FacturaDAO daoFactura;
	
	private boolean isCodigoValido(int idFactura) {
		return idFactura !=0;
	}
	
	
	public void guardarFactura(Factura factura) throws Exception {
		if(!this.isCodigoValido(factura.getIdFactura()))
			throw new Exception("Codigo Incorrecto");
		
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
}
