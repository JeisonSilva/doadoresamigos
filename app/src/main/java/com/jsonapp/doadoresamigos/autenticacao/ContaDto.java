package com.jsonapp.doadoresamigos.autenticacao;

public class ContaDto {
    private String usuario;
    private String senha;
    private String confirmacaoSenha;

    public ContaDto() {
        usuario = "";
        senha = "";
        confirmacaoSenha = "";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }
}
