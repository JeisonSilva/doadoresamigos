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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorioImpl;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoadorDal;

public class AtualizacaoCadastroDialog extends AppCompatDialogFragment implements DoadorDal {

    private static final String DIALOG_TAG = "AtualizacaoCadastroDialog";
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
    private AlteracaoDoador alteracaoDoador;
    private PesquisaDoador pesquisaDoador;
    private AppCompatTextView textViewTitulo;

    public static AtualizacaoCadastroDialog newInstance(Bundle args) {

        AtualizacaoCadastroDialog fragment = new AtualizacaoCadastroDialog();
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
        View view = inflater.inflate(R.layout.fragment_cadastro_doador, container, false);
        textViewTitulo = view.findViewById(R.id.textview_cadastro_doador_titulo);
        inputTextNumeroIdentificador = view.findViewById(R.id.inputTextNumeroIdentificador);
        inputTextNumeroIdentificador.setEnabled(false);
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
        textViewTitulo.setText(getString(R.string.titulo_edicao_doador));

        this.alteracaoDoador = new AlteracaoDoador(this, new DoadorRepositorioImpl(getContext()));
        carregarDadosParaAlteracao(getArguments());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pesquisaDoador = new PesquisaDoador((PesquisaDoadorDal) context, new DoadorRepositorioImpl(getContext()));
    }

    private void carregarDadosParaAlteracao(Bundle bundle) {
        DoadorDto doadorDto = (DoadorDto) bundle.getSerializable("doador");
        inputEditNumeroIdentificador.setText(String.valueOf(doadorDto.getCodigo()));
        inputEditNome.setText(doadorDto.getNome());
        inputEditSobrenome.setText(doadorDto.getSobrenome());
        inputEditIdade.setText(String.valueOf(doadorDto.getIdade()));
        inputEditPeso.setText(String.valueOf(doadorDto.getPeso()));
        inputEditALtura.setText(String.valueOf(doadorDto.getAltura()));

    }

    View.OnClickListener registrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            alteracaoDoador.alterar();
        }
    };

    View.OnClickListener cancelarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    };

    @Override
    public DoadorDto obterDadosInformadosPeloUsuario() {
        int id = Integer.parseInt(String.valueOf(inputEditNumeroIdentificador.getText()));
        String nome = String.valueOf(inputEditNome.getText());
        String sobrenome = String.valueOf(inputEditSobrenome.getText());
        int idade = Integer.parseInt(String.valueOf(inputEditIdade.getText()));
        String tipoSanguineo = String.valueOf(spinnerTipoSanguineo.getSelectedItem());
        String fatorRh = String.valueOf(spinnerFatorRh.getSelectedItem());
        double peso = Double.parseDouble(String.valueOf(inputEditPeso.getText()));
        double altura = Double.parseDouble(String.valueOf(inputEditALtura.getText()));


        DoadorDto doadorDto = new DoadorDto();
        doadorDto.setCodigo(id);
        doadorDto.setNome(nome);
        doadorDto.setSobrenome(sobrenome);
        doadorDto.setIdade(idade);
        doadorDto.setTipoDeSangue(tipoSanguineo);
        doadorDto.setFatorRh(fatorRh);
        doadorDto.setPeso(peso);
        doadorDto.setAltura(altura);
        return doadorDto;
    }

    @Override
    public DoadorDto obterDadosDoador() {
        return obterDadosInformadosPeloUsuario();
    }

    @Override
    public void notificarDadosInvalidos() {

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
        inputTextNumeroIdentificador.setError(getString(R.string.codigo_doador_nulo));
    }

    private void notificarNomeInvalido() {
        inputTextNome.setErrorEnabled(true);
        inputTextNome.setError(getString(R.string.nome_invalido));
    }

    private void notificarSobrenome() {
        inputTextSobrenome.setErrorEnabled(true);
        inputTextSobrenome.setError(getString(R.string.sobrenome_invalido));
    }

    private void norificarIdadeInvalida() {
        inputTextIdade.setErrorEnabled(true);
        inputTextIdade.setError(getString(R.string.idade_invalida));
    }

    private void notificarAlturaInvalida() {
        inputTextAltura.setErrorEnabled(true);
        inputTextAltura.setError("Altura inválido");
    }

    private void notificarFatorRhInvalido() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.alert_fator_rh_titulo));
        builder.setMessage(getString(R.string.alert_fator_rh_mensagem));

        builder.create().show();
    }

    private void notificarTipoSanguineoInvalido() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.alert_tipo_sanguineo_titulo));
        builder.setMessage(getString(R.string.alert_tipo_sanguineo_mensagem));

        builder.create().show();
    }

    private void notificarPesoInvalido() {
        inputTextAltura.setErrorEnabled(true);
        inputTextAltura.setError(getString(R.string.pesso_invalido));
    }
}
