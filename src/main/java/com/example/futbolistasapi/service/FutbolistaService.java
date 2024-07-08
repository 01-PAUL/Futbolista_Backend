package com.example.futbolistasapi.service;

import java.util.List;

import com.example.futbolistasapi.entity.Futbolista;

public interface FutbolistaService {

	public abstract List<Futbolista> listaFutbolista();
	public abstract List<Futbolista> listaFutbolistaxID(int idFutbolista);
	
}
