package com.jsonapp.doadoresamigos.autenticacao;

public class NovaConta {
    private final NovaContaDal novaContaDal;
    private final ContaRepositorio contaRepositorio;

    public NovaConta(NovaContaDal novaContaDal, ContaRepositorio contaRepositorio) {
        this.novaContaDal = novaContaDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void criarNovoUsuario() {
        ContaDto contaDto = this.novaContaDal.obterDadosDaConta();
        Conta conta = new Conta(contaDto.getUsuario(), contaDto.getSenha());

        if(this.novaContaDal.notificarPreenchimentoUsuario())
            return;

        if(this.novaContaDal.notificarPreenchimentoSenha())
            return;

        if(conta.ConfirmarSenha(contaDto.getConfirmacaoSenha()))
            this.contaRepositorio.registrar(contaDto);
        else
            this.novaContaDal.notificarConfirmacaoSenhaInvalida();
    }
}
