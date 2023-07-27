package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.VehiculoDAO;
import ec.edu.ups.proyecto.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionVehiculos {
	/*
	@Inject
	private VehiculoDAO daoVehiculo;
	
	public void guardarVehiculo(Vehiculo vehiculo) {
		if(daoVehiculo.read(vehiculo.getIdVehiculo()==null)) {
			try {
				daoVehiculo.insert(vehiculo)
			}
			catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		} 
		else {
			try {
				daoVehiculo.update(vehiculo)
			}catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	public List<Vehiculo> getVehiculos(){
		return daoVehiculo.getAll();
	}
	
	public void delete(int id)
	{
		daoVehiculo.delete(id);
	}
*/
}
