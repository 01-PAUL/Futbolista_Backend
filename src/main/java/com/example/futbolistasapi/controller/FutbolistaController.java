package com.example.futbolistasapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbolistasapi.entity.Futbolista;
import com.example.futbolistasapi.repository.FutbolistaRepository;
import com.example.futbolistasapi.util.AppSettings;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class FutbolistaController {

	@Autowired
	private FutbolistaRepository futbolista;
	
	@ResponseBody
	@GetMapping("/futbolista")
	public List<Futbolista> getAllFutbolistas() {
	    return futbolista.findAll();
	}
	
	@ResponseBody
	@GetMapping("/futbolista/{id}")
	public List<Futbolista> listaFutbolistaxID(@PathVariable("id")int idFutbolista){
		return  futbolista.listaFutbolistaxID(idFutbolista);
	}
}
