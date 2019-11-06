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

    }

    @Override
    public int getItemCount() {
        return doadores.size();
    }
}
