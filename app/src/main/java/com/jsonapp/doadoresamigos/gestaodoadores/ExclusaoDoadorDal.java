package com.jsonapp.doadoresamigos.gestaodoadores;

import java.util.ArrayList;

public interface ExclusaoDoadorDal {
    Integer obterCodigoDoador();

    void notificarCodigoInvalido();

    void notificarUsuarioInexistente();

    void exibirNovaLista(ArrayList<DoadorDto> doadores);
}
