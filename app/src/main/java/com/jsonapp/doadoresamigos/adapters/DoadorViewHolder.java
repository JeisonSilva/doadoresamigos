package com.jsonapp.doadoresamigos.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.jsonapp.doadoresamigos.R;

public class DoadorViewHolder extends RecyclerView.ViewHolder {
    public final AppCompatTextView textViewNome;
    public final AppCompatTextView textViewId;
    public final AppCompatTextView textViewIdade;
    public final AppCompatTextView textViewTipoDeSangue;
    public final AppCompatTextView textViewCondicoesFisicas;

    public DoadorViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewNome = itemView.findViewById(R.id.textViewNome);
        textViewId = itemView.findViewById(R.id.textViewIdentificador);
        textViewIdade = itemView.findViewById(R.id.textViewIdade);
        textViewTipoDeSangue = itemView.findViewById(R.id.textViewDadosSanguineos);
        textViewCondicoesFisicas = itemView.findViewById(R.id.textViewPesoAltura);

    }
}
