package com.jsonapp.doadoresamigos.autenticacao;

public class NovaConta {
    private final NovaContaDal novaContaDal;
    private final NovaContaRepositorio novaContaRepositorio;

    public NovaConta(NovaContaDal novaContaDal, NovaContaRepositorio novaContaRepositorio) {
        this.novaContaDal = novaContaDal;
        this.novaContaRepositorio = novaContaRepositorio;
    }

    public void criarNovoUsuario() {
        ContaDto contaDto = this.novaContaDal.obterDadosDaConta();
        Conta conta = new Conta(contaDto.getUsuario(), contaDto.getSenha());

        if(this.novaContaDal.notificarPreenchimentoUsuario())
            return;

        if(this.novaContaDal.notificarPreenchimentoSenha())
            return;

        if(conta.ConfirmarSenha(contaDto.getConfirmacaoSenha()))
            this.novaContaRepositorio.registrar(contaDto);
        else
            this.novaContaDal.notificarConfirmacaoSenhaInvalida();
    }
}
