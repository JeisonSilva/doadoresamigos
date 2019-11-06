package com.jsonapp.doadoresamigos.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    private static final String BANCO_DE_DADOS = "doadoresamigos.db";
    private static final int VERSAO = 1;


    public SqliteHelper(Context context) {
        super(context, BANCO_DE_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableDoadores = "CREATE TABLE IF NOT EXISTS " + TabelaDoador.TABELA +
                "(" +
                TabelaDoador.CAMPO_ID + " INTEGER PRIMARY KEY NOT NULL," +
                TabelaDoador.CAMPO_NOME + " TEXT NOT NULL," +
                TabelaDoador.CAMPO_SOBRENOME + " TEXT NOT NULL," +
                TabelaDoador.CAMPO_IDADE + " INTEGER NOT NULL," +
                TabelaDoador.CAMPO_FATOR_RH + " TEXT NOT NULL," +
                TabelaDoador.CAMPO_TIPO_SANGUINEO + " TEXT NOT NULL," +
                TabelaDoador.CAMPO_PESO +" REAL NOT NULL," +
                TabelaDoador.CAMPO_ALTURA + " REAL NOT NULL" +
                ")";

        String createTableConta = "CREATE TABLE IF NOT EXISTS " + TabelaConta.TABELA + "(" +
                TabelaConta.CAMPO_USUARIO + " TEXT PRIMARY KEY NOT NULL, " +
                TabelaConta.CAMPO_SENHA + " TEXT NOT NULL" +
                ")";
        sqLiteDatabase.execSQL(createTableDoadores);
        sqLiteDatabase.execSQL(createTableConta);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
