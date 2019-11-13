package com.jsonapp.doadoresamigos.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jsonapp.doadoresamigos.AtualizacaoCadastroDialog;
import com.jsonapp.doadoresamigos.R;
import com.jsonapp.doadoresamigos.gestaodoadores.AlteracaoDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorDto;
import com.jsonapp.doadoresamigos.gestaodoadores.DoadorRepositorioImpl;
import com.jsonapp.doadoresamigos.gestaodoadores.ExclusaoDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.ExclusaoDoadorDal;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoador;
import com.jsonapp.doadoresamigos.gestaodoadores.PesquisaDoadorDal;

import java.util.ArrayList;

public class DoadorAdapter extends RecyclerView.Adapter<DoadorViewHolder> implements ExclusaoDoadorDal {

    private final ArrayList<DoadorDto> doadores;
    private final Context context;
    private final FragmentManager fm;
    private ExclusaoDoador exclusaoDoador;
    private DoadorViewHolder holder;
    private DoadorDto doador;
    private AlteracaoDoador alteracaoDoador;

    public DoadorAdapter(ArrayList<DoadorDto> doadores, Context context, FragmentManager fm) {
        this.doadores = doadores;
        this.context = context;
        this.fm = fm;
    }

    @NonNull
    @Override
    public DoadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleview_card_doador, parent, false);
        return new DoadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoadorViewHolder holder, final int position) {
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

        exclusaoDoador = new ExclusaoDoador(this, new DoadorRepositorioImpl(this.context));

        holder.imgViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putSerializable("doador", doadores.get(position));
                AtualizacaoCadastroDialog cadastroDialog = AtualizacaoCadastroDialog.newInstance(args);
                cadastroDialog.openDialog(fm);
            }
        });
        holder.imgViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doador = doadores.get(position);
                exclusaoDoador.excluirDoador();
            }
        });


    }

    @Override
    public int getItemCount() {
        return doadores.size();
    }

    @Override
    public Integer obterCodigoDoador() {
        return doador.getCodigo();
    }

    @Override
    public void notificarCodigoInvalido() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Atenção");
        builder.setIcon(R.mipmap.ic_alert_atencao);
        builder.setMessage(R.string.alertdialog_codigoinvalido);
        builder.create().show();
    }

    @Override
    public void notificarUsuarioInexistente() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Atenção");
        builder.setIcon(R.mipmap.ic_alert_atencao);
        builder.setMessage(R.string.alertdialog_codigoinexistente);
        builder.create().show();
    }

    @Override
    public void exibirNovaLista(ArrayList<DoadorDto> doadores) {
        PesquisaDoadorDal pesquisaDoadorDal = (PesquisaDoadorDal) context;
        pesquisaDoadorDal.exibirDoadores(doadores);
    }
}
