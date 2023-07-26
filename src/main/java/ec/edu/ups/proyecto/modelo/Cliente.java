package ec.edu.ups.proyecto.modelo;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@Column(nullable = false)
    private String cedula;
	
	@Column(nullable = false)
    private String nombre;
	
	@Column(nullable = false)
    private String apellido;
	
	@Column(nullable = true)
    private String correo;
   
	@OneToMany(mappedBy="cliente")
	private Set<Vehiculo> vehiculos;
    
    public Cliente(){
        
    }

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + "]";	 
	}
    
    
}
