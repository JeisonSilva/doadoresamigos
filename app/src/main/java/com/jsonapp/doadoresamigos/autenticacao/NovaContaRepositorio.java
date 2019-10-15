package com.jsonapp.doadoresamigos.autenticacao;

public interface NovaContaRepositorio {
    void registrar(ContaDto contaDto);

    ContaDto obterConta(ContaDto contaDto);
}
