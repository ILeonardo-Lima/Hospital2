package com.senai.backend.hospital.dto;

public class MedicoRequestDTO {
    
    private String nome;
    private String especializacao;
    private Integer limiteDiario;

    public MedicoRequestDTO() {
    }

    public MedicoRequestDTO(String nome, String especializacao, Integer limiteDiario) {
        this.nome = nome;
        this.especializacao = especializacao;
        this.limiteDiario = limiteDiario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Integer getLimiteDiario() {
        return limiteDiario;
    }

     void setLimiteDiario(Integer limitediario) {
        this.limiteDiario = limiteDiario;
    }



}
