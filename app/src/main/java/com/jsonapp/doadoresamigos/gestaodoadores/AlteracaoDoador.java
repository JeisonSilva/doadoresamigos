package com.jsonapp.doadoresamigos.gestaodoadores;

public class AlteracaoDoador {
    private final DoadorDal doadorDal;
    private final DoadorRepositorio doadorRepositorio;

    public AlteracaoDoador(DoadorDal doadorDal, DoadorRepositorio doadorRepositorio) {
        this.doadorDal = doadorDal;
        this.doadorRepositorio = doadorRepositorio;
    }

    public void alterar() {
        DoadorDto dadosDoadorAtualizado  = doadorDal.obterDadosInformadosPeloUsuario();

        if(this.doadorDal.validarPreenchimentoDados()){
            this.doadorRepositorio.alterar(dadosDoadorAtualizado);
            this.doadorDal.finalizarCadastro();
        }
    }
}
