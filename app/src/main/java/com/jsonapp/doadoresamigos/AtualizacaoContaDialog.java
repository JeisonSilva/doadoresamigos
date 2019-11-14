package com.jsonapp.doadoresamigos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jsonapp.doadoresamigos.autenticacao.AlteracaoSenhaDal;
import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.NovaConta;

public class AtualizacaoContaDialog extends AppCompatDialogFragment implements AlteracaoSenhaDal {
    private static final String DIALOG_TAG    = "atualizacaoUsuarioDialog";
    private TextInputLayout inputTextUsuario;
    private TextInputLayout inputTextSenha;
    private TextInputEditText inputEditUsuario;
    private TextInputEditText inputEditSenha;
    private AppCompatButton btnRegistrar;
    private AppCompatButton btnCancelar;
    private TextInputLayout inputTextConfirmacao;
    private TextInputEditText inputEditConfirmacao;


    public static AtualizacaoContaDialog newInstance(Bundle args) {
        AtualizacaoContaDialog fragment = new AtualizacaoContaDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public void openDialog(FragmentManager fm){
        if(fm.findFragmentByTag(DIALOG_TAG) == null)
            show(fm, DIALOG_TAG);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_usuario, container, false);
        inputTextUsuario = view.findViewById(R.id.inputTextUsuario);
        inputTextSenha = view.findViewById(R.id.inputTextSenha);
        inputTextConfirmacao = view.findViewById(R.id.inputTextConfirmcaoSenha);
        inputEditUsuario = view.findViewById(R.id.inputEditUsuario);
        inputEditSenha = view.findViewById(R.id.inputEditSenha);
        inputEditConfirmacao = view.findViewById(R.id.inputEditConfirmacaoSenha);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);
        btnCancelar = view.findViewById(R.id.btnCancelar);

        btnRegistrar.setOnClickListener(registrarListener);
        btnCancelar.setOnClickListener(cancelarListener);

        ContaDto contaDto = (ContaDto) getArguments().getSerializable("conta");
        exibirDadosContaUsuario(contaDto);

        return view;
    }

    View.OnClickListener registrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener cancelarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    };

    @Override
    public ContaDto obterDadosContaDigitada() {
        return null;
    }

    @Override
    public Void notificarUsuarioInexistente() {
        return null;
    }

    @Override
    public Void notificarConfirmacaoSenhaInvalida() {
        return null;
    }

    @Override
    public void exibirDadosContaUsuario(ContaDto contaDto) {
        inputEditUsuario.setText(contaDto.getUsuario());
        inputTextUsuario.setEnabled(false);
    }
}
