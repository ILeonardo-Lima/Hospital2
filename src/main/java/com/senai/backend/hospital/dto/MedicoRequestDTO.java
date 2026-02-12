package com.senai.backend.hospital.dto;

public class MedicoRequestDTO {
    private String nome;
    private String especializacao;
    private Integer limiteDiario;

    // getters e setters (sem @NotNull)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecializacao() { return especializacao; }
    public void setEspecializacao(String especializacao) { this.especializacao = especializacao; }

    public Integer getLimiteDiario() { return limiteDiario; }
    public void setLimiteDiario(Integer limiteDiario) { this.limiteDiario = limiteDiario; }
}
