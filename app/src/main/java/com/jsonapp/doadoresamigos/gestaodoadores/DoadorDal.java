package com.jsonapp.doadoresamigos.gestaodoadores;

public interface DoadorDal {
    DoadorDto obterDadosInformadosPeloUsuario();

    void notificarDadosInvalidos();

    void finalizarCadastro();

    boolean validarPreenchimentoDados();
}
