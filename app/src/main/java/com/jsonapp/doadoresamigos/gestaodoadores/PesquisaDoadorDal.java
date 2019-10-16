package com.jsonapp.doadoresamigos.gestaodoadores;

public interface PesquisaDoadorDal {
    void exibirDoador(DoadorDto doadorDto);

    Integer obterCodigoPesquisa();

    void notificarUsuarioDePesquisaSemRetornoDeDados();

    void notificarUsuarioDeCodigoDoadorInvalido();
}
