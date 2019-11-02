package com.jsonapp.doadoresamigos.gestaodoadores;

public interface AlteracaoDoadorDal {
    DoadorDto obterDadosDoador();

    void notificarNomeInvalido();

    void notificarSobrenome();

    void norificarIdadeInvalida();

    void notificarAlturaInvalida();

    void notificarFatorRhInvalido();

    void notificarTipoSanguineoInvalido();

    void notificarPesoInvalido();
}
