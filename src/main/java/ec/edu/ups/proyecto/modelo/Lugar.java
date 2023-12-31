package ec.edu.ups.proyecto.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Lugar {
	
	@Id
	@Column(nullable=false)
	private int nroLugar;
	
	@Column(nullable=false)
	private boolean estado;
	
	@OneToMany(mappedBy="lugar")
	private Set<Ticket> tickets;
	
	public Lugar() {
		
	}


	public int getNroLugar() {
		return nroLugar;
	}

	public void setNroLugar(int nroLugar) {
		this.nroLugar = nroLugar;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Lugar [nroLugar=" + nroLugar + ", estado=" + estado + "]";
	}
	
	
}
