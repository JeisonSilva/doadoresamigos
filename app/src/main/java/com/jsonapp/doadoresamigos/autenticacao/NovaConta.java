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

        this.novaContaDal.limparNotificacoes();
        if(validarDados(conta, contaDto)){
            this.contaRepositorio.registrar(contaDto);
            this.novaContaDal.limparDadosDoUsuarioRegistrado();
            this.novaContaDal.sairDoCadastro();
        }
    }

    private boolean validarDados(Conta conta, ContaDto contaDto) {
        if(conta.usuarioNaoPreenchido()){
            this.novaContaDal.notificarPreenchimentoUsuario();
            return false;
        }

        if(conta.senhaNaoPreenchida()){
            this.novaContaDal.notificarPreenchimentoSenha();
            return false;
        }

        if(!conta.ConfirmarSenha(contaDto.getConfirmacaoSenha())){
            this.novaContaDal.notificarConfirmacaoSenhaInvalida();
            return false;
        }

        return true;

    }
}
