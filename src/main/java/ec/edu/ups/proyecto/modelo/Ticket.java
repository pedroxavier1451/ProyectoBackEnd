package ec.edu.ups.proyecto.modelo;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	@Column(name="idTicket")
	private int idTicket;
	
	@Column(nullable=false)
	private Date HoraIngreso;
	
	@Column(nullable=false)
	private Date HoraSalida;
	
	@Column(nullable=false)
	private Double Precio;
	
	@ManyToOne
	@JoinColumn(name="placa")
	private Vehiculo vehiculo;

	@ManyToOne
	@JoinColumn(name="idLugar")
	private Lugar lugar;
	
	@OneToMany(mappedBy="ticket")
	private Set<Factura> facturas;
	
	public Ticket() {
		
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
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


	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", HoraIngreso=" + HoraIngreso + ", HoraSalida=" + HoraSalida
				+ ", Precio=" + Precio + ", vehiculo=" + vehiculo + ", lugar=" + lugar + "]";
	}

}
