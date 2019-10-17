package com.jsonapp.doadoresamigos.gestaodoadores;

final class DadosPessoais {
    private String nome;
    private String sobrenome;
    private Integer idade;


    public DadosPessoais(String nome, String sobrenome, Integer idade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }
}
