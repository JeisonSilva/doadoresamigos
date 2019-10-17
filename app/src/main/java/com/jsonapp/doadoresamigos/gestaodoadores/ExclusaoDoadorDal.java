package com.jsonapp.doadoresamigos.gestaodoadores;

public interface ExclusaoDoadorDal {
    Integer obterCodigoDoador();

    void notificarCodigoInvalido();

    void notificarUsuarioInexistente();
}
