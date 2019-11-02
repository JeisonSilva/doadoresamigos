package com.jsonapp.doadoresamigos.gestaodoadores;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jsonapp.doadoresamigos.utils.BaseRepositorio;

public class DoadorRepositorioImpl extends BaseRepositorio implements DoadorRepositorio {

    public DoadorRepositorioImpl(Context context) {
        super(context);
    }

    @Override
    public DoadorDto pesquisarPorCodigo(Integer codDoador) {
        return null;
    }

    @Override
    public void excluir(DoadorDto doadorDto) {

    }

    @Override
    public void registrar(DoadorDto doadorDto) {

    }

    @Override
    public Void alterar(DoadorDto doadorDto) {
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
