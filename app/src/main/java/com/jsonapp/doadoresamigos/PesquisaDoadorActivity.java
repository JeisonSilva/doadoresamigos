package com.jsonapp.doadoresamigos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

public class PesquisaDoadorActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_doador);

        toolbar = findViewById(R.id.toolbar);
        search = findViewById(R.id.search);
        search.setQueryHint(getString(R.string.hint_titulo_pesquisa_doador));
        search.setActivated(true);
        search.onActionViewExpanded();
        search.setIconified(false);
        search.clearFocus();
        search.setOnQueryTextListener(queryListener);

        setSupportActionBar(toolbar);


    }

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
}
