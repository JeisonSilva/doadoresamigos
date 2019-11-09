package com.jsonapp.doadoresamigos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorioImpl;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDal;

public class CadastroDoadorDialog extends AppCompatDialogFragment implements DoadorDal, AlteracaoDoadorDal {

    private static final String DIALOG_TAG = "cadastroDoadorDialog";
    private TextInputLayout inputTextNumeroIdentificador;
    private TextInputLayout inputTextNome;
    private TextInputLayout inputTextSobrenome;
    private TextInputLayout inputTextIdade;
    private TextInputLayout inputTextPeso;
    private TextInputLayout inputTextAltura;
    private TextInputEditText inputEditNumeroIdentificador;
    private TextInputEditText inputEditNome;
    private TextInputEditText inputEditSobrenome;
    private TextInputEditText inputEditIdade;
    private TextInputEditText inputEditPeso;
    private TextInputEditText inputEditALtura;
    private AppCompatSpinner spinnerTipoSanguineo;
    private AppCompatSpinner spinnerFatorRh;
    private AppCompatButton btnRegistro;
    private AppCompatButton btnCancelamento;
    private RegistroDoador registroDoador;
    private PesquisaDoador pesquisaDoador;

    public static CadastroDoadorDialog newInstance() {
        CadastroDoadorDialog fragment = new CadastroDoadorDialog();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_doador, container, false);

        inputTextNumeroIdentificador = view.findViewById(R.id.inputTextNumeroIdentificador);
        inputTextNome = view.findViewById(R.id.inputTextNome);
        inputTextSobrenome = view.findViewById(R.id.inputTextSobrenome);
        inputTextIdade = view.findViewById(R.id.inputTextIdade);
        inputTextPeso = view.findViewById(R.id.inputLayoutPeso);
        inputTextAltura = view.findViewById(R.id.inputTextAltura);

        inputEditNumeroIdentificador = view.findViewById(R.id.inputEditNumeroIdentificador);
        inputEditNome = view.findViewById(R.id.inputEditNome);
        inputEditSobrenome = view.findViewById(R.id.inputEditSobrenome);
        inputEditIdade = view.findViewById(R.id.inputEditIdade);
        inputEditPeso = view.findViewById(R.id.inputEditPeso);
        inputEditALtura = view.findViewById(R.id.inputEditAltura);

        spinnerTipoSanguineo = view.findViewById(R.id.spinnerTipoSanguineo);
        spinnerFatorRh = view.findViewById(R.id.spinnerFatorRh);

        btnRegistro = view.findViewById(R.id.btnRegistrar);
        btnCancelamento = view.findViewById(R.id.btnCancelar);

        btnRegistro.setOnClickListener(registrarListener);
        btnCancelamento.setOnClickListener(cancelarListener);

        registroDoador = new RegistroDoador(this, new DoadorRepositorioImpl(view.getContext()));

