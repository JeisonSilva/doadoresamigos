package com.jsonapp.doadoresamigos.autenticacao;

public interface AlteracaoSenhaDal {
    ContaDto obterDadosContaDigitada();

    Void notificarUsuarioInexistente();

    Void notificarConfirmacaoSenhaInvalida();
}
