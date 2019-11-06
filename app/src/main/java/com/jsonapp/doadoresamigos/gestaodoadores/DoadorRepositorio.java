package com.jsonapp.doadoresamigos.gestaodoadores;

public interface DoadorRepositorio {
    DoadorDto pesquisarPorCodigo(Integer codDoador);

    void excluir(DoadorDto doadorDto);

    void registrar(DoadorDto doadorDto);

    void alterar(DoadorDto doadorDto);
}
