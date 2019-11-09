package com.jsonapp.doadoresamigos.gestaodoadores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jsonapp.doadoresamigos.utils.SqliteHelper;

import java.util.ArrayList;

import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_ALTURA;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_FATOR_RH;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_ID;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_IDADE;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_NOME;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_PESO;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_SOBRENOME;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.CAMPO_TIPO_SANGUINEO;
import static com.jsonapp.doadoresamigos.utils.TabelaDoador.TABELA;

public class DoadorRepositorioImpl implements DoadorRepositorio {

    private final SqliteHelper sqliteHelper;

    public DoadorRepositorioImpl(Context context) {
        sqliteHelper = new SqliteHelper(context);
    }

    @Override
    public DoadorDto pesquisarPorCodigo(Integer codDoador) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query( TABELA, new String[]{
                CAMPO_ID,
                CAMPO_NOME,
                CAMPO_SOBRENOME,
                CAMPO_IDADE,
                CAMPO_FATOR_RH,
                CAMPO_TIPO_SANGUINEO,
                CAMPO_PESO,
                CAMPO_ALTURA}, CAMPO_ID + "=?", new String[]{String.valueOf(codDoador)}, null, null, null);

        if(cursor.moveToFirst()){
            DoadorDto doadorDto = new DoadorDto();
            doadorDto.setCodigo(cursor.getInt(cursor.getColumnIndex(CAMPO_ID)));
            doadorDto.setNome(cursor.getString(cursor.getColumnIndex(CAMPO_NOME)));
            doadorDto.setSobrenome(cursor.getString(cursor.getColumnIndex(CAMPO_SOBRENOME)));
            doadorDto.setIdade(cursor.getInt(cursor.getColumnIndex(CAMPO_IDADE)));
            doadorDto.setFatorRh(cursor.getString(cursor.getColumnIndex(CAMPO_FATOR_RH)));
            doadorDto.setTipoDeSangue(cursor.getString(cursor.getColumnIndex(CAMPO_TIPO_SANGUINEO)));
            doadorDto.setPeso(cursor.getDouble(cursor.getColumnIndex(CAMPO_PESO)));
            doadorDto.setAltura(cursor.getInt(cursor.getColumnIndex(CAMPO_ALTURA)));

            return doadorDto;
        }

        return null;
    }

    @Override
    public void excluir(DoadorDto doadorDto) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            ContentValues values = gerarValoresParaGravarDados(doadorDto);
            sqLiteDatabase.delete(TABELA, CAMPO_ID + "=?", new String[]{String.valueOf(doadorDto.getCodigo())});
        }catch (Exception ex){
            sqLiteDatabase.close();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }

    @Override
    public void registrar(DoadorDto doadorDto) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues values = gerarValoresParaGravarDados(doadorDto);
        sqLiteDatabase.insert(TABELA, null, values);

        sqLiteDatabase.close();
    }

    @Override
    public void alterar(DoadorDto doadorDto) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getWritableDatabase();

        try{
            sqLiteDatabase.beginTransaction();
            ContentValues values = gerarValoresParaGravarDados(doadorDto);
            sqLiteDatabase.update(TABELA, values, CAMPO_ID + "=?", new String[]{String.valueOf(doadorDto.getCodigo())});
        }catch (Exception ex){
            sqLiteDatabase.close();
        }finally {
            sqLiteDatabase.endTransaction();
            sqLiteDatabase.close();
        }
    }

    @Override
    public ArrayList<DoadorDto> listarDoadores() {
        ArrayList<DoadorDto> doadores = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();
        String[] colunas = {
                CAMPO_NOME,
                CAMPO_ID,
                CAMPO_IDADE,
                CAMPO_TIPO_SANGUINEO,
                CAMPO_FATOR_RH,
                CAMPO_PESO,
                CAMPO_ALTURA};

        Cursor cursor = sqLiteDatabase.query(TABELA, colunas, null, null, null, null, null);
        cursor.moveToFirst();

        do {
            DoadorDto doadorDto = new DoadorDto();

            String nome = cursor.getString(cursor.getColumnIndex(CAMPO_NOME));
            Integer codigoDoador = cursor.getInt(cursor.getColumnIndex(CAMPO_ID));
            Integer idade = cursor.getInt(cursor.getColumnIndex(CAMPO_IDADE));
            String tipoSanguineo = cursor.getString(cursor.getColumnIndex(CAMPO_TIPO_SANGUINEO));
            String fatorRh = cursor.getString(cursor.getColumnIndex(CAMPO_FATOR_RH));
            double peso = cursor.getInt(cursor.getColumnIndex(CAMPO_PESO));
            double altura = cursor.getInt(cursor.getColumnIndex(CAMPO_ALTURA));

            doadorDto.setNome(nome);
            doadorDto.setCodigo(codigoDoador);
            doadorDto.setIdade(idade);
            doadorDto.setTipoDeSangue(tipoSanguineo);
            doadorDto.setFatorRh(fatorRh);
            doadorDto.setPeso(peso);
            doadorDto.setAltura(altura);

            doadores.add(doadorDto);

        }while (cursor.moveToNext());

        return doadores;
    }

    private ContentValues gerarValoresParaGravarDados(DoadorDto doadorDto) {
        ContentValues values = new ContentValues();
        values.put(CAMPO_ID, doadorDto.getCodigo());
        values.put(CAMPO_NOME, doadorDto.getNome());
        values.put(CAMPO_SOBRENOME, doadorDto.getSobrenome());
        values.put(CAMPO_IDADE, doadorDto.getIdade());
        values.put(CAMPO_FATOR_RH, doadorDto.getFatorRh());
        values.put(CAMPO_TIPO_SANGUINEO, doadorDto.getTipoDeSangue());
        values.put(CAMPO_PESO, doadorDto.getPeso());
        values.put(CAMPO_ALTURA, doadorDto.getAltura());

        return values;
    }
}
