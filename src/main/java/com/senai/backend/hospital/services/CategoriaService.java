package com.senai.backend.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.hospital.models.Categoria;
import com.senai.backend.hospital.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    // salvar - POST
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // buscar pelo id - GET
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id).get();
    }

    // listar todos - GET
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    // contar - GET
    public long contar() {
        return categoriaRepository.count();
    }

    // remover pelo id - DELETE
    public boolean removerPorId(Integer id) {
        Categoria cat = categoriaRepository.findById(id).get();
        if (cat != null) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // atualizar - PUT
    public Categoria atualizar(Integer id, Categoria categoria) {
        Categoria cat = categoriaRepository.findById(id).get();
        if (categoria != null) {
            categoria.setId(cat.getId());
            return categoriaRepository.save(categoria);
        }
        return null;
    }

}
