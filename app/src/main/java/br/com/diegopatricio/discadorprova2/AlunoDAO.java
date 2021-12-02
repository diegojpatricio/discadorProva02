package br.com.diegopatricio.discadorprova2;

import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class AlunoDAO extends SQLiteOpenHelper {

    public static final String BANCO_DADOS = "db_escolar";
    public static final int VERSAO = 1;
    public static final String SCRPIT_TABELA_ALUNO = "create table aluno (_id integer primary key autoincrement, nome text, email text, telefone text)";
    public static final String TABELA_ALUNO = "aluno";
    private Context context;


    public AlunoDAO(@Nullable Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRPIT_TABELA_ALUNO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoNova) {

    }

    public Boolean adicionar(Aluno a){
        try{

            SQLiteDatabase db = getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put("nome", a.getNome());
            cv.put("email", a.getEmail());
            cv.put("telefone", a.getTelefone());

           db.insert(TABELA_ALUNO, null, cv);
        } catch (Exception e){
            return  false;
        }
        return true;
    }
}
