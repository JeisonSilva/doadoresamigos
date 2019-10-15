package com.jsonapp.doadoresamigos.autenticacao;

public interface AutenticacaoDal {
    ContaDto obterDadosUsuario();

    void exibirPesquisaDoadores();

    void notificarUsuarioInvalido();

    void notificarSenhaInvalida();
}
