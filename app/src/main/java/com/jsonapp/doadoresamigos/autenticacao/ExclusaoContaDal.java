package com.jsonapp.doadoresamigos.autenticacao;

public interface ExclusaoContaDal {
    ContaDto obterDadosConta();

    void encerrarSessao();
}
