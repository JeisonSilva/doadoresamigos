package com.jsonapp.doadoresamigos.autenticacao;

public class AlteracaoSenha {
    private AlteracaoSenhaDal alteracaoSenhaDal;
    private final ContaRepositorio contaRepositorio;
    private AlteracaoSenhaDialogDal alteracaoSenhaDialogDal;

    public AlteracaoSenha(AlteracaoSenhaDal alteracaoSenhaDal, ContaRepositorio contaRepositorio) {
        this.alteracaoSenhaDal = alteracaoSenhaDal;
        this.contaRepositorio = contaRepositorio;
    }

    public AlteracaoSenha(AlteracaoSenhaDialogDal alteracaoSenhaDialogDal, ContaRepositorio contaRepositorio) {
        this.alteracaoSenhaDialogDal = alteracaoSenhaDialogDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void alterarSenha() {
        ContaDto contaDto = this.alteracaoSenhaDal.obterDadosContaDigitada();
        ContaDto contaExistenteDto = this.contaRepositorio.obterConta();
        Conta conta = new Conta(contaExistenteDto.getUsuario(), contaExistenteDto.getSenha());

        this.alteracaoSenhaDal.limparNotificacoes();

        if(contaDto.getSenha().isEmpty()){
            this.alteracaoSenhaDal.notificarSenhaEmBranco();

        }else if(!conta.ConfirmarSenha(contaDto.getConfirmacaoSenha())){
            this.alteracaoSenhaDal.notificarConfirmacaoSenhaInvalida();

        }else{
            conta.alterarSenha(contaDto.getSenha());
            this.contaRepositorio.alterar(contaDto);
            this.alteracaoSenhaDal.finalizarAlteracao();
        }
    }

    public void exibirContaCadastrada() {
        ContaDto contaDto = this.contaRepositorio.obterConta();
        alteracaoSenhaDialogDal.exibirDadosContaUsuario(contaDto);
    }
}
