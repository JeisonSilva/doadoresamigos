package com.jsonapp.doadoresamigos.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class BaseRepositorio extends SQLiteOpenHelper {
    protected static final String BANCO_DE_DADOS = "doadoresamigos.db";
    protected static final int VERSAO = 1;

    public BaseRepositorio(Context context) {
        super(context, BANCO_DE_DADOS, null, VERSAO);
    }
}
