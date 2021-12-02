package br.com.diegopatricio.discadorprova2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class recentesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recentes);
    }

    public void abrirLista(View v){
        Intent it = new Intent(this, ListaActivity.class);
        startActivity(it);
    }

    public void cadastrarAluno(View v){
        EditText nomeAluno = findViewById(R.id.edtNomeAluno);
        Aluno a = new Aluno(0, nomeAluno.getText().toString(), "email@email.com", "839875252");

        AlunoDAO alunoDAO = new AlunoDAO(this);
        alunoDAO.adicionar(a);
    }
}