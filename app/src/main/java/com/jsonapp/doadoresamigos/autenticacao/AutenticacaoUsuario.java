package com.jsonapp.doadoresamigos.autenticacao;

public class AutenticacaoUsuario {
    private final AutenticacaoDal autenticacaoDal;
    private final ContaRepositorio contaRepositorio;

    public AutenticacaoUsuario(AutenticacaoDal autenticacaoDal, ContaRepositorio contaRepositorio) {
        this.autenticacaoDal = autenticacaoDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void autenticar() {
        ContaDto dadosDigitadosPeloUsuario = this.autenticacaoDal.obterDadosUsuario();
        ContaDto contaExistente = this.contaRepositorio.obterConta(dadosDigitadosPeloUsuario);

        if(contaExistente == null){
            this.autenticacaoDal.notificarUsuarioNaoCadastrado();
            return;
        }

        if(contaExistente.getUsuario().isEmpty() && contaExistente.getSenha().isEmpty())
            this.autenticacaoDal.notificarUsuarioNaoCadastrado();
        else{
            Conta conta = new Conta(contaExistente.getUsuario(), contaExistente.getSenha());

            if(!conta.confirmarUsuario(dadosDigitadosPeloUsuario.getUsuario())){
                this.autenticacaoDal.notificarUsuarioInvalido();
                return;
            }

            if(!conta.ConfirmarSenha(dadosDigitadosPeloUsuario.getSenha())){
                this.autenticacaoDal.notificarSenhaInvalida();
                return;
            }

            this.autenticacaoDal.exibirPesquisaDoadores();
        }

    }
}
