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
import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.ContaRepositorioImpl;
import com.jsonapp.doadoresamigos.autenticacao.NovaConta;
import com.jsonapp.doadoresamigos.autenticacao.NovaContaDal;

public class CadastroContaDialog extends AppCompatDialogFragment implements NovaContaDal {

    private static final String DIALOG_TAG    = "cadastroUsuarioDialog";
    private TextInputLayout inputTextUsuario;
    private TextInputLayout inputTextSenha;
    private TextInputEditText inputEditUsuario;
    private TextInputEditText inputEditSenha;
    private AppCompatButton btnRegistrar;
    private AppCompatButton btnCancelar;
    private NovaConta novaConta;
    private TextInputLayout inputTextConfirmacao;
    private TextInputEditText inputEditConfirmacao;

    public static CadastroContaDialog newInstance(Bundle args) {

        CadastroContaDialog fragment = new CadastroContaDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public static CadastroContaDialog newInstance() {

        CadastroContaDialog fragment = new CadastroContaDialog();
        return fragment;
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
        novaConta = new NovaConta(this, new ContaRepositorioImpl(getContext()));

        return view;
    }

    View.OnClickListener registrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            novaConta.criarNovoUsuario();
        }
    };

    View.OnClickListener cancelarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    };

    public void openDialog(FragmentManager fm){
        if(fm.findFragmentByTag(DIALOG_TAG) == null)
            show(fm, DIALOG_TAG);
    }

    @Override
    public ContaDto obterDadosDaConta() {
        String usuario = String.valueOf(inputEditUsuario.getText());
        String senha = String.valueOf(inputEditSenha.getText());
        String confirmacao = String.valueOf(inputEditConfirmacao.getText());
        ContaDto contaDto = new ContaDto();

        contaDto.setUsuario(usuario);
        contaDto.setSenha(senha);
        contaDto.setConfirmacaoSenha(confirmacao);

        return contaDto;
    }

    @Override
    public void notificarPreenchimentoUsuario() {
        inputTextUsuario.setErrorEnabled(true);
        inputTextUsuario.setError("Digite um usuário");
    }

    @Override
    public void notificarPreenchimentoSenha() {
        inputTextSenha.setErrorEnabled(true);
        inputTextSenha.setError("Digite uma senha");
    }

    @Override
    public void notificarConfirmacaoSenhaInvalida() {
        inputTextConfirmacao.setErrorEnabled(true);
        inputTextConfirmacao.setError("Confirmação de senha inválida");
    }

    @Override
    public void limparNotificacoes() {
        inputTextUsuario.setErrorEnabled(false);
        inputTextSenha.setErrorEnabled(false);
        inputTextConfirmacao.setErrorEnabled(false);
    }

    @Override
    public void limparDadosDoUsuarioRegistrado() {
        inputEditUsuario.getText().clear();
        inputEditSenha.getText().clear();
        inputEditConfirmacao.getText().clear();
    }

    @Override
    public void sairDoCadastro() {
        this.dismiss();
    }
}
