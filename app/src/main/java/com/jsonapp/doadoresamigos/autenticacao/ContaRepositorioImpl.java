package com.jsonapp.doadoresamigos.autenticacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrinterId;

public class ContaRepositorioImpl extends SQLiteOpenHelper implements ContaRepositorio {
    private static final String BANCO_DE_DADOS = "doadoresamigos.db";
    private static final int VERSAO = 1;

    private static final String CAMPO_USUARIO = "USUARIO";
    private static final String CAMPO_SENHA = "SENHA";
    private static final String TABELA = "CONTA";

    public ContaRepositorioImpl(Context context) {
        super(context, TABELA , null, VERSAO);
    }

    @Override
    public void registrar(ContaDto contaDto) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CAMPO_USUARIO, contaDto.getUsuario());
        values.put(CAMPO_SENHA, contaDto.getSenha());
        sqLiteDatabase.insert(TABELA, null, values);
        sqLiteDatabase.close();
    }

    @Override
    public void alterar(ContaDto contaDto) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CAMPO_USUARIO, contaDto.getUsuario());
        values.put(CAMPO_SENHA, contaDto.getSenha());
        sqLiteDatabase.update(TABELA, values, "USUARIO=?", new String[]{contaDto.getUsuario()});
        sqLiteDatabase.close();
    }

    @Override
    public ContaDto obterConta(ContaDto contaDto) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContaDto conta = new ContaDto();

        Cursor c = sqLiteDatabase.query(TABELA, new String[]{CAMPO_USUARIO, CAMPO_SENHA}, "USUARIO=?",
                new String[]{contaDto.getUsuario()}, null, null, null);

        if(c.moveToFirst()){
            String usuario = c.getString(c.getColumnIndex(CAMPO_USUARIO));
            String senha = c.getString(c.getColumnIndex(CAMPO_SENHA));
            conta.setUsuario(usuario);
            conta.setSenha(senha);
        }

        c.close();
        return conta;
    }

    @Override
    public void excluirConta(ContaDto contaDto) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABELA + "(" +
                        CAMPO_USUARIO + " TEXT NOT NULL, " +
                        CAMPO_SENHA + " TEXT NOT NULL" +
                        ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
