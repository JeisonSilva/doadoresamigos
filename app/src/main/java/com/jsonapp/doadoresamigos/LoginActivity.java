package com.jsonapp.doadoresamigos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jsonapp.doadoresamigos.autenticacao.AutenticacaoDal;
import com.jsonapp.doadoresamigos.autenticacao.AutenticacaoUsuario;
import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.autenticacao.ContaRepositorioImpl;

public class LoginActivity extends AppCompatActivity implements AutenticacaoDal {

    private TextInputLayout inputTextUsuario;
    private TextInputEditText inputEditUsuario;
    private TextInputLayout inputTextSenha;
    private TextInputEditText inputEditSenha;
    private AppCompatButton btnInicioSessao;
    private AppCompatButton btnNovoDoador;
    private AutenticacaoUsuario autenticacaoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputTextUsuario = findViewById(R.id.inputTextUsuario);
        inputEditUsuario = findViewById(R.id.inputEditUsuario);
        inputTextSenha = findViewById(R.id.inputTextSenha);
        inputEditSenha = findViewById(R.id.inputEditSenha);

        btnInicioSessao = findViewById(R.id.btnInicioSessao);
        btnNovoDoador = findViewById(R.id.btnNovoUsuario);

        btnInicioSessao.setOnClickListener(iniciarSessaoListener);
        btnNovoDoador.setOnClickListener(criarNovoDoadorListener);

        autenticacaoUsuario = new AutenticacaoUsuario(this, new ContaRepositorioImpl(getBaseContext()));
    }

    View.OnClickListener iniciarSessaoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resetarTela();
            autenticacaoUsuario.autenticar();
        }
    };

    View.OnClickListener criarNovoDoadorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CadastroContaDialog cadastroContaDialog = CadastroContaDialog.newInstance();
            cadastroContaDialog.openDialog(getSupportFragmentManager());
        }
    };

    private void resetarTela() {
        inputTextUsuario.setErrorEnabled(false);
        inputTextUsuario.setError("");

        inputTextSenha.setErrorEnabled(false);
        inputTextSenha.setError("");
    }

    @Override
    public ContaDto obterDadosUsuario() {
        String usuario = String.valueOf(inputEditUsuario.getText());
        String senha = String.valueOf(inputEditSenha.getText());
        ContaDto contaDto= new ContaDto();

        contaDto.setUsuario(usuario);
        contaDto.setSenha(senha);
        return contaDto;
    }

    @Override
    public void exibirPesquisaDoadores() {
        Toast.makeText(this, "Ainda não integramos com pesquisa doador", Toast.LENGTH_LONG).show();
    }

    @Override
    public void notificarUsuarioInvalido() {
        inputTextUsuario.setErrorEnabled(true);
        inputTextUsuario.setError("Usuário inválido");
    }

    @Override
    public void notificarSenhaInvalida() {
        inputTextUsuario.setErrorEnabled(true);
        inputTextUsuario.setError("Senha inválido");
    }

    @Override
    public void notificarUsuarioNaoCadastrado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atenão");
        builder.setMessage("Usuário não cadastrador");
        builder.setIcon(R.mipmap.ic_alert_atencao);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
