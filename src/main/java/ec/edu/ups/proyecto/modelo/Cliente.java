package ec.edu.ups.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Cliente {
	
	@Id
	@Column(name="cli_Cedula")
	private String Cedula;
	
	@Column(name="cli_Nombre",nullable=false )
	private String Nombre;
	
	@Column(name="cli_Apellido",nullable=false)
	private String Apellido;
	
	@Column(name="cli_Correo")
	private String Correo;

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [Cedula=" + Cedula + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Correo=" + Correo
				+ "]";
	}
	
	

}
