package com.jsonapp.doadoresamigos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.RegistroDoadorDal;

public class CadastroDoadorDialog extends AppCompatDialogFragment implements RegistroDoadorDal, AlteracaoDoadorDal {

    private static final String DIALOG_TAG = "cadastroDoadorDialog";

    public static CadastroDoadorDialog newInstance() {
        CadastroDoadorDialog fragment = new CadastroDoadorDialog();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_doador, container, false);
        return view;
    }

    public void openDialog(FragmentManager fm){
        if(fm.findFragmentByTag(DIALOG_TAG) == null)
            show(fm, DIALOG_TAG);
    }

    @Override
    public DoadorDto obterDadosInformadosPeloUsuario() {
        return null;
    }

    @Override
    public void notificarDadosInvalidos() {

    }

    @Override
    public DoadorDto obterDadosDoador() {
        return null;
    }

    @Override
    public void notificarNomeInvalido() {

    }

    @Override
    public void notificarSobrenome() {

    }

    @Override
    public void norificarIdadeInvalida() {

    }

    @Override
    public void notificarAlturaInvalida() {

    }

    @Override
    public void notificarFatorRhInvalido() {

    }

    @Override
    public void notificarTipoSanguineoInvalido() {

    }

    @Override
    public void notificarPesoInvalido() {

    }
}
