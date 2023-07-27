package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.VehiculoDAO;
import ec.edu.ups.proyecto.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionVehiculos {
	
	String cedulaCliente="";
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	public void guardarVehiculo(Vehiculo vehiculo) throws Exception {
		if(daoVehiculo.read(vehiculo.getPlaca())==null) {
			try {
				daoVehiculo.insert(vehiculo);
			}
			catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		} 
		else {
			try {
				daoVehiculo.update(vehiculo);
			}catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	public List<Vehiculo> getVehiculos(){
		return daoVehiculo.getAll();
	}
	
	public void delete(String Placa)
	{
		daoVehiculo.delete(Placa);
	}
}
