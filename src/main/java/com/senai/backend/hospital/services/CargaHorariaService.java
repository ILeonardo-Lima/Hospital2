package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.hospital.models.CargaHoraria;
import com.senai.backend.hospital.repositories.CargaHorariaRepository;

@Service
public class CargaHorariaService {
    
    @Autowired
    private CargaHorariaRepository cargaHorariaRepository;

    // salvar - POST
    public CargaHoraria salvar(CargaHoraria cargaHoraria) {
        return cargaHorariaRepository.save(cargaHoraria);
    }

    // buscar pelo id - GET
    public CargaHoraria buscarPorId(Integer id) {
        return cargaHorariaRepository.findById(id).get();
    }

    // listar todos - GET
    public List<CargaHoraria> listarTodos() {
        return cargaHorariaRepository.findAll();
    }

    // contar - GET
    public long contar() {
        return cargaHorariaRepository.count();
    }

    // remover pelo id - DELETE
    public boolean removerPorId(Integer id) {
        CargaHoraria ch = cargaHorariaRepository.findById(id).get();
        if (ch != null) {
            cargaHorariaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // atualizar - PUT
    public CargaHoraria atualizar(Integer id, CargaHoraria cargaHoraria) {
        CargaHoraria ch = cargaHorariaRepository.findById(id).get();
        if (cargaHoraria != null) {
            cargaHoraria.setId(ch.getId());
            return cargaHorariaRepository.save(cargaHoraria);
        }
        return null;
    }

}
