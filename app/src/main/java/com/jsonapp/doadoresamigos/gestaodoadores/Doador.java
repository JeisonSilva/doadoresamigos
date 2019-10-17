package com.jsonapp.doadoresamigos.gestaodoadores;

class Doador {
    private final DadosPessoais dadosPessoais;
    private final DadosSanguineos dadosSanguineos;
    private final EstadoFisico estadoFisico;


    public Doador(DadosPessoais dadosPessoais, DadosSanguineos dadosSanguineos, EstadoFisico estadoFisico) {
        this.dadosPessoais = dadosPessoais;
        this.dadosSanguineos = dadosSanguineos;
        this.estadoFisico = estadoFisico;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public DadosSanguineos getDadosSanguineos() {
        return dadosSanguineos;
    }

    public EstadoFisico getEstadoFisico() {
        return estadoFisico;
    }
}
