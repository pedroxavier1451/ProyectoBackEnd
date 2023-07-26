package ec.edu.ups.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	@Column(name="tic_Id")
	private int Id;
	
	@Column(name="tic_HoraIngreso",nullable=false)
	private Date HoraIngreso;
	
	@Column(name="tic_HoraSalida")
	private Date HoraSalida;
	
	@Column(name="tic_Precio",nullable=false)
	private Double Precio;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getHoraIngreso() {
		return HoraIngreso;
	}

	public void setHoraIngreso(Date horaIngreso) {
		HoraIngreso = horaIngreso;
	}

	public Date getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		HoraSalida = horaSalida;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	@Override
	public String toString() {
		return "Ticket [Id=" + Id + ", HoraIngreso=" + HoraIngreso + ", HoraSalida=" + HoraSalida + ", Precio=" + Precio
				+ "]";
	}
	
	

}
