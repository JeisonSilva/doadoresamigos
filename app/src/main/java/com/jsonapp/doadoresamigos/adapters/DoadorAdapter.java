package com.jsonapp.doadoresamigos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jsonapp.doadoresamigos.R;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;

import java.util.ArrayList;

public class DoadorAdapter extends RecyclerView.Adapter<DoadorViewHolder> {

    private final ArrayList<DoadorDto> doadores;

    public DoadorAdapter(ArrayList<DoadorDto> doadores) {
        this.doadores = doadores;
    }

    @NonNull
    @Override
    public DoadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleview_card_doador, parent, false);
        return new DoadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoadorViewHolder holder, int position) {
        String nome = doadores.get(position).getNome();
        String id = String.format("Id: %o", doadores.get(position).getCodigo());
        String idade = String.format("Idade: %o anos", doadores.get(position).getIdade());
        String sangue = String.format("Sangue %s %s", doadores.get(position).getTipoDeSangue(), doadores.get(position).getFatorRh());
        String condicoesFisicas = String.format("Peso: %f Altura: %f", doadores.get(position).getPeso(), doadores.get(position).getAltura());

        holder.textViewNome.setText(nome);
        holder.textViewId.setText(id);
        holder.textViewIdade.setText(idade);
        holder.textViewTipoDeSangue.setText(sangue);
        holder.textViewCondicoesFisicas.setText(condicoesFisicas);
    }



    @Override
    public int getItemCount() {
        return doadores.size();
    }
}
