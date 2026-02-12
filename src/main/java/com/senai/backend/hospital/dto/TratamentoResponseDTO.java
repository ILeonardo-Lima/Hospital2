package com.senai.backend.hospital.dto;

public class TratamentoResponseDTO {
    
    private Integer id;  // ← campo que você quer retornar

    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // se quiser retornar mais coisas depois
    // private String nome;
    // public String getNome() { return nome; }
    // public void setNome(String nome) { this.nome = nome; }

}
