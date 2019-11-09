package com.jsonapp.doadoresamigos.gestaodoadores;

import java.util.ArrayList;

public interface DoadorRepositorio {
    DoadorDto pesquisarPorCodigo(Integer codDoador);

    void excluir(DoadorDto doadorDto);

    void registrar(DoadorDto doadorDto);

    void alterar(DoadorDto doadorDto);

    ArrayList<DoadorDto> listarDoadores();
}
