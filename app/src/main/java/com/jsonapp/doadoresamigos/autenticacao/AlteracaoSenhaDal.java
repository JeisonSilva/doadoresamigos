package com.jsonapp.doadoresamigos.autenticacao;

public interface AlteracaoSenhaDal extends AlteracaoSenhaDialogDal {
    ContaDto obterDadosContaDigitada();

    Void notificarUsuarioInexistente();

    Void notificarConfirmacaoSenhaInvalida();
}