        return view;
    }

    View.OnClickListener registrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            registroDoador.registrar();
        }
    };

    View.OnClickListener cancelarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pesquisaDoador.exibirDoadores();
            dismiss();
        }
    };

    public void openDialog(FragmentManager fm){
        if(fm.findFragmentByTag(DIALOG_TAG) == null)
            show(fm, DIALOG_TAG);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pesquisaDoador = new PesquisaDoador((PesquisaDoadorDal) context, new DoadorRepositorioImpl(getContext()));
    }

    @Override
    public DoadorDto obterDadosInformadosPeloUsuario() {
        Integer numeroIdentificacao = Integer.valueOf(inputEditNumeroIdentificador.getText().toString());
        String nome = String.valueOf(inputEditNome.getText());
        String sobrenome = String.valueOf(inputEditSobrenome.getText());
        Integer idade = Integer.parseInt(inputEditIdade.getText().toString());
        Integer peso = Integer.valueOf(inputEditPeso.getText().toString());
        Double altura = Double.parseDouble(inputEditALtura.getText().toString());
        String tipoSanguenio = String.valueOf(spinnerTipoSanguineo.getSelectedItem());
        String fatorRh = String.valueOf(spinnerFatorRh.getSelectedItem());
        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setCodigo(numeroIdentificacao);
        doadorDto.setNome(nome);
        doadorDto.setSobrenome(sobrenome);
        doadorDto.setIdade(idade);
        doadorDto.setPeso(peso);
        doadorDto.setAltura(altura);
        doadorDto.setTipoDeSangue(tipoSanguenio);
        doadorDto.setFatorRh(fatorRh);

        return doadorDto;
    }

    @Override
    public void notificarDadosInvalidos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Falha de validação");
        builder.setMessage("Dados inválidos");
        builder.create().show();
    }

    @Override
    public void finalizarCadastro() {
        pesquisaDoador.exibirDoadores();
        dismiss();
    }

    @Override
    public boolean validarPreenchimentoDados() {
        limparCorrecoesDeErros();

        if(inputEditNumeroIdentificador.getText().toString().isEmpty()){
            this.notificarCodigoIdentificacao();
            return false;
        }

        if(inputEditNome.getText().toString().isEmpty()){
            this.notificarNomeInvalido();
            return false;
        }

        if(inputEditSobrenome.getText().toString().isEmpty()){
            this.notificarSobrenome();
            return false;
        }

        if(inputEditIdade.getText().toString().isEmpty()){
            this.norificarIdadeInvalida();
            return false;
        }

        if(spinnerTipoSanguineo.getSelectedItemPosition() == 0){
            this.notificarTipoSanguineoInvalido();
            return false;
        }

        if(spinnerFatorRh.getSelectedItemPosition() == 0){
            this.notificarFatorRhInvalido();
            return false;
        }

        if(inputEditPeso.getText().toString().isEmpty()){
            this.notificarPesoInvalido();
            return false;
        }

        if(inputEditALtura.getText().toString().isEmpty()){
            this.notificarAlturaInvalida();
            return false;
        }

        return true;
    }

    private void limparCorrecoesDeErros() {
        inputTextNumeroIdentificador.setErrorEnabled(false);
        inputTextNome.setErrorEnabled(false);
        inputTextSobrenome.setErrorEnabled(false);
        inputTextIdade.setErrorEnabled(false);
        inputTextPeso.setErrorEnabled(false);
        inputTextAltura.setErrorEnabled(false);
    }

    private void notificarCodigoIdentificacao() {
        inputTextNumeroIdentificador.setErrorEnabled(true);
        inputTextNumeroIdentificador.setError("Código não pode ser nulo");
    }

    @Override
    public DoadorDto obterDadosDoador() {
        return obterDadosInformadosPeloUsuario();
    }

    public void notificarNomeInvalido() {
        inputTextNome.setErrorEnabled(true);
        inputTextNome.setError("Nome inválido");
    }

    public void notificarSobrenome() {
        inputTextSobrenome.setErrorEnabled(true);
        inputTextSobrenome.setError("Sobrenome inválido");
    }

    public void norificarIdadeInvalida() {
        inputTextIdade.setErrorEnabled(true);
        inputTextIdade.setError("Idade inválido");
    }

    public void notificarAlturaInvalida() {
        inputTextAltura.setErrorEnabled(true);
        inputTextAltura.setError("Altura inválido");
    }

    public void notificarFatorRhInvalido() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Escolha de opção");
        builder.setMessage("Escolha uma opção Fator RH");

        builder.create().show();
    }

    public void notificarTipoSanguineoInvalido() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Escolha de opção");
        builder.setMessage("Escolha um tipo sanguineo");

        builder.create().show();
    }

    public void notificarPesoInvalido() {
        inputTextAltura.setErrorEnabled(true);
        inputTextAltura.setError("Peso inválido");
    }
}
