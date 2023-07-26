package ec.edu.ups.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Lugar {
	
	@Id
	@GeneratedValue
	@Column(name="lu_id")
	private int id_Lugar;
	
	@Column(name="lu_NroLugar",nullable=false)
	private int nroLugar;
	
	@Column(name="lu_estado", nullable=false)
	private boolean estado;

	public int getId_Lugar() {
		return id_Lugar;
	}

	public void setId_Lugar(int id_Lugar) {
		this.id_Lugar = id_Lugar;
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
		return "Lugar [id_Lugar=" + id_Lugar + ", nroLugar=" + nroLugar + ", estado=" + estado + "]";
	}
	
	
}
