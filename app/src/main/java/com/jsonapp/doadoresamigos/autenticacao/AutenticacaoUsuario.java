package com.jsonapp.doadoresamigos.autenticacao;

public class AutenticacaoUsuario {
    private final AutenticacaoDal autenticacaoDal;
    private final NovaContaRepositorio contaRepositorio;

    public AutenticacaoUsuario(AutenticacaoDal autenticacaoDal, NovaContaRepositorio contaRepositorio) {
        this.autenticacaoDal = autenticacaoDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void autenticar() {
        ContaDto dadosDigitadosPeloUsuario = this.autenticacaoDal.obterDadosUsuario();
        ContaDto contaExistente = this.contaRepositorio.obterConta(dadosDigitadosPeloUsuario);
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
