package ec.edu.ups.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Vehiculo {
	
	@Id
	@Column(nullable = false)
    private String placa;
	
	@Column(nullable = true)
    private String modelo;
	
	@ManyToOne
	@JoinColumn(name="Cedula")
	private Cliente cliente;
    
    public Vehiculo(){
        
    }

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", cliente=" + cliente + "]";
	}
    
}
