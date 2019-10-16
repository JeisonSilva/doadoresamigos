package com.jsonapp.doadoresamigos.gestaodoadores;

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
            return;
        }

        if(doadorDto == null){
         this.pesquisaDoadorDal.notificarUsuarioDePesquisaSemRetornoDeDados();
         return;
        }

        this.pesquisaDoadorDal.exibirDoador(doadorDto);
    }
}
