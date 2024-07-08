package com.example.futbolistasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.futbolistasapi.entity.Futbolista;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Integer>{

    @Query("Select f from Futbolista f where f.idFutbolista = ?1")
    public abstract List<Futbolista> listaFutbolistaxID(int idFutbolista);
    
}
