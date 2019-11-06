package com.jsonapp.doadoresamigos.gestaodoadores;

class DoadorValidation {
    public static boolean isValid(Doador doador) {
        DadosPessoais dadosPessoais = doador.getDadosPessoais();
        DadosSanguineos dadosSanguineos = doador.getDadosSanguineos();
        EstadoFisico estadoFisico = doador.getEstadoFisico();

        if(!validarDadosPessoais(dadosPessoais))
            return false;

        if(!validarDadosSanguenios(dadosSanguineos))
            return false;

        if(!validarDadosSobreEstadoFisico(estadoFisico))
            return false;

        return true;
    }

    private static boolean validarDadosPessoais(DadosPessoais dadosPessoais) {
        if(String.valueOf(dadosPessoais.getNome()).isEmpty() || dadosPessoais.getNome() == null)
            return false;

        if(String.valueOf(dadosPessoais.getSobrenome()).isEmpty() || dadosPessoais.getSobrenome() == null)
            return false;

        if(dadosPessoais.getIdade() == null)
            return false;

        return true;
    }

    private static boolean validarDadosSanguenios(DadosSanguineos dadosSanguineos) {
        if(String.valueOf(dadosSanguineos.getFatorRh()).isEmpty() || dadosSanguineos.getFatorRh() == null)
            return false;

        if(String.valueOf(dadosSanguineos.getTipoDeSangue()).isEmpty() || dadosSanguineos.getTipoDeSangue() == null)
            return false;

        return true;
    }

    private static boolean validarDadosSobreEstadoFisico(EstadoFisico estadoFisico) {
        if(estadoFisico.getAltura() == 0)
            return false;

        if(estadoFisico.getPeso() == 0)
            return false;

        return true;
    }
}
