package ec.edu.ups.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {
	
	@Id
	@Column(name="vehi_placa", nullable=false)
	private String Placa;
	
	@Column(name="vehi_modelo", nullable=false)
	private String Modelo;

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [Placa=" + Placa + ", Modelo=" + Modelo + "]";
	}
	

}
