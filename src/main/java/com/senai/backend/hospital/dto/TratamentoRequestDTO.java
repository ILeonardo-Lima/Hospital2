package com.senai.backend.hospital.dto;

public class TratamentoRequestDTO {
       
    private String descricao;
    private Double custo;
    private int duracaoMinutos;
    
      // getters e setters (sem @NotNull)
    public String getDescricao() { return descricao; }
    public void setNome(String descricao) { this.descricao = descricao; }

    public Double getCusto() { return custo; }
    public void setCusto(Double custo) { this.custo = custo; }

    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }

}