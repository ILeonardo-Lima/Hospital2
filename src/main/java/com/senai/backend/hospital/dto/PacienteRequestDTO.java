package com.senai.backend.hospital.dto;

public class PacienteRequestDTO {
    
    private String nome;
    private Integer idade;
    private String cpf;
    private String observacoes;

    

      // getters e setters (sem @NotNull)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

}

