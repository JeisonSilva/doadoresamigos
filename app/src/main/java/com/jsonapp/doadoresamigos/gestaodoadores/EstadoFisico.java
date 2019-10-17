package com.jsonapp.doadoresamigos.gestaodoadores;

final class EstadoFisico {
    private Integer peso;
    private double altura;

    public EstadoFisico(Integer peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}
