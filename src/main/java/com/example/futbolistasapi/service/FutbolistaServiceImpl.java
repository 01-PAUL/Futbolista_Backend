package com.example.futbolistasapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futbolistasapi.entity.Futbolista;
import com.example.futbolistasapi.repository.FutbolistaRepository;

@Service
public class FutbolistaServiceImpl implements FutbolistaService{

	@Autowired
	private FutbolistaRepository repository;
	
	@Override
	public List<Futbolista> listaFutbolista() {
		return repository.findAll();
	}

	@Override
	public List<Futbolista> listaFutbolistaxID(int idFutbolista) {
		return repository.listaFutbolistaxID(idFutbolista);
	}

}
