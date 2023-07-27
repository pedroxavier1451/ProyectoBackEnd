package ec.edu.ups.proyecto.negocio;

import java.util.List;

import ec.edu.ups.proyecto.datos.ClienteDAO;
import ec.edu.ups.proyecto.modelo.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless

public class GestionClientes {
	
	@Inject 
	private ClienteDAO daoCliente;
	
	
	public void guardarClientes(Cliente cliente) throws Exception
	{
		
		if(daoCliente.read(cliente.getCedula())==null)
		{
			try {
				daoCliente.insert(cliente);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
		else {
			try {
				daoCliente.update(cliente);
			}catch (Exception e) {
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}
	}
	
	public boolean isCodigoValido(String cedula) {
		return cedula.length()<0 && cedula.length()>10;
	}
	
	public List<Cliente> getCliente(){
		return daoCliente.getAll();
	}
	
	public void delete(String cedula)
	{
		daoCliente.delete(cedula);
	}
	
	
}
