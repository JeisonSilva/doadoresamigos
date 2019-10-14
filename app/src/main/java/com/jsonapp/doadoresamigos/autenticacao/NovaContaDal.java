package com.jsonapp.doadoresamigos.autenticacao;

public interface NovaContaDal {
    ContaDto obterDadosDaConta();

    void notificarConfirmacaoSenhaInvalida();

    boolean notificarPreenchimentoUsuario();

    boolean notificarPreenchimentoSenha();
}
