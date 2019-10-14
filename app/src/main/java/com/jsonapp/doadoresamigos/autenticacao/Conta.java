package com.jsonapp.doadoresamigos.autenticacao;

class Conta {
    private final String usuario;
    private final String senha;

    public Conta(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public boolean ConfirmarSenha(String confirmacaoSenha) {
        if(this.senha == null)
            return false;

        return this.senha.equals(confirmacaoSenha);
    }
}
