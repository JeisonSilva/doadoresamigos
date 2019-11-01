package com.jsonapp.doadoresamigos.autenticacao;

public interface NovaContaDal {
    ContaDto obterDadosDaConta();

    void notificarPreenchimentoUsuario();

    void notificarPreenchimentoSenha();

    void notificarConfirmacaoSenhaInvalida();

    void limparNotificacoes();

    void limparDadosDoUsuarioRegistrado();

    void sairDoCadastro();
}
