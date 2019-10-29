package com.jsonapp.doadoresamigos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jsonapp.doadoresamigos.autenticacao.AutenticacaoDal;
import com.jsonapp.doadoresamigos.autenticacao.ContaDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;

public class LoginActivity extends AppCompatActivity implements AutenticacaoDal {

    private TextInputLayout inputTextUsuario;
    private TextInputEditText inputEditUsuario;
    private TextInputLayout inputTextSenha;
    private TextInputEditText inputEditSenha;
    private AppCompatButton btnInicioSessao;
    private AppCompatButton btnNovoDoador;

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

    }

    @Override
    public void notificarUsuarioInvalido() {

    }

    @Override
    public void notificarSenhaInvalida() {

    }
}
