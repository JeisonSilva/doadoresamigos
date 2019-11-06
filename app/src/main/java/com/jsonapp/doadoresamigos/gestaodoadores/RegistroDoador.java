package com.jsonapp.doadoresamigos.gestaodoadores;

public class RegistroDoador {
    private final DoadorDal doadorDal;
    private final DoadorRepositorio doadorRepositorio;

    public RegistroDoador(DoadorDal doadorDal, DoadorRepositorio doadorRepositorio) {
        this.doadorDal = doadorDal;
        this.doadorRepositorio = doadorRepositorio;
    }

    public void registrar() {
        if(this.doadorDal.validarPreenchimentoDados()){
            DoadorDto dadosInformadosPeloUsuario = this.doadorDal.obterDadosInformadosPeloUsuario();
            this.doadorRepositorio.registrar(dadosInformadosPeloUsuario);
            this.doadorDal.finalizarCadastro();
        }
    }
}
