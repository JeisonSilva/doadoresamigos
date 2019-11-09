package com.jsonapp.doadoresamigos.gestaodoadores;

import java.util.ArrayList;

public interface PesquisaDoadorDal {
    void exibirDoador(DoadorDto doadorDto);

    Integer obterCodigoPesquisa();

    void notificarUsuarioDePesquisaSemRetornoDeDados();

    void notificarUsuarioDeCodigoDoadorInvalido();

    void exibirDoadores(ArrayList<DoadorDto> doadores);
}
