package com.jsonapp.doadoresamigos.autenticacao;

public class ExclusaoConta {
    private final ExclusaoContaDal exclusaoContaDal;
    private final ContaRepositorio contaRepositorio;

    public ExclusaoConta(ExclusaoContaDal exclusaoContaDal, ContaRepositorio contaRepositorio) {
        this.exclusaoContaDal = exclusaoContaDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void excluirConta() {
        ContaDto contaDto = this.exclusaoContaDal.obterDadosConta();
        this.contaRepositorio.excluirConta(contaDto);
        this.exclusaoContaDal.encerrarSessao();
    }
}
