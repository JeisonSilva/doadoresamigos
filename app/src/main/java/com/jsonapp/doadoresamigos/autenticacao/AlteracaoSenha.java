package com.jsonapp.doadoresamigos.autenticacao;

public class AlteracaoSenha {
    private final AlteracaoSenhaDal alteracaoSenhaDal;
    private final ContaRepositorio contaRepositorio;

    public AlteracaoSenha(AlteracaoSenhaDal alteracaoSenhaDal, ContaRepositorio contaRepositorio) {
        this.alteracaoSenhaDal = alteracaoSenhaDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void alterarSenha() {
        ContaDto contaDto = this.alteracaoSenhaDal.obterDadosContaDigitada();
        ContaDto contaExistenteDto = this.contaRepositorio.obterConta(contaDto);
        Conta conta = new Conta(contaExistenteDto.getUsuario(), contaExistenteDto.getSenha());

        if(contaDto.getUsuario().equals(contaExistenteDto.getUsuario()))
            conta.alterarSenha(contaDto.getSenha());
        else
            this.alteracaoSenhaDal.notificarUsuarioInexistente();

        if(conta.ConfirmarSenha(contaDto.getConfirmacaoSenha()))
            this.contaRepositorio.alterar(contaDto);
        else
            this.alteracaoSenhaDal.notificarConfirmacaoSenhaInvalida();
    }
}
