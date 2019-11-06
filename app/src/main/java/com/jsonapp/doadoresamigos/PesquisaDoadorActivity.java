package com.jsonapp.doadoresamigos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorioImpl;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoadorDal;

import java.util.ArrayList;

public class PesquisaDoadorActivity extends AppCompatActivity implements PesquisaDoadorDal {

    private Toolbar toolbar;
    private SearchView search;
    private FloatingActionButton fbAddDoador;
    private PesquisaDoador pesquisaDoador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_doador);

        toolbar = findViewById(R.id.toolbar);
        search = findViewById(R.id.search);
        fbAddDoador = findViewById(R.id.fbAddDoador);

        configurarPesquisaDoador(search);
        setSupportActionBar(toolbar);
        fbAddDoador.setOnClickListener(addDoadorListener);

        pesquisaDoador = new PesquisaDoador(this, new DoadorRepositorioImpl(getBaseContext()));
    }

    private void configurarPesquisaDoador(SearchView search) {
        search.setQueryHint(getString(R.string.hint_titulo_pesquisa_doador));
        search.setActivated(true);
        search.onActionViewExpanded();
        search.setIconified(false);
        search.clearFocus();
        search.setOnQueryTextListener(queryListener);
    }

    View.OnClickListener addDoadorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CadastroDoadorDialog cadastroDoadorDialog = CadastroDoadorDialog.newInstance();
            cadastroDoadorDialog.openDialog(getSupportFragmentManager());
        }
    };

    SearchView.OnQueryTextListener queryListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    @Override
    public void exibirDoador(DoadorDto doadorDto) {

    }

    @Override
    public Integer obterCodigoPesquisa() {
        return null;
    }

    @Override
    public void notificarUsuarioDePesquisaSemRetornoDeDados() {

    }

    @Override
    public void notificarUsuarioDeCodigoDoadorInvalido() {

    }

    @Override
    public void exibirDoadores(ArrayList<DoadorDto> doadores) {
        
    }
}
