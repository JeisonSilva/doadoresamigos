package com.jsonapp.doadoresamigos.gestaodoadores;

class DoadorConvert {
    public static Doador converter(DoadorDto dadosInformadosPeloUsuario) {
        DadosPessoais dadosPessoais = new DadosPessoais(
                dadosInformadosPeloUsuario.getNome(),
                dadosInformadosPeloUsuario.getSobrenome(),
                dadosInformadosPeloUsuario.getIdade());

        DadosSanguineos dadosSanguineos = new DadosSanguineos(
                dadosInformadosPeloUsuario.getFatorRh(),
                dadosInformadosPeloUsuario.getTipoDeSangue()
        );
        EstadoFisico estadoFisico = new EstadoFisico(
                dadosInformadosPeloUsuario.getPeso(),
                dadosInformadosPeloUsuario.getAltura()
        );

        Doador doador = new Doador(dadosPessoais, dadosSanguineos, estadoFisico);
        return doador;
    }
}
