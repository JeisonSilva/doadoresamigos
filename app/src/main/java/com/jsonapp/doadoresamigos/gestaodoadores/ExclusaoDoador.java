package com.jsonapp.doadoresamigos.gestaodoadores;

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

    }
}
