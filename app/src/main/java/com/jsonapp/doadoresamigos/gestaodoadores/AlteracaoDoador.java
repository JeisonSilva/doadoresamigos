package com.jsonapp.doadoresamigos.gestaodoadores;

public class AlteracaoDoador {
    private final AlteracaoDoadorDal doadorDal;
    private final DoadorRepositorio doadorRepositorio;

    public AlteracaoDoador(AlteracaoDoadorDal doadorDal, DoadorRepositorio doadorRepositorio) {
        this.doadorDal = doadorDal;
        this.doadorRepositorio = doadorRepositorio;
    }

    public void alterar() {
        DoadorDto dadosDoadorAtualizado  = doadorDal.obterDadosDoador();

        if(validarDados(dadosDoadorAtualizado))
            this.doadorRepositorio.alterar(dadosDoadorAtualizado);
    }

    private boolean validarDados(DoadorDto dadosDoadorAtualizado) {
        if(dadosDoadorAtualizado.getNome().isEmpty()){
            this.doadorDal.notificarNomeInvalido();
            return false;
        }

        if(dadosDoadorAtualizado.getSobrenome().isEmpty()){
            this.doadorDal.notificarSobrenome();
            return false;
        }

        if(dadosDoadorAtualizado.getIdade() == 0){
            this.doadorDal.norificarIdadeInvalida();
            return false;
        }

        if(dadosDoadorAtualizado.getAltura() == 0.0){
            this.doadorDal.notificarAlturaInvalida();
            return false;
        }

        if(dadosDoadorAtualizado.getFatorRh().isEmpty()){
            this.doadorDal.notificarFatorRhInvalido();
            return false;
        }

        if(dadosDoadorAtualizado.getTipoDeSangue().isEmpty()){
            this.doadorDal.notificarTipoSanguineoInvalido();
            return false;
        }

        if(dadosDoadorAtualizado.getPeso() == 0){
            this.doadorDal.notificarPesoInvalido();
            return false;
        }
        return true;
    }
}
