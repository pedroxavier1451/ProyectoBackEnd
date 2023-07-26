package ec.edu.ups.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Factura {
	
	@Id
	@GeneratedValue
	@Column(name="fac_Id")
	private int idFactura;
	
	@Column(name="fac_Codigo", nullable=false)
	private int codigo;
	
	@Column(name="fac_Fecha", nullable=false)
	private Date fecha;
	
	@Column(name="fac_Total",nullable=false)
	private double total;

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + "]";
	}
	
	
}
