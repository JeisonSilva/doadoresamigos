package com.jsonapp.doadoresamigos.gestaodoadores;

import java.util.ArrayList;

public class PesquisaDoador {
    private final PesquisaDoadorDal pesquisaDoadorDal;
    private final DoadorRepositorio doadorRepositorio;

    public PesquisaDoador(PesquisaDoadorDal pesquisaDoadorDal, DoadorRepositorio doadorRepositorio) {
        this.pesquisaDoadorDal = pesquisaDoadorDal;
        this.doadorRepositorio = doadorRepositorio;
    }

    public void pesquisarDoadorPorCodigo() {
        Integer codDoador = this.pesquisaDoadorDal.obterCodigoPesquisa();
        DoadorDto doadorDto = this.doadorRepositorio.pesquisarPorCodigo(codDoador);

        if(codDoador == 0){
            this.pesquisaDoadorDal.notificarUsuarioDeCodigoDoadorInvalido();
            this.exibirDoadores();
            return;
        }

        if(doadorDto == null){
         this.pesquisaDoadorDal.notificarUsuarioDePesquisaSemRetornoDeDados();
         return;
        }

        this.pesquisaDoadorDal.exibirDoador(doadorDto);
    }

    public void exibirDoadores() {
        ArrayList<DoadorDto> doadores = this.doadorRepositorio.listarDoadores();
        this.pesquisaDoadorDal.exibirDoadores(doadores);
    }
}
