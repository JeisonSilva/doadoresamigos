package com.jsonapp.doadoresamigos.gestaodoadores;

public class DoadorDto {
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String fatorRh;
    private String tipoDeSangue;
    private Integer peso;
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

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
