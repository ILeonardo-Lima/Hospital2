package com.senai.backend.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.hospital.models.CargaHoraria;

@Repository
public interface CargaHorariaRepository extends JpaRepository<CargaHoraria, Integer>{
    
}
