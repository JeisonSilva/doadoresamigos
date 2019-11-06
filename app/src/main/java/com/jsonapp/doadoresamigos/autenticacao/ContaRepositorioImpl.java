package com.jsonapp.doadoresamigos.autenticacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jsonapp.doadoresamigos.utils.SqliteHelper;
import com.jsonapp.doadoresamigos.utils.TabelaConta;

public class ContaRepositorioImpl implements ContaRepositorio {


    private final SqliteHelper sqliteHelper;

    public ContaRepositorioImpl(Context context) {
        sqliteHelper = new SqliteHelper(context);
    }

    @Override
    public void registrar(ContaDto contaDto) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TabelaConta.CAMPO_USUARIO, contaDto.getUsuario());
        values.put(TabelaConta.CAMPO_SENHA, contaDto.getSenha());
        sqLiteDatabase.insert(TabelaConta.TABELA, null, values);
        sqLiteDatabase.close();
    }

    @Override
    public void alterar(ContaDto contaDto) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TabelaConta.CAMPO_USUARIO, contaDto.getUsuario());
        values.put(TabelaConta.CAMPO_SENHA, contaDto.getSenha());
        sqLiteDatabase.update(TabelaConta.TABELA, values, "USUARIO=?", new String[]{contaDto.getUsuario()});
        sqLiteDatabase.close();
    }

    @Override
    public ContaDto obterConta(ContaDto contaDto) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();
        ContaDto conta = new ContaDto();

        Cursor c = sqLiteDatabase.query(TabelaConta.TABELA, new String[]{TabelaConta.CAMPO_USUARIO, TabelaConta.CAMPO_SENHA}, "USUARIO=?",
                new String[]{contaDto.getUsuario()}, null, null, null);

        if(c.moveToFirst()){
            String usuario = c.getString(c.getColumnIndex(TabelaConta.CAMPO_USUARIO));
            String senha = c.getString(c.getColumnIndex(TabelaConta.CAMPO_SENHA));
            conta.setUsuario(usuario);
            conta.setSenha(senha);
        }
        c.close();
        sqLiteDatabase.close();
        return conta;
    }

    @Override
    public void excluirConta(ContaDto contaDto) {

    }
}
