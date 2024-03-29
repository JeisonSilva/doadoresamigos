package com.jsonapp.doadoresamigos.gestaodoadores;

import java.io.Serializable;

public class DoadorDto implements Serializable {
    private int codigo;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String fatorRh;
    private String tipoDeSangue;
    private double peso;
    private double altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getFatorRh() {
        return fatorRh;
    }

    public void setFatorRh(String fatorRh) {
        this.fatorRh = fatorRh;
    }

    public String getTipoDeSangue() {
        return tipoDeSangue;
    }

    public void setTipoDeSangue(String tipoDeSangue) {
        this.tipoDeSangue = tipoDeSangue;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
