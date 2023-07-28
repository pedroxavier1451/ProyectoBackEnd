package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.LugarDAO;
import ec.edu.ups.proyecto.modelo.Lugar;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionLugar {
	
	@Inject 
	private LugarDAO daoLugar;
	
	private boolean isCodigoValido(int idLugar) {
		return idLugar ==0|| idLugar!=0;
	}
	
	public void guardarLugar(Lugar lugar) throws Exception {
		if(!this.isCodigoValido(lugar.getIdLugar()))
			throw new Exception("Codigo Incorrecto");
		
		
		if(daoLugar.read(lugar.getIdLugar()) == null) {
			try {
				daoLugar.insert(lugar);
			}catch(Exception e){
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoLugar.update(lugar);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
	}
	
	public List<Lugar> getLugar(){
		return daoLugar.getAll();
	}
	
	public void delete(int id) {
		daoLugar.delete(id);
	}
	
	public Lugar buscarLugar(int id) {
		return daoLugar.getLugar(id);
		
	}

}
