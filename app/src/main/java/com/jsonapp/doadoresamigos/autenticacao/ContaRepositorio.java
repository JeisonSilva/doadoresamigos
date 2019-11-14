package com.jsonapp.doadoresamigos.autenticacao;

public interface ContaRepositorio {
    void registrar(ContaDto contaDto);

    void alterar(ContaDto contaDto);
    @Deprecated
    ContaDto obterConta(ContaDto contaDto);

    void excluirConta(ContaDto contaDto);

    ContaDto obterConta();
}
