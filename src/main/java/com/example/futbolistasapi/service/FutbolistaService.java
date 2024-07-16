package com.example.futbolistasapi.service;

import java.util.Date;
import java.util.List;

import com.example.futbolistasapi.entity.Futbolista;
import com.example.futbolistasapi.entity.Posicion;

public interface FutbolistaService {
	
	//Para el crud
	public abstract Futbolista insertaFutbolista(Futbolista obj);
	public abstract List<Futbolista> listaFutbolistaxID(int idFutbolista);
	public abstract List<Futbolista> listaFutbolistaPorNombreLike(String filtro);
	public abstract void eliminaFutbolista(int idFutbolista);
	public abstract List<Futbolista> listaFutbolista();
	public abstract List<Posicion> listaPosicion();
	
	//Validaciones Para Registrar
	public abstract List<Futbolista> listaFutbolistaPorNombreIgualRegistra(String nombres, String apellidos);
	
	//Validaciones Para Actualizar
	public abstract List<Futbolista> listaFutbolistaPorNombreIgualActualiza(String nombres, String apellidos, int idFutbolista);
	
	//Para la consulta
	public abstract List<Futbolista> listaConsultaCompleja(String nombres, String apellidos, Date fechaNacDesde, Date fechaNacHasta, String caracteristicas, int idPosicion);
}
