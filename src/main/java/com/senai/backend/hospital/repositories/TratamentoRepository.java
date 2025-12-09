package com.senai.backend.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.hospital.models.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Integer>{
    
}
