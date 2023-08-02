package ec.edu.ups.proyecto.modelo;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Vehiculo {
	
	@Id
	@Column(name="placa")
    private String placa;
	
//	@OneToOne(mappedBy="vehiculo" ,fetch = FetchType.EAGER)
//	private Cliente cliente;
	
    
    public Vehiculo(){
        
    }


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa;
	}

	
    
}
