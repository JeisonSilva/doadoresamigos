package com.jsonapp.doadoresamigos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jsonapp.doadoresamigos.adapters.DoadorAdapter;
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
    private RecyclerView rvDoadores;
    private String codigoDoador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_doador);

        toolbar = findViewById(R.id.toolbar);
        search = findViewById(R.id.search);
        fbAddDoador = findViewById(R.id.fbAddDoador);
        rvDoadores = findViewById(R.id.rvDoadores);

        configurarPesquisaDoador(search);
        setSupportActionBar(toolbar);
        fbAddDoador.setOnClickListener(addDoadorListener);

        pesquisaDoador = new PesquisaDoador(this, new DoadorRepositorioImpl(getBaseContext()));
    }

    @Override
    protected void onStart() {
        super.onStart();

        pesquisaDoador.exibirDoadores();
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
            codigoDoador = query;
            pesquisaDoador.pesquisarDoadorPorCodigo();
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            if(newText.isEmpty())
                pesquisaDoador.exibirDoadores();
            return false;
        }
    };

    @Override
    public void exibirDoador(DoadorDto doadorDto) {
        ArrayList<DoadorDto> doadores = new ArrayList<>(1);
        doadores.add(doadorDto);

        exibirListaDoadores(doadores);
    }

    @Override
    public Integer obterCodigoPesquisa() {
        if(codigoDoador.isEmpty())
            return 0;

        return Integer.valueOf(codigoDoador);
    }

    @Override
    public void notificarUsuarioDePesquisaSemRetornoDeDados() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atenção");
        builder.setMessage(R.string.alertdialog_nao_ha_registro);
        builder.setIcon(R.mipmap.ic_alert_atencao);
        builder.create().show();
    }

    @Override
    public void notificarUsuarioDeCodigoDoadorInvalido() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atenção");
        builder.setMessage(R.string.alertdialog_nao_existe_doador);
        builder.setIcon(R.mipmap.ic_alert_atencao);
        builder.create().show();
    }

    @Override
    public void exibirDoadores(ArrayList<DoadorDto> doadores) {
        exibirListaDoadores(doadores);
    }

    private void exibirListaDoadores(ArrayList<DoadorDto> doadores) {
        DoadorAdapter adapter = new DoadorAdapter(doadores, this, getSupportFragmentManager());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvDoadores.setLayoutManager(layoutManager);
        rvDoadores.setAdapter(adapter);
    }
}
