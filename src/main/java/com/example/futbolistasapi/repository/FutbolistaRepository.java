package com.example.futbolistasapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.futbolistasapi.entity.Futbolista;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Integer>{

	@Query("Select f from Futbolista f where f.nombres like ?1")
	public abstract List<Futbolista> listaPorNombreLike(String filtro);
	
	@Query("Select f from Futbolista f where f.idFutbolista = ?1")
    public abstract List<Futbolista> listaFutbolistaxID(int idFutbolista);
	 
	@Query("select f from Futbolista f where f.nombres = ?1 and f.apellidos = ?2")
	public abstract List<Futbolista> listaPorNombreIgualRegistra(String nombres, String apellidos);
	
	@Query("select f from Futbolista f where f.nombres = ?1 and f.apellidos = ?2 and f.idFutbolista != ?3")
	public abstract List<Futbolista> listaPorNombreIgualActualiza(String nombres, String apellidos, int idFutbolista);
		
	@Query("select f from Futbolista f where"
	    + " f.nombres like ?1 and"
	    + " f.apellidos like ?2 and"
	    + " f.fechaNacimiento >= ?3 and"
	    + " f.fechaNacimiento <=  ?4 and"
	    + " f.caracteristicas like ?5 and"
	    + " (?6 = -1 or f.posicion.idPosicion = ?6)")
	public abstract List<Futbolista> listaConsultaCompleja(String nombres, String apellidos, Date fechaNacDesde, Date fechaNacHasta, String caracteristicas, int idPosicion);

}
