package com.jsonapp.doadoresamigos.gestaodoadores;

import java.util.ArrayList;

public class ExclusaoDoador {
    private final ExclusaoDoadorDal exclusaoDoadorDal;
    private final DoadorRepositorio doadorRepositorio;

    public ExclusaoDoador(ExclusaoDoadorDal exclusaoDoadorDal, DoadorRepositorio doadorRepositorio) {
        this.exclusaoDoadorDal = exclusaoDoadorDal;
        this.doadorRepositorio = doadorRepositorio;
    }

    public void excluirDoador() {
        Integer codDoador = this.exclusaoDoadorDal.obterCodigoDoador();
        DoadorDto doadorDto = this.doadorRepositorio.pesquisarPorCodigo(codDoador);

        if(codDoador == 0){
            this.exclusaoDoadorDal.notificarCodigoInvalido();
            return;
        }

        if(doadorDto == null){
            this.exclusaoDoadorDal.notificarUsuarioInexistente();
            return;
        }

        this.doadorRepositorio.excluir(doadorDto);

        ArrayList<DoadorDto> doadores = this.doadorRepositorio.listarDoadores();
        this.exclusaoDoadorDal.exibirNovaLista(doadores);

    }
}
