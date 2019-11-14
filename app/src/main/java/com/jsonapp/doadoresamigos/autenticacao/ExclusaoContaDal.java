package com.jsonapp.doadoresamigos.autenticacao;

import android.content.DialogInterface;
import android.view.View;

public interface ExclusaoContaDal {
    void solicitarConfirmacaoDeConta(DialogInterface.OnClickListener excluirListener);

    boolean obterConfirmacao();

    void encerrarSessao();
}
