package com.jsonapp.doadoresamigos.gestaodoadores;

public interface DoadorDal {
    DoadorDto obterDadosInformadosPeloUsuario();

    DoadorDto obterDadosDoador();

    void notificarDadosInvalidos();

    void finalizarCadastro();

    boolean validarPreenchimentoDados();
}
