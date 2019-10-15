package com.jsonapp.doadoresamigos.autenticacao;

public interface ContaRepositorio {
    void registrar(ContaDto contaDto);

    void alterar(ContaDto contaDto);

    ContaDto obterConta(ContaDto contaDto);

    void excluirConta(ContaDto contaDto);
}
