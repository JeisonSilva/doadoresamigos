package com.jsonapp.doadoresamigos;

import com.jsonapp.doadoresamigos.autenticacao.ContaDto;

public abstract class ContaBaseTest {

    protected ContaDto configurarConta(String usuario, String senha, String confirmacaoSenha){
        ContaDto contaDto = new ContaDto();
        contaDto.setUsuario(usuario);
        contaDto.setSenha(senha);
        contaDto.setConfirmacaoSenha(confirmacaoSenha);

        return contaDto;
    }
}
