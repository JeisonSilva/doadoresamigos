package com.jsonapp.doadoresamigos.gestaodoadores;

public class RegistroDoador {
    private final RegistroDoadorDal registroDoadorDal;
    private final DoadorRepositorio doadorRepositorio;

    public RegistroDoador(RegistroDoadorDal registroDoadorDal, DoadorRepositorio doadorRepositorio) {
        this.registroDoadorDal = registroDoadorDal;
        this.doadorRepositorio = doadorRepositorio;
    }

    public void registrar() {
        DoadorDto dadosInformadosPeloUsuario = this.registroDoadorDal.obterDadosInformadosPeloUsuario();
        this.doadorRepositorio.registrar(dadosInformadosPeloUsuario);
    }
}
