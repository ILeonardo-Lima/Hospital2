package com.senai.backend.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.hospital.models.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
}
