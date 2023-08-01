package ec.edu.ups.proyecto.datos;

import java.util.List;

import ec.edu.ups.proyecto.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class VehiculoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}

	public Vehiculo read(String placa) {
		Vehiculo v = em.find(Vehiculo.class, placa);
		return v;
	}

	public void delete(String placa) {
		Vehiculo v = em.find(Vehiculo.class, placa);
		em.remove(v);
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT v FROM Vehiculo v";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
	public Vehiculo getVehiculo(String placa) {
		Vehiculo v = em.find(Vehiculo.class, placa);
		return v;
	}
	
	public List<Vehiculo> getVehiculoCedula(String c) {
	    String jpql = "SELECT vehiculo.placa, vehiculo.modelo, vehiculo.cedula FROM cliente INNER JOIN vehiculo ON cliente.cedula = vehiculo.cedula WHERE cliente.cedula = :clienteCedula";
	    
	    Query q = em.createQuery(jpql);
	    q.setParameter("clienteCedula", c);
		return q.getResultList();
	    
	    
//	    TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
//	    query.setParameter("clienteCedula", c); // Estableces el valor de la variable "cedula" utilizando un parámetro
//	    System.out.print("-------- valores de dao -----------" + query.getSingleResult());
//	    return query.getSingleResult();
	}
	
	
}
