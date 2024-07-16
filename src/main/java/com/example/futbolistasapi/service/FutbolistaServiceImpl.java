package com.example.futbolistasapi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futbolistasapi.entity.Futbolista;
import com.example.futbolistasapi.entity.Posicion;
import com.example.futbolistasapi.repository.FutbolistaRepository;
import com.example.futbolistasapi.repository.PosicionRepository;

@Service
public class FutbolistaServiceImpl implements FutbolistaService{

	@Autowired
	private FutbolistaRepository repository;
	@Autowired
	private PosicionRepository posicionRepository;
	
	@Override
	public List<Futbolista> listaFutbolista() {
		return repository.findAll();
	}

	@Override
	public Futbolista insertaFutbolista(Futbolista obj) {
		return repository.save(obj);
	}

	@Override
	public List<Futbolista> listaFutbolistaPorNombreLike(String filtro) {
		return repository.listaPorNombreLike(filtro);
	}

	@Override
	public void eliminaFutbolista(int idFutbolista) {
		repository.deleteById(idFutbolista);
	}

	@Override
	public List<Futbolista> listaFutbolistaPorNombreIgualRegistra(String nombres, String apellidos) {
		return repository.listaPorNombreIgualRegistra(nombres,apellidos);
	}

	@Override
	public List<Futbolista> listaFutbolistaPorNombreIgualActualiza(String nombres, String apellidos, int idFutbolista) {
		return repository.listaPorNombreIgualActualiza(nombres,apellidos, idFutbolista);
	}

	@Override
	public List<Futbolista> listaConsultaCompleja(String nombres, String apellidos, Date fechaNacDesde,
			Date fechaNacHasta, String caracteristicas, int idPosicion) {
		return repository.listaConsultaCompleja(nombres, apellidos, fechaNacDesde,
                fechaNacHasta, caracteristicas, idPosicion);
	}

	@Override
	public List<Posicion> listaPosicion() {
		return posicionRepository.findAll();
	}

	@Override
	public List<Futbolista> listaFutbolistaxID(int idFutbolista) {
		return repository.listaFutbolistaxID(idFutbolista);
	}

}
