package com.jsonapp.doadoresamigos.autenticacao;

import android.content.DialogInterface;
import android.view.View;

public class ExclusaoConta {
    private final ExclusaoContaDal exclusaoContaDal;
    private final ContaRepositorio contaRepositorio;

    public ExclusaoConta(ExclusaoContaDal exclusaoContaDal, ContaRepositorio contaRepositorio) {
        this.exclusaoContaDal = exclusaoContaDal;
        this.contaRepositorio = contaRepositorio;
    }

    public void excluirConta() {
        this.exclusaoContaDal.solicitarConfirmacaoDeConta(excluirListener);


    }

    DialogInterface.OnClickListener excluirListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            contaRepositorio.excluirConta();
            exclusaoContaDal.encerrarSessao();
        }
    };
}
