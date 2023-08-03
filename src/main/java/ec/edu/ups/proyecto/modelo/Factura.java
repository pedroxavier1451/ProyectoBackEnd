package ec.edu.ups.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class Factura {
	
	@Id
	@GeneratedValue
	@Column(name="idFactura")
	private int idFactura;
	
	@Column(nullable=false)
	private String codigo;
	
	@Column(nullable=false)
	private Date fecha;
	
	@Column(nullable=false)
	private double total;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTicket")
	private Ticket ticket;
	
	public Factura() {
		
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", codigo=" + codigo + ", fecha=" + fecha + ", total=" + total
				+ ", ticket=" + ticket + "]";
	}
	
}
