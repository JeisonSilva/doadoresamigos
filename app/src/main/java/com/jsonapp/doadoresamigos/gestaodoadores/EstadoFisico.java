package com.jsonapp.doadoresamigos.gestaodoadores;

final class EstadoFisico {
    private double peso;
    private double altura;

    public EstadoFisico(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}
