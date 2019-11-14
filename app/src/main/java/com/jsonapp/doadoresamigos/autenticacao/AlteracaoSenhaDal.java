package com.jsonapp.doadoresamigos.autenticacao;

public interface AlteracaoSenhaDal extends AlteracaoSenhaDialogDal {
    ContaDto obterDadosContaDigitada();

    void notificarUsuarioInexistente();

    void notificarConfirmacaoSenhaInvalida();

    void limparNotificacoes();

    void notificarSenhaEmBranco();

    void finalizarAlteracao();
}
